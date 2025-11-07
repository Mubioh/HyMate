package com.mubioh.hymate.client;

import com.mubioh.hymate.features.FeatureRegistry;
import com.mubioh.hymate.settings.HymateOptions;
import com.mubioh.hymate.settings.HymateSettingsScreen;
import com.mubioh.hymate.settings.config.Config;
import com.mubioh.hymate.utils.KeybindUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HymateClient implements ClientModInitializer {
    public static Config config;

    @Override
    public void onInitializeClient() {
        config = Config.load();
        HymateOptions.applyConfig(config);

        ClientTickEvents.END_CLIENT_TICK.register(new ClientTickEvents.EndTick() {
            private boolean configApplied = false;

            @Override
            public void onEndTick(MinecraftClient client) {
                if (!configApplied && client.options != null) {
                    HymateOptions.applyConfig(config);
                    configApplied = true;
                }
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (InputUtil.isKeyPressed(client.getWindow(), GLFW.GLFW_KEY_RIGHT_CONTROL)) {
                client.setScreen(new HymateSettingsScreen(null, client.options));
            }
        });

        KeybindUtils.registerAll();
        FeatureRegistry.initialize();
    }
}