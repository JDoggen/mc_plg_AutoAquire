package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoBlockToggle {

    public AutoBlockToggle(CommandSender sender){
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!PlayerDetails.instance().hasAutoBlockEnabled(player)){
                PlayerDetails.instance().addAutoBlockEnabled(player);
                AutoPickupPlugin.getInstance().sendPlayerInfo(player,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autoblock.enabled"));
            } else{
                PlayerDetails.instance().removeAutoBlockEnabled(player);
                AutoPickupPlugin.getInstance().sendPlayerInfo(player,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autoblock.disabled"));
            }
        }
    }
}
