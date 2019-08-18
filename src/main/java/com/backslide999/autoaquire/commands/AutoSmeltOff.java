package com.backslide999.autoaquire.commands;

import com.backslide999.autoaquire.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoSmeltOff {

    public AutoSmeltOff(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoSmeltEnabled(user)){
                user.sendMessage(ChatColor.BLUE + "AutoSmelt already disabled!");
            } else{
                PlayerDetails.instance().removeAutoSmeltEnabled(user);
                user.sendMessage(ChatColor.BLUE + "Disabled AutoSmelt!");
            }
        }
    }
}
