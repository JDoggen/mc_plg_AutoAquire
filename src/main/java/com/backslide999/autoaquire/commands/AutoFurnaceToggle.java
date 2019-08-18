package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoFurnaceToggle {

    public AutoFurnaceToggle(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoFurnaceEnabled(user)){
                PlayerDetails.instance().addAutoFurnaceEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Enabled AutoFurnace!");
            } else{
                PlayerDetails.instance().removeAutoFurnaceEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoFurnace!");
            }
        }
    }
}
