package com.mubioh.hymate.mixin;

import com.mubioh.hymate.client.HymateClient;
import com.mubioh.hymate.utils.ServerUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.s2c.play.ChatMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ClientPlayNetworkHandler.class)
public class AutoChatMixin {
    private long lastTriggeredTime = 0;

    private static final List<String> GG_TRIGGERS = List.of(
            "Your Overall Winstreak:",
            "1st Place -",
            "1st Killer -",
            " - Damage Dealt -",
            "Winning Team -",
            "1st -",
            "Winners:",
            "Winner:",
            "Winning Team:",
            " won the game!",
            "Top Seeker:",
            "1st Place:",
            "Last team standing!",
            "Winner #1 (",
            "Top Survivors",
            "Winners -",
            "Sumo Duel -",
            "Most Wool Placed -",
            "This game has been recorded."
    );

    private void handleMessage(Text text) {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;

        if (text == null || player == null || !HymateClient.config.autoGG) return;

        String message = ServerUtils.stripFormatting(text.getString());

        if (!message.startsWith(" ")) {
            return;
        }

        for (String trigger : GG_TRIGGERS) {
            if (message.contains(trigger)) {
                long now = System.currentTimeMillis();
                if (now - lastTriggeredTime < 5000) {
                    return;
                }
                lastTriggeredTime = now;

                int delaySeconds = HymateClient.config.autoGGCooldown;

                new Thread(() -> {
                    try {
                        Thread.sleep(delaySeconds * 1000L);
                        client.execute(() -> {
                            ClientPlayerEntity delayedPlayer = client.player;
                            if (delayedPlayer != null) {
                                delayedPlayer.networkHandler.sendChatMessage("gg");
                            }
                        });
                    } catch (InterruptedException ignored) {}
                }).start();

                break;
            }
        }
    }

    @Inject(method = "onGameMessage", at = @At("TAIL"))
    private void onGameMessage(GameMessageS2CPacket packet, CallbackInfo ci) {
        if (!ServerUtils.isOnHypixel()) return;
        handleMessage(packet.content());
    }

    @Inject(method = "onChatMessage", at = @At("TAIL"))
    private void onChatMessage(ChatMessageS2CPacket packet, CallbackInfo ci) {
        if (!ServerUtils.isOnHypixel()) return;
        handleMessage(packet.unsignedContent());
    }
}