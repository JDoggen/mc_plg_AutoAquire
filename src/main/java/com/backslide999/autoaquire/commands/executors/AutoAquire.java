package com.backslide999.autoaquire.commands.executors;

import com.backslide999.autoaquire.AutoAquirePlugin;
import com.backslide999.autoaquire.commands.AutoAquireOff;
import com.backslide999.autoaquire.commands.AutoAquireOn;
import com.backslide999.autoaquire.commands.AutoAquireToggle;
import com.backslide999.autoaquire.commands.AutoAquireHelp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class AutoAquire implements CommandExecutor {

    private AutoAquirePlugin plugin;
    public AutoAquire(AutoAquirePlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(args.length > 0){
            switch(args[0].toLowerCase()){
                case "help": {
                    new AutoAquireHelp(sender, args);
                    break;
                }
                case "on": {
                    new AutoAquireOn(sender, args);
                    break;
                }
                case "off": {
                    new AutoAquireOff(sender, args);
                    break;
                }
                default: {
                    new AutoAquireHelp(sender, args);
                    break;
                }
            }
        } else{
            new AutoAquireToggle(sender, args);
        }
        return true;
    }
}
