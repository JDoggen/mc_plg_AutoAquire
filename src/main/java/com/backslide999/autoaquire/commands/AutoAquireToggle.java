package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class AutoAquireToggle {

    public AutoAquireToggle(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoAquireEnabled(user)){
                PlayerDetails.instance().addAutoAquireEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Enabled AutoAquire!");
            } else{
                PlayerDetails.instance().removeAutoAquireEnable(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoAquire!");
            }
        }
    }
}
