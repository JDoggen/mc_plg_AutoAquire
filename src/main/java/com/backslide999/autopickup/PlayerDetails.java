package com.backslide999.autopickup;

import com.backslide999.autopickup.runnables.AddPlayerToNotificationsList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerDetails {

    private static PlayerDetails _instance;

    public static PlayerDetails instance(){
        if(_instance == null)
            _instance = new PlayerDetails();
        return _instance;
    }

    private CopyOnWriteArrayList<Player> autoPickupPlayers;
    private CopyOnWriteArrayList<Player> autoNotificationsPlayers;
    private CopyOnWriteArrayList<Player> autoSmeltPlayers;
    private CopyOnWriteArrayList<Player> autoBlockPlayers;


    private PlayerDetails(){
        this.autoPickupPlayers = new CopyOnWriteArrayList<>();
        this.autoNotificationsPlayers = new CopyOnWriteArrayList<>();
        this.autoSmeltPlayers = new CopyOnWriteArrayList<>();
        this.autoBlockPlayers = new CopyOnWriteArrayList<>();
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

    public CopyOnWriteArrayList<Player> getNotificationsPlayers(){
        return this.autoNotificationsPlayers;
    }
    public boolean hasNotificationsEnabled(Player player){
        return this.autoNotificationsPlayers.contains(player);
    }
    public boolean addNotificationsEnabled(Player player){return this.autoNotificationsPlayers.add(player);
    }
    public boolean removeNotificationsEnabled(Player player) {
        return this.autoNotificationsPlayers.remove(player);
    }
    public boolean removeNotificationsEnabledTemporary(Player player){
        Bukkit.getScheduler().scheduleSyncDelayedTask(AutoPickupPlugin.getInstance(),
                new AddPlayerToNotificationsList(player), 5);
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

    public CopyOnWriteArrayList<Player> getAutoBlockPlayers() { return this.autoBlockPlayers;}
    public boolean hasAutoBlockEnabled(Player player) { return this.autoBlockPlayers.contains(player);}
    public boolean addAutoBlockEnabled(Player player) { return this.autoBlockPlayers.add(player);}
    public boolean removeAutoBlockEnabled(Player player){ return this.autoBlockPlayers.remove(player);}

}
