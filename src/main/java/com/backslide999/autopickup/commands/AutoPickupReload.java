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
            try{
                AutoPickupPlugin.getInstance().reload();
                String reloading_successful = AutoPickupPlugin.getInstance()
                        .fetchConfigString("messages.reloading_successful");
                AutoPickupPlugin.getInstance().sendPlayerInfo(sender, reloading_successful);
            } catch(Exception e){
                AutoPickupPlugin.getInstance().logWarning("Error reloading config file.");
                AutoPickupPlugin.getInstance().logWarning(e.getMessage());
                String reloading_unsuccessful = AutoPickupPlugin.getInstance()
                        .fetchConfigString("messages.reloading_unsuccessful");
                AutoPickupPlugin.getInstance().sendPlayerWarning(sender, reloading_unsuccessful);
            }


        } else{
            String unauthorized = AutoPickupPlugin.getInstance().fetchConfigString("messages.unauthorized");
            AutoPickupPlugin.getInstance().sendPlayerWarning(sender, unauthorized);
        }
    }
}
