package com.backslide999.autopickup;

import com.backslide999.autopickup.commands.executors.*;
import com.backslide999.autopickup.events.onBlockBreak;
import com.backslide999.autopickup.events.onItemSpawn;
import com.backslide999.autopickup.events.onPlayerLogin;
import com.backslide999.autopickup.hooks.AutoPickupPlaceholderExpansion;
import com.backslide999.autopickup.runnables.AddAllPlayersToNotificationsList;
import com.backslide999.autopickup.runnables.MinedBlockClearer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Logger;

public final class AutoPickupPlugin extends JavaPlugin {

    private static AutoPickupPlugin instance;
    public final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        instance = this;

        // Read config file
        this.logInfo("Reading Config file");
        this.reload();

        // Register Commands
        this.logInfo("Registering Commands");
        this.getCommand("AutoPickup").setExecutor(new AutoPickup(this));
        this.getCommand("AutoSmelt").setExecutor(new AutoSmelt(this));
        this.getCommand("AutoNotify").setExecutor(new Notifications(this));
        this.getCommand("AutoBlock").setExecutor(new AutoBlock(this));

        // Register Events
        this.logInfo("Registering Events");
        this.getServer().getPluginManager().registerEvents(new onBlockBreak(), this);
        this.getServer().getPluginManager().registerEvents(new onItemSpawn(this), this);
        if(this.fetchConfigBoolean("notifications.default_on"))
            this.getServer().getPluginManager().registerEvents(new onPlayerLogin(), this);

        // Register Scheduled Methods
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new MinedBlockClearer(), 20, 20);
        if(this.fetchConfigBoolean("notifications.default_on"))
            Bukkit.getScheduler().scheduleSyncDelayedTask(this, new AddAllPlayersToNotificationsList());

        // Register events with different plugins
        this.registerPlaceHolderAPI();

    }

    @Override
    public void onDisable() {
        // UnRegistering Commands
        // logger.info("[AutoPickup] Unregistering Commands.");
    }

    public void reload() {
        this.reloadConfig();
        FileConfigurationOptions config = getConfig().options().copyDefaults(true);
        saveConfig();
        Constants.load();
        registerPlaceHolderAPI();
    }



    public static AutoPickupPlugin getInstance(){return instance;}

    public Boolean fetchConfigBoolean (final String path){
        return getConfig().getBoolean(path);
    }

    public Integer fetchConfigInteger (final String path){
        return getConfig().getInt(path);
    }

    public List<String> fetchConfigStringList(final String path){
        return getConfig().getStringList(path);
    }

    public Object fetchConfigObject (final String path){
        return getConfig().get(path);
    }

    public String fetchConfigString (final String path){
        return getConfig().getString(path);
    }

    public void sendPlayerInfo(CommandSender sender, List<String> messages){
        messages.forEach( message -> this.sendPlayerInfo(sender, message));
    }

    public void sendPlayerInfo(CommandSender sender, String message){
        String line = "";
        if(fetchConfigBoolean("messages.prefix")){
            line = ChatColor.WHITE + "[" +
                    ChatColor.GREEN + "AutoPickup" +
                    ChatColor.WHITE + "] " +
                    ChatColor.YELLOW;
        }
        line += message;
        sender.sendMessage(line);
    }

    public void sendPlayerWarning(CommandSender sender, List<String> messages){
        messages.forEach( message -> this.sendPlayerWarning(sender, message));
    }

    public void sendPlayerWarning(CommandSender sender, String message){
        String line = "";
        if(fetchConfigBoolean("messages.prefix")){
            line = ChatColor.WHITE + "[" +
                    ChatColor.GREEN + "AutoPickup" +
                    ChatColor.WHITE + "] " +
                    ChatColor.RED;
        }
        line += message;
        sender.sendMessage(line);
    }

    public void logInfo(String message){
        this.getLogger().info(message);
    }

    public void logWarning(String message){
        this.getLogger().warning(message);
    }

    private void registerPlaceHolderAPI(){
        try{
            boolean enabled = this.fetchConfigBoolean("api.placeholder.enabled");
            if(!enabled){
                this.logInfo("Placeholder API disabled");
                return;
            } else{
                this.logInfo("Registering Placeholder API");
                if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
                    new AutoPickupPlaceholderExpansion().register();
                    this.logInfo("Placeholder API successfuly registered");
                } else {
                    this.logWarning("Could not find PlaceholderAPI. PlacehodlerAPI not registered. Please disable in config.yml");
                    return;
                }
            }
        } catch (Throwable T){
            this.logInfo(T.getMessage());
        }
    }

}