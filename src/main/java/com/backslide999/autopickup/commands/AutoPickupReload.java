package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoPickupReload {

    public AutoPickupReload(CommandSender sender){
        if(sender.hasPermission("autopickup.reload")){
            String reloading = AutoPickupPlugin.getInstance().fetchConfigString("messages.reloading");
            AutoPickupPlugin.getInstance().sendPlayerInfo(sender, reloading);
            AutoPickupPlugin.getInstance().reload();
        } else{
            String unauthorized = AutoPickupPlugin.getInstance().fetchConfigString("messages.unauthorized");
            AutoPickupPlugin.getInstance().sendPlayerWarning(sender, unauthorized);
        }
    }
}
