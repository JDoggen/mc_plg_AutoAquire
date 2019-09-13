package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoSmeltOff {

    public AutoSmeltOff(CommandSender sender, String[] args){
        if(sender instanceof Player){
            Player user = (Player) sender;
            if(!PlayerDetails.instance().hasAutoSmeltEnabled(user)){
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autosmelt.already_disabled"));
            } else{
                PlayerDetails.instance().removeAutoSmeltEnabled(user);
                AutoPickupPlugin.getInstance().sendPlayerInfo(user,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autosmelt.disabled"));
            }
        }
    }
}
