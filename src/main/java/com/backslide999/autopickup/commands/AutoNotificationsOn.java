package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoNotificationsOn {

    public AutoNotificationsOn(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasNotificationsEnabled(user)){
                PlayerDetails.instance().addNotificationsEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Notifications Enabled!");
            } else{
                user.sendMessage(ChatColor.BLUE + "Notifications already enabled!");
            }
        }
    }
}
