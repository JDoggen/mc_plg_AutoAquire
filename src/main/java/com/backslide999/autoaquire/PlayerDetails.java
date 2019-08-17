package com.backslide999.autoaquire;

import com.backslide999.autoaquire.runnables.AddPlayerToNotificationsList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerDetails {

    private static PlayerDetails _instance;
    private Plugin plugin;

    public static PlayerDetails instance(){
        if(_instance == null)
            _instance = new PlayerDetails();
        return _instance;
    }

    private CopyOnWriteArrayList<Player> autoAquirePlayers;
    private CopyOnWriteArrayList<Player> autoNotificationsPlayers;


    private PlayerDetails(){
        this.autoAquirePlayers = new CopyOnWriteArrayList<Player>();
        this.autoNotificationsPlayers = new CopyOnWriteArrayList<Player>();
    }

    public void setPlugin(Plugin plugin){
        this.plugin = plugin;
    }

    public CopyOnWriteArrayList<Player> getAutoAquirePlayers(){
        return this.autoAquirePlayers;
    }
    public boolean hasAutoAquireEnabled(Player player){
        return this.autoAquirePlayers.contains(player);
    }
    public boolean addAutoAquireEnabled(Player player){
        return this.autoAquirePlayers.add(player);
    }
    public boolean removeAutoAquireEnable(Player player) {return this.autoAquirePlayers.remove(player); }

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


}
