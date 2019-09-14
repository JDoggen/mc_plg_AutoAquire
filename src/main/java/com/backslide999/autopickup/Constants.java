package com.backslide999.autopickup;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;

public class Constants {

    public final static HashMap<Material, Material> craftableMap = new HashMap<>();
    public final static HashMap<Material, Integer> craftableAmountMap = new HashMap<>();
    public static Boolean soundEnabled;

    public static void load() {
        List<String> craftables = AutoPickupPlugin.getInstance().fetchConfigStringList("autoblock.craftables");
        for(String craftable : craftables){
            String[] data = craftable.trim().split(":");
            craftableMap.put(Material.valueOf(data[0]), Material.valueOf(data[1]));
            craftableAmountMap.put(Material.valueOf(data[0]), Integer.parseInt(data[2]));
        }

        soundEnabled = AutoPickupPlugin.getInstance().fetchConfigBoolean("sound.enabled");
    }
}
