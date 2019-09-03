package com.backslide999.autopickup;

import com.backslide999.autopickup.runnables.AddPlayerToNotificationsList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerDetails {

    private static PlayerDetails _instance;
    private Plugin plugin;

    public static PlayerDetails instance(){
        if(_instance == null)
            _instance = new PlayerDetails();
        return _instance;
    }

    private CopyOnWriteArrayList<Player> autoPickupPlayers;
    private CopyOnWriteArrayList<Player> autoNotificationsPlayers;
    private CopyOnWriteArrayList<Player> autoSmeltPlayers;


    private PlayerDetails(){
        this.autoPickupPlayers = new CopyOnWriteArrayList<Player>();
        this.autoNotificationsPlayers = new CopyOnWriteArrayList<Player>();
        this.autoSmeltPlayers = new CopyOnWriteArrayList<Player>();
    }

    public void setPlugin(Plugin plugin){
        this.plugin = plugin;
    }

    public CopyOnWriteArrayList<Player> getAutoPickupPlayers(){
        return this.autoPickupPlayers;
    }
    public boolean hasAutoPickupEnabled(Player player){
        return this.autoPickupPlayers.contains(player);
    }
    public boolean addAutoPickupEnabled(Player player){
        return this.autoPickupPlayers.add(player);
    }
    public boolean removeAutoPickupEnable(Player player) {return this.autoPickupPlayers.remove(player); }

    public CopyOnWriteArrayList<Player> getAutoNotificationsPlayers(){
        return this.autoNotificationsPlayers;
    }
    public boolean hasNotificationsEnabled(Player player){
        return this.autoNotificationsPlayers.contains(player);
    }
    public boolean addNotificationsEnabled(Player player){return this.autoNotificationsPlayers.add(player);
    }
    public boolean removeAutoNotificationsEnabled(Player player) {return this.autoNotificationsPlayers.remove(player); }
    public boolean removeAutoNotificationsEnabledTemporary(Player player){
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new AddPlayerToNotificationsList(player), 40);
        return this.autoNotificationsPlayers.remove(player);
    }

    public CopyOnWriteArrayList<Player> getAutoSmeltPlayers() {
        return this.autoSmeltPlayers;
    }
    public boolean hasAutoSmeltEnabled(Player player) {
        return this.autoSmeltPlayers.contains(player);
    }
    public boolean addAutoSmeltEnabled(Player player){
        return this.autoSmeltPlayers.add(player);
    }
    public boolean removeAutoSmeltEnabled(Player player){
        return this.autoSmeltPlayers.remove(player);
    }





}
