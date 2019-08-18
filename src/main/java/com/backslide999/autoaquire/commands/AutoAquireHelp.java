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
        messageList.add(ChatColor.BLUE + "/aa <on|off> - Enables/Disables AutoAquire");
        messageList.add(ChatColor.BLUE + "/aa - Toggles AutoAquire");
        messageList.add(ChatColor.BLUE + "/as <on|off> - Enables/Disables AutoSmelt");
        messageList.add(ChatColor.BLUE + "/as - Toggles AutoSmelt");
        messageList.add(ChatColor.BLUE + "/an <on|off> - Enables/Disables Notifications");
        messageList.add(ChatColor.BLUE + "/an - Toggles Notifications");

        String[] messages = (String[]) messageList.toArray(new String[0]);
        sender.sendMessage(messages);
    }
}
