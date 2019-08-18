package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoFurnaceOn {

    public AutoFurnaceOn(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoFurnaceEnabled(user)){
                PlayerDetails.instance().addAutoFurnaceEnabled(user);
                user.sendMessage(ChatColor.BLUE + "AutoFurnace Enabled!");
            } else{
                user.sendMessage(ChatColor.BLUE + "AutoFurnace already enabled!");
            }
        }
    }
}
