package com.mubioh.hymate.settings.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mubioh.hymate.features.clickaction.ClickActionFeature;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Config {
    private static final File FILE = new File("config/hymate.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public ClickActionFeature.ClickMode clickMode = ClickActionFeature.ClickMode.DISABLED;
    public boolean showOwnNametag = false;
    public boolean autoGG = false;
    public int autoGGCooldown = 0;
    public String selectedGame = "SkyBlock";
    public boolean autoAcceptFriendRequests = false;
    public boolean autoTip = false;

    public static Config load() {
        if (!FILE.exists()) return new Config();
        try (FileReader reader = new FileReader(FILE)) {
            return GSON.fromJson(reader, Config.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new Config();
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(FILE)) {
            GSON.toJson(this, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
