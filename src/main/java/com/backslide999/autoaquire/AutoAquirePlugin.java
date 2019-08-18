package com.backslide999.autoaquire;

import com.backslide999.autoaquire.commands.executors.AutoAquire;
import com.backslide999.autoaquire.commands.executors.AutoSmelt;
import com.backslide999.autoaquire.commands.executors.Notifications;
import com.backslide999.autoaquire.events.onBlockBreak;
import com.backslide999.autoaquire.events.onItemSpawn;
import com.backslide999.autoaquire.events.onPlayerLogin;
import com.backslide999.autoaquire.runnables.AddAllPlayersToNotificationsList;
import com.backslide999.autoaquire.runnables.MinedBlockClearer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AutoAquirePlugin extends JavaPlugin {

    public final Logger logger = Logger.getLogger("Minecraft");
    @Override
    public void onEnable() {

        // Register Commands
        logger.info("Registering Commands.");
        this.getCommand("AutoAquire").setExecutor(new AutoAquire(this));
        this.getCommand("AutoSmelt").setExecutor(new AutoSmelt(this));
        this.getCommand("AutoNotify").setExecutor(new Notifications(this));

        // Register Events
        logger.info("Registering Events.");
        this.getServer().getPluginManager().registerEvents(new onBlockBreak(), this);
        this.getServer().getPluginManager().registerEvents(new onItemSpawn(), this);
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
}
