package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoAquireOn {

    public AutoAquireOn(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoAquireEnabled(user)){
                PlayerDetails.instance().addAutoAquireEnabled(user);
                user.sendMessage(ChatColor.BLUE + "AutoAquire Enabled!");
            } else{
                user.sendMessage(ChatColor.BLUE + "AutoAquire already enabled!");
            }
        }
    }
}
