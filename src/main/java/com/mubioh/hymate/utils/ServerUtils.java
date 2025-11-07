package com.mubioh.hymate.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;

public class ServerUtils {
    public static boolean isOnHypixel() {
        MinecraftClient client = MinecraftClient.getInstance();
        ServerInfo serverInfo = client.getCurrentServerEntry();
        if (serverInfo == null) return false;

        String ip = serverInfo.address.toLowerCase();
        return ip.endsWith(".hypixel.net") || ip.equals("hypixel.net");
    }

    public static String stripFormatting(String input) {
        if (input == null) return "";
        return input.replaceAll("§.", "");
    }
}

