package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoSmeltToggle {

    public AutoSmeltToggle(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoSmeltEnabled(user)){
                PlayerDetails.instance().addAutoSmeltEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Enabled AutoSmelt!");
            } else{
                PlayerDetails.instance().removeAutoSmeltEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoSmelt!");
            }
        }
    }
}
