package com.backslide999.autopickup;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Utility {

    static public boolean hasSpace(final Player player, final ItemStack itemStack){
        Inventory inventory = player.getInventory();
        if(inventory.firstEmpty() != -1) {
            return true;
        } else{
            int toDistribute = itemStack.getAmount();
            for (ItemStack content : player.getInventory().getStorageContents()) {
                if(content.getType() == itemStack.getType()){
                    toDistribute -= (64 - content.getAmount());
                    if(toDistribute <= 0){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static public boolean autoblock(final Player player, final ItemStack craftItems, final ItemStack craftedBlock,
                                    final Material ore, final int craftAmount){
        HashMap<Integer, ItemStack> notRemoved = player.getInventory().removeItem(craftItems);

        // Double check if items removed successfully
        if(notRemoved.isEmpty()){
            HashMap<Integer, ItemStack> notGranted = player.getInventory().addItem(craftedBlock);
            // Double check if crafted block is added successfully, else grant raw ores back
            if(!notGranted.isEmpty()){
                ItemStack removedOres = new ItemStack(craftItems.getType(), craftAmount);
                player.getInventory().addItem(removedOres);
                return false;
            } else{
                return true;
            }
        } else{
            int removedQuantity = craftAmount - notRemoved.get(ore).getAmount();
            ItemStack removedItemStack = new ItemStack(ore, removedQuantity);
            player.getInventory().addItem(removedItemStack);
            return false;
        }
    }

}
