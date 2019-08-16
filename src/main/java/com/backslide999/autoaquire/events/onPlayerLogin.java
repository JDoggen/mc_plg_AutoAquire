package com.backslide999.autoaquire.events;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class onPlayerLogin implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("autoaquire.notification") && !PlayerDetails.instance().hasNotificationsEnabled(player)){
            PlayerDetails.instance().addNotificationsEnabled(player);
        }

    }
}
