package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoPickupToggle {

    public AutoPickupToggle(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoPickupEnabled(user)){
                PlayerDetails.instance().addAutoPickupEnabled(user);
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autopickup.enabled"));
            } else{
                PlayerDetails.instance().removeAutoPickupEnable(user);
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autopickup.disabled"));
            }
        }
    }
}
