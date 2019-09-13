package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoBlockOff {

    public AutoBlockOff(CommandSender sender){
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!PlayerDetails.instance().hasAutoBlockEnabled(player)){
                AutoPickupPlugin.getInstance().sendPlayerInfo(player,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autoblock.already_disabled"));
            } else{
                PlayerDetails.instance().removeAutoBlockEnabled(player);
                AutoPickupPlugin.getInstance().sendPlayerInfo(player,
                        AutoPickupPlugin.getInstance().fetchConfigString("messages.autoblock.disabled"));
            }
        }
    }
}
