package com.mubioh.hymate.utils;

import com.mubioh.hymate.features.clickaction.ClickActionFeature;
import com.mubioh.hymate.features.gamequeue.GameQueueFeature;
import com.mubioh.hymate.settings.HymateOptions;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class KeybindUtils {
    private static final Map<KeyBinding, Consumer<MinecraftClient>> BINDINGS = new LinkedHashMap<>();
    private static final KeyBinding.Category CATEGORY = KeyBinding.Category.create(Identifier.of("hymate.hypixel_games"));

    public static void registerAll() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (Map.Entry<KeyBinding, Consumer<MinecraftClient>> entry : BINDINGS.entrySet()) {
                if (entry.getKey().wasPressed()) {
                    entry.getValue().accept(client);
                }
            }
        });

        addMouseKeybind("key.hymate.player_action", GLFW.GLFW_MOUSE_BUTTON_MIDDLE, client -> {
            if (client.player != null && client.getNetworkHandler() != null && ServerUtils.isOnHypixel()) {
                ClickActionFeature.onClick(client);
            }
        });

        addMouseKeybind("key.hymate.queue", GLFW.GLFW_MOUSE_BUTTON_5, client -> {
            if (client.player != null && client.getNetworkHandler() != null && ServerUtils.isOnHypixel()) {
                String selectedCommand = GameQueueFeature.GAME_MODE_COMMANDS.get(HymateOptions.SELECTED_GAME.getValue());
                String command = "play " + selectedCommand;

                client.player.networkHandler.sendChatCommand(command);
            }
        });
    }

    public static KeyBinding addKeybind(String name, int glfwKey, Consumer<MinecraftClient> callback) {
        return addKeybind(name, InputUtil.Type.KEYSYM, glfwKey, callback);
    }

    public static KeyBinding addMouseKeybind(String name, int mouseButton, Consumer<MinecraftClient> callback) {
        return addKeybind(name, InputUtil.Type.MOUSE, mouseButton, callback);
    }

    public static KeyBinding addKeybind(String name, InputUtil.Type type, int code, Consumer<MinecraftClient> callback) {
        KeyBinding keyBind = new KeyBinding(name, type, code, CATEGORY);
        KeyBindingHelper.registerKeyBinding(keyBind);
        BINDINGS.put(keyBind, callback);
        return keyBind;
    }
}
