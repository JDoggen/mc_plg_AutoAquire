package com.backslide999.autopickup;

import com.backslide999.autopickup.commands.executors.AutoPickup;
import com.backslide999.autopickup.commands.executors.AutoSmelt;
import com.backslide999.autopickup.commands.executors.Notifications;
import com.backslide999.autopickup.events.onBlockBreak;
import com.backslide999.autopickup.events.onItemSpawn;
import com.backslide999.autopickup.events.onPlayerLogin;
import com.backslide999.autopickup.runnables.AddAllPlayersToNotificationsList;
import com.backslide999.autopickup.runnables.MinedBlockClearer;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AutoPickupPlugin extends JavaPlugin {

    public final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {

        // Read config file
        logger.info("Reading Config File.");
        FileConfigurationOptions config = getConfig().options().copyDefaults(true);
        saveConfig();

        // Register Commands
        logger.info("Registering Commands.");
        this.getCommand("AutoPickup").setExecutor(new AutoPickup(this));
        this.getCommand("AutoSmelt").setExecutor(new AutoSmelt(this));
        this.getCommand("AutoNotify").setExecutor(new Notifications(this));

        // Register Events
        logger.info("Registering Events.");
        this.getServer().getPluginManager().registerEvents(new onBlockBreak(), this);
        this.getServer().getPluginManager().registerEvents(new onItemSpawn(this), this);
        this.getServer().getPluginManager().registerEvents(new onPlayerLogin(), this);

        // Register Scheduled Methods
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new MinedBlockClearer(), 20, 20);
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new AddAllPlayersToNotificationsList());

        PlayerDetails.instance().setPlugin(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic;
    }

    public Boolean fetchConfigBoolean (final String path){
        return getConfig().getBoolean(path);
    }

    public Integer fetchConfigInteger (final String path){
        return getConfig().getInt(path);
    }

    public Object fetchConfigObject (final String path){
        return getConfig().get(path);
    }

    public String fetchConfigString (final String path){
        return getConfig().getString(path);
    }

}