package com.backslide999.autopickup.runnables;

import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.entity.Player;

public class AddPlayerToNotificationsList implements Runnable{

    private Player player;

    public AddPlayerToNotificationsList(Player player) {
        this.player = player;

    }
    @Override
    public void run() {
        PlayerDetails.instance().addNotificationsEnabled(player);
    }
}
