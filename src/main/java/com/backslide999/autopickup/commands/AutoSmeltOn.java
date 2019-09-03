package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoSmeltOn {

    public AutoSmeltOn(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoSmeltEnabled(user)){
                PlayerDetails.instance().addAutoSmeltEnabled(user);
                user.sendMessage(ChatColor.BLUE + "AutoSmelt Enabled!");
            } else{
                user.sendMessage(ChatColor.BLUE + "AutoSmelt already enabled!");
            }
        }
    }
}
