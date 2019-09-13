package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import com.backslide999.autopickup.commands.executors.AutoPickup;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoPickupOn {

    public AutoPickupOn(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoPickupEnabled(user)){
                PlayerDetails.instance().addAutoPickupEnabled(user);
                AutoPickupPlugin.getInstance().sendPlayerInfo(sender,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autopickup.enabled"));
            } else{
                AutoPickupPlugin.getInstance().sendPlayerInfo(sender,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autopickup.already_enabled"));
            }
        }
    }
}
