package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoFurnaceOff {

    public AutoFurnaceOff(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoFurnaceEnabled(user)){
                user.sendMessage(ChatColor.BLUE + "AutoFurnace already disabled!");
            } else{
                PlayerDetails.instance().removeAutoFurnaceEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoFurnace!");
            }
        }
    }
}
