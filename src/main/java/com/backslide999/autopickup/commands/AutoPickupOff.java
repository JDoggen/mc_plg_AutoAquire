package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoPickupOff {


    public AutoPickupOff(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoPickupEnabled(user)){
                user.sendMessage(ChatColor.BLUE + "AutoPickup already disabled!");
            } else{
                PlayerDetails.instance().removeAutoPickupEnable(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoPickup!");
            }
        }
    }
}
