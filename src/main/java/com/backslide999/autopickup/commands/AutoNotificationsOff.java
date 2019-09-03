package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoNotificationsOff {

    public AutoNotificationsOff(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasNotificationsEnabled(user)){
                user.sendMessage(ChatColor.BLUE + "Notifications already disabled!");
            } else{
                PlayerDetails.instance().removeAutoNotificationsEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoPickup!");
            }
        }
    }
}
