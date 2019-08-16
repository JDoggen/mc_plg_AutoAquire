package com.backslide999.autoaquire.runnables;

import com.backslide999.autoaquire.MinedBlockDetails;
import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

public class AddAllPlayers implements Runnable{

    @Override
    public void run() {
        Collection<? extends  Player> players = Bukkit.getOnlinePlayers();
        players.forEach(player ->{
            if(player.hasPermission("autoaquire.notification")){
                PlayerDetails.instance().addNotificationsEnabled(player);
            }
        });

    }
}
