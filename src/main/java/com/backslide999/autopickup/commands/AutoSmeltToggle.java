package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
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
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autosmelt.enabled"));
            } else{
                PlayerDetails.instance().removeAutoSmeltEnabled(user);
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autosmelt.disabled"));
            }
        }
    }
}
