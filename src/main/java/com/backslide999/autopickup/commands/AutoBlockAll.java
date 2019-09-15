package com.backslide999.autopickup.commands;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.Constants;
import com.backslide999.autopickup.PlayerDetails;
import com.backslide999.autopickup.Utility;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class AutoBlockAll {

    public AutoBlockAll(Player player){
        if(player.hasPermission("autopickup.autoblock.all:")){

            Constants.craftableMap.forEach( (ore, block) -> {
                int craftAmount = Constants.craftableAmountMap.get(ore);
                ItemStack craftItems = new ItemStack(ore, craftAmount);
                ItemStack craftedBlock = new ItemStack(block, 1);
                while(player.getInventory().contains(ore, craftAmount) && Utility.hasSpace(player, craftedBlock)) {
                    if(Utility.autoblock(player, craftItems, craftedBlock, ore, craftAmount))
                        continue;
                    else
                        break;

                }
            });

        } else{
            String unauthorized = AutoPickupPlugin.getInstance().fetchConfigString("messages.unauthorized");
            AutoPickupPlugin.getInstance().sendPlayerInfo(player, unauthorized);
        }
    }
}
