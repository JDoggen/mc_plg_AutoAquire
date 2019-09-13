package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoNotificationsToggle {

    public AutoNotificationsToggle(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!PlayerDetails.instance().hasNotificationsEnabled(player)){
                PlayerDetails.instance().addNotificationsEnabled(player);
                AutoPickupPlugin.getInstance().sendPlayerInfo(player,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.notifications.enabled"));
            } else{
                PlayerDetails.instance().removeNotificationsEnabled(player);
                AutoPickupPlugin.getInstance().sendPlayerInfo(player,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.notifications.disabled"));
            }
        }
    }
}
