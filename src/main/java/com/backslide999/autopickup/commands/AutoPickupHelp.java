package com.backslide999.autopickup.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class AutoPickupHelp {

    public AutoPickupHelp(CommandSender sender, String[] args){
        List<String> messageList = new ArrayList<String>();
        messageList.add(ChatColor.BLUE + "/aa <on|off> - Enables/Disables AutoPickup");
        messageList.add(ChatColor.BLUE + "/aa - Toggles AutoPickup");
        messageList.add(ChatColor.BLUE + "/as <on|off> - Enables/Disables AutoSmelt");
        messageList.add(ChatColor.BLUE + "/as - Toggles AutoSmelt");
        messageList.add(ChatColor.BLUE + "/an <on|off> - Enables/Disables Notifications");
        messageList.add(ChatColor.BLUE + "/an - Toggles Notifications");

        String[] messages = (String[]) messageList.toArray(new String[0]);
        sender.sendMessage(messages);
    }
}
