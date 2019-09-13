package com.backslide999.autopickup.commands.executors;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoBlock implements CommandExecutor {

    private AutoPickupPlugin plugin;

    public AutoBlock(AutoPickupPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0) {
                switch (args[0].toLowerCase()) {
                    case "help": {
                        new AutoPickupHelp(sender, args);
                        break;
                    }
                    case "on": {
                        new AutoBlockOn(player);
                        break;
                    }
                    case "off": {
                        new AutoBlockOff(player);
                        break;
                    }
                    case "all": {
                        new AutoBlockAll(player);
                        break;
                    }
                    default: {
                        new AutoPickupHelp(sender, args);
                        break;
                    }
                }
            } else {
                new AutoBlockToggle(sender);
            }
        }
        return true;
    }
}
