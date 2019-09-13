package com.backslide999.autopickup;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
}
