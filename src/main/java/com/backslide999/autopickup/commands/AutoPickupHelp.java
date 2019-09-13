package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class AutoPickupHelp {

    public AutoPickupHelp(CommandSender sender, String[] args){
        List<String> help = AutoPickupPlugin.getInstance().fetchConfigStringList("messages.help.autopickup_help");
        AutoPickupPlugin.getInstance().sendPlayerInfo(sender, help);
    }
}
