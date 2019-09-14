package com.backslide999.autopickup;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;

public class Constants {

    public static HashMap<Material, Material> craftableMap;
    public static HashMap<Material, Integer> craftableAmountMap;
    public static Boolean soundEnabled;
    public static Boolean useChatPrefix;

    public static void load() {
        Constants.craftableMap = new HashMap<>();
        Constants.craftableAmountMap = new HashMap<>();
        List<String> craftables = AutoPickupPlugin.getInstance().fetchConfigStringList("autoblock.craftables");
        for(String craftable : craftables){
            String[] data = craftable.trim().split(":");
            craftableMap.put(Material.valueOf(data[0]), Material.valueOf(data[1]));
            craftableAmountMap.put(Material.valueOf(data[0]), Integer.parseInt(data[2]));
        }

        Constants.soundEnabled = AutoPickupPlugin.getInstance().fetchConfigBoolean("sound.enabled");
        Constants.useChatPrefix = AutoPickupPlugin.getInstance().fetchConfigBoolean("messages.prefix");
    }
}
