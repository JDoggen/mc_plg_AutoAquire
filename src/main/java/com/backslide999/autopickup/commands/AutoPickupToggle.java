package com.backslide999.autopickup.commands;

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
                user.sendMessage(ChatColor.BLUE + "Enabled AutoPickup!");
            } else{
                PlayerDetails.instance().removeAutoPickupEnable(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoPickup!");
            }
        }
    }
}
