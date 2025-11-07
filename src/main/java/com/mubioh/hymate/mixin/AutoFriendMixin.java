package com.mubioh.hymate.mixin;

import com.mubioh.hymate.client.HymateClient;
import com.mubioh.hymate.utils.ServerUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.ChatMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mixin(ClientPlayNetworkHandler.class)
public class AutoFriendMixin {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("\\b[a-zA-Z0-9_]{3,16}\\b");

    @Inject(method = "onGameMessage", at = @At("TAIL"))
    private void onGameMessage(GameMessageS2CPacket packet, CallbackInfo ci) {
        try {
            handlePacketText(packet.content(), "GameMessage");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Inject(method = "onChatMessage", at = @At("TAIL"))
    private void onChatMessage(ChatMessageS2CPacket packet, CallbackInfo ci) {
        try {
            handlePacketText(packet.unsignedContent(), "ChatMessage");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void handlePacketText(Text text, String source) {
        if (text == null) return;
        if (!ServerUtils.isOnHypixel()) return;
        if (!HymateClient.config.autoAcceptFriendRequests) return;
        if (MinecraftClient.getInstance().player == null) return;

        String raw = text.getString();
        System.out.println("[" + source + "] raw: " + raw);

        String stripped = ServerUtils.stripFormatting(raw).trim();
        System.out.println("[" + source + "] stripped: " + stripped.replace("\n", "\\n"));

        if (!stripped.toLowerCase().contains("friend request from")) {
            return;
        }

        String after = stripped.replaceFirst("(?i).*friend request from", "").trim();

        after = after.replaceAll("\\[[^]]*]", "").trim();

        Matcher m = USERNAME_PATTERN.matcher(after);
        if (m.find()) {
            String playerName = m.group();
            System.out.println("Found friend request from: " + playerName);
            MinecraftClient.getInstance().player.networkHandler.sendChatCommand("friend accept " + playerName);
        } else {
            System.out.println("Could not find username in: " + after.replace("\n", "\\n"));
        }
    }
}
