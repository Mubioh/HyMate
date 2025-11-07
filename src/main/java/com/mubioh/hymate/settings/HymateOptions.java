package com.mubioh.hymate.settings;

import com.mojang.serialization.Codec;
import com.mubioh.hymate.client.HymateClient;
import com.mubioh.hymate.features.clickaction.ClickActionFeature;
import com.mubioh.hymate.features.gamequeue.GameQueueFeature;
import com.mubioh.hymate.settings.config.Config;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import java.util.ArrayList;

import static java.util.List.of;

public class HymateOptions {
    public static final SimpleOption<ClickActionFeature.ClickMode> CLICK_ACTION_MODE = new SimpleOption<>(
            "Click Action",
            option -> Tooltip.of(Text.of("Middle-click a player to friend or party them. Hold Shift to remove them instead.")),
            (option, value) -> Text.literal(String.valueOf(value)),
            new SimpleOption.PotentialValuesBasedCallbacks<>(
                    of(ClickActionFeature.ClickMode.FRIEND, ClickActionFeature.ClickMode.PARTY, ClickActionFeature.ClickMode.DISABLED),
                    ClickActionFeature.ClickMode.CODEC
            ),
            ClickActionFeature.ClickMode.DISABLED,
            newValue -> {
                ClickActionFeature.setMode(newValue);
                HymateClient.config.clickMode = newValue;
                HymateClient.config.save();
            }
    );

    public static final SimpleOption<Boolean> SHOW_OWN_NAMETAG = new SimpleOption<>(
            "Nametag",
            option -> Tooltip.of(Text.of("Show your own nameplate in third person view.")),
            (option, value) -> Text.literal(value ? "Shown" : "Hidden"),
            SimpleOption.BOOLEAN,
            false,
            newValue -> {
                HymateClient.config.showOwnNametag = newValue;
                HymateClient.config.save();
            }
    );

    public static final SimpleOption<Boolean> AUTO_GG = new SimpleOption<>(
            "AutoGG",
            option -> Tooltip.of(Text.of("Automatically says GG when a game ends.")),
            (option, value) -> Text.literal(value ? "Enabled" : "Disabled"),
            SimpleOption.BOOLEAN,
            false,
            newValue -> {
                HymateClient.config.autoGG = newValue;
                HymateClient.config.save();
            }
    );

    public static final SimpleOption<Integer> AUTO_GG_COOLDOWN = new SimpleOption<>(
            "AutoGG Cooldown",
            option -> Tooltip.of(Text.literal("Delay before AutoGG message is sent (if enabled).")),
            (option, value) -> Text.literal("AutoGG delay: " + value + " seconds"),
            new SimpleOption.ValidatingIntSliderCallbacks(0, 5),
            0,
            value -> {
                HymateClient.config.autoGGCooldown = value;
                HymateClient.config.save();
            }
    );

    public static final SimpleOption<Boolean> AUTO_ACCEPT_FRIENDS = new SimpleOption<>(
            "AutoFriend",
            option -> Tooltip.of(Text.of("Automatically accept friend requests from other players.")),
            (option, value) -> Text.literal(value ? "Enabled" : "Disabled"),
            SimpleOption.BOOLEAN,
            false,
            newValue -> {
                HymateClient.config.autoAcceptFriendRequests = newValue;
                HymateClient.config.save();
            }
    );

    public static final SimpleOption<String> SELECTED_GAME = new SimpleOption<>(
            "Game Mode",
            option -> Tooltip.of(Text.of("Select which Hypixel game to queue when pressing the key.")),
            (option, value) -> Text.literal(value),
            new SimpleOption.PotentialValuesBasedCallbacks<>(
                    new ArrayList<>(GameQueueFeature.GAME_MODE_COMMANDS.keySet()),
                    Codec.STRING
            ),
            "SkyBlock",
            value -> {
                HymateClient.config.selectedGame = value;
                HymateClient.config.save();
            }
    );

    public static final SimpleOption<Boolean> AUTO_TIP = new SimpleOption<>(
            "AutoTip",
            option -> Tooltip.of(Text.of("Automatically send /tipall every 15 minutes.")),
            (option, value) -> Text.literal(value ? "Enabled" : "Disabled"),
            SimpleOption.BOOLEAN,
            false,
            newValue -> {
                HymateClient.config.autoTip = newValue;
                HymateClient.config.save();
            }
    );

    public static void applyConfig(Config config) {
        CLICK_ACTION_MODE.setValue(config.clickMode);
        ClickActionFeature.setMode(config.clickMode);
        SHOW_OWN_NAMETAG.setValue(config.showOwnNametag);
        AUTO_ACCEPT_FRIENDS.setValue(config.autoAcceptFriendRequests);
        AUTO_GG.setValue(config.autoGG);
        AUTO_GG_COOLDOWN.setValue(config.autoGGCooldown);
        SELECTED_GAME.setValue(config.selectedGame);
        AUTO_TIP.setValue(config.autoTip);
    }
}