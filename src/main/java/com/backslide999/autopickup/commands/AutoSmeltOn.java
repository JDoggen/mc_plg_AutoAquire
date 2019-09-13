package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
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
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autosmelt.enabled"));
            } else{
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autosmelt.already_enabled"));
            }
        }
    }
}
