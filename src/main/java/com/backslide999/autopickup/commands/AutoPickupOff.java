package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoPickupOff {


    public AutoPickupOff(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoPickupEnabled(user)){
                AutoPickupPlugin.getInstance().sendPlayerInfo(sender,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autopickup.already_disabled"));
            } else{
                PlayerDetails.instance().removeAutoPickupEnable(user);
                AutoPickupPlugin.getInstance().sendPlayerInfo(sender,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autopickup.disabled"));
            }
        }
    }
}
