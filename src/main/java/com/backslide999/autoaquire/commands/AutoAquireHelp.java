package com.backslide999.autoaquire.commands;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class AutoAquireHelp {

    public AutoAquireHelp(CommandSender sender, String[] args){
        List<String> messageList = new ArrayList<String>();
        messageList.add(ChatColor.BLUE + "/aa <on|off> - Toggles AutoAquire");
        messageList.add(ChatColor.BLUE + "/aa - Enables/Disables AutoAquire");
        messageList.add(ChatColor.BLUE + "/an <on|off> - Toggles AutoAquire notifications");
        messageList.add(ChatColor.BLUE + "/an - Enables/Disables AutoAquire notifications");

        String[] messages = (String[]) messageList.toArray(new String[0]);
        sender.sendMessage(messages);
    }
}
