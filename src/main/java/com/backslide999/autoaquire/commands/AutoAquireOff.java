package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoAquireOff {


    public AutoAquireOff(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoAquireEnabled(user)){
                user.sendMessage(ChatColor.BLUE + "AutoAquire already disabled!");
            } else{
                PlayerDetails.instance().removeAutoAquireEnable(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoAquire!");
            }
        }
    }
}
