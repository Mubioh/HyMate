package com.mubioh.hymate.settings;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class HymateSettingsScreen extends GameOptionsScreen {
    public HymateSettingsScreen(Screen parent, GameOptions gameOptions) {
            super(parent, gameOptions, Text.literal("Hymate Settings"));
    }

    @Override
    protected void addOptions() {
        this.body.addAll(
                HymateOptions.CLICK_ACTION_MODE,
                HymateOptions.SHOW_OWN_NAMETAG
        );
        this.body.addSingleOptionEntry(HymateOptions.SELECTED_GAME);
        this.body.addAll(
                HymateOptions.AUTO_GG,
                HymateOptions.AUTO_GG_COOLDOWN
        );
        this.body.addAll(
                HymateOptions.AUTO_ACCEPT_FRIENDS,
                HymateOptions.AUTO_TIP
        );
    }
}
