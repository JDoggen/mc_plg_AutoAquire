package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoNotificationsToggle {

    public AutoNotificationsToggle(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasNotificationsEnabled(user)){
                PlayerDetails.instance().addNotificationsEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Enabled Notifications!");
            } else{
                PlayerDetails.instance().removeAutoNotificationsEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Disabled Notifications");
            }
        }
    }
}
