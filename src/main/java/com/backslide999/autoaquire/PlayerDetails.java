package com.backslide999.autoaquire;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDetails {

    private static PlayerDetails _instance;
    public static PlayerDetails instance(){
        if(_instance == null)
            _instance = new PlayerDetails();
        return _instance;
    }

    private List<Player> autoAquirePlayers;
    private List<Player> autoNotificationsPlayers;


    private PlayerDetails(){
        this.autoAquirePlayers = new ArrayList<Player>();
        this.autoNotificationsPlayers = new ArrayList<Player>();
    }

    public List<Player> getAutoAquirePlayers(){
        return this.autoAquirePlayers;
    }
    public boolean hasAutoAquireEnabled(Player player){
        return this.autoAquirePlayers.contains(player);
    }
    public boolean addAutoAquireEnabled(Player player){
        return this.autoAquirePlayers.add(player);
    }
    public boolean removeAutoAquireEnable(Player player) {return this.autoAquirePlayers.remove(player); }

    public List<Player> getAutoNotificationsPlayers(){
        return this.autoNotificationsPlayers;
    }
    public boolean hasNotificationsEnabled(Player player){
        return this.autoNotificationsPlayers.contains(player);
    }
    public boolean addNotificationsEnabled(Player player){return this.autoNotificationsPlayers.add(player);
    }
    public boolean removeAutoNotificationsEnabled(Player player) {return this.autoNotificationsPlayers.remove(player); }


}
