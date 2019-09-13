package com.backslide999.autopickup;

import org.bukkit.Material;

import java.util.HashMap;

public class Constants {

    public final static String PATH_FORTUNE = "autosmelt.fortune";
    public final static HashMap<Material, Material> craftableMap = new HashMap<>();

    static {
        craftableMap.put(Material.COAL, Material.COAL_BLOCK);
        craftableMap.put(Material.IRON_INGOT, Material.IRON_BLOCK);
        craftableMap.put(Material.REDSTONE, Material.REDSTONE_BLOCK);
        craftableMap.put(Material.GOLD_NUGGET, Material.GOLD_INGOT);
        craftableMap.put(Material.GOLD_INGOT, Material.GOLD_BLOCK);
        craftableMap.put(Material.LAPIS_LAZULI, Material.LAPIS_BLOCK);
        craftableMap.put(Material.EMERALD, Material.EMERALD_BLOCK);
        craftableMap.put(Material.QUARTZ, Material.QUARTZ_BLOCK);
    }
}
