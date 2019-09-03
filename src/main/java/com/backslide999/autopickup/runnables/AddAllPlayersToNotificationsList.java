package com.backslide999.autopickup.runnables;

import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public class AddAllPlayersToNotificationsList implements Runnable{

    @Override
    public void run() {
        Collection<? extends  Player> players = Bukkit.getOnlinePlayers();
        players.forEach(player ->{
            if(player.hasPermission("autopickup.notification")){
                PlayerDetails.instance().addNotificationsEnabled(player);
            }
        });

    }
}
