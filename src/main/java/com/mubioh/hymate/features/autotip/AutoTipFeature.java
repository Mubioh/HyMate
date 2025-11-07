package com.mubioh.hymate.features.autotip;

import com.mubioh.hymate.features.Feature;
import com.mubioh.hymate.settings.HymateOptions;
import com.mubioh.hymate.utils.ServerUtils;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class AutoTipFeature implements Feature {

    private int tickCounter = 0;
    private static final int INTERVAL_TICKS = 20 * 60 * 15;

    @Override
    public void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            boolean enabled = HymateOptions.AUTO_TIP.getValue();

            if (!enabled || !ServerUtils.isOnHypixel()) return;

            tickCounter++;
            if (tickCounter >= INTERVAL_TICKS) {
                tickCounter = 0;
                client.player.networkHandler.sendChatCommand("tipall");
            }
        });
    }
}
