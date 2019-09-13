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
            HashMap<Material, Material> materials = Constants.craftableMap;

            materials.forEach( (ore, block) -> {
                int craftAmount = 9;
                if(ore == Material.QUARTZ) craftAmount = 4;
                ItemStack craftItems = new ItemStack(ore, craftAmount);
                ItemStack craftedBlock = new ItemStack(block, 1);
                while(player.getInventory().contains(ore, craftAmount) && Utility.hasSpace(player, craftedBlock)) {
                    HashMap<Integer, ItemStack> notRemoved = player.getInventory().removeItem(craftItems);

                    // Double check if items removed successfully
                    if(notRemoved.isEmpty()){
                        HashMap<Integer, ItemStack> notGranted = player.getInventory().addItem(craftedBlock);
                        // Double check if crafted block is added successfully, else grant raw ores back
                        if(!notGranted.isEmpty()){
                            ItemStack removedOres = new ItemStack(ore, craftAmount);
                            player.getInventory().addItem(removedOres);
                            break;
                        }
                    } else{
                        int removedQuantity = craftAmount - notRemoved.get(ore).getAmount();
                        ItemStack removedItemStack = new ItemStack(ore, removedQuantity);
                        player.getInventory().addItem(removedItemStack);
                    }
                }
            });

        } else{
            String unauthorized = AutoPickupPlugin.getInstance().fetchConfigString("messages.unauthorized");
            AutoPickupPlugin.getInstance().sendPlayerInfo(player, unauthorized);
        }
    }
}
