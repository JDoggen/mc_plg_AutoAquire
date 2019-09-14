package com.backslide999.autopickup.commands.executors;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class AutoPickup implements CommandExecutor {

    private AutoPickupPlugin plugin;
    public AutoPickup(AutoPickupPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(args.length > 0){
            switch(args[0].toLowerCase()){
                case "help": {
                    new AutoPickupHelp(sender, args);
                    break;
                }
                case "on": {
                    new AutoPickupOn(sender, args);
                    break;
                }
                case "off": {
                    new AutoPickupOff(sender, args);
                    break;
                }
                case "reload":{
                    new AutoPickupReload(sender);
                    break;
                }
                default: {
                    new AutoPickupHelp(sender, args);
                    break;
                }
            }
        } else{
            new AutoPickupToggle(sender, args);
        }
        return true;
    }
}
