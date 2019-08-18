package com.backslide999.autoaquire.events;

import com.backslide999.autoaquire.MinedBlockDetails;
import com.backslide999.autoaquire.PlayerDetails;
import com.backslide999.autoaquire.containers.MinedBlock;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.logging.Logger;

public class onItemSpawn implements Listener {

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {

        Location loc = event.getLocation().toBlockLocation();
        String locWorld = loc.getWorld().getName();
        int locX = loc.getBlockX();
        int locY = loc.getBlockY();
        int locZ = loc.getBlockZ();

        MinedBlock blockDetails = MinedBlockDetails.instance().getMinedBlocks()
                .stream()
                .filter(minedBlock -> {
                    Location miningLocation = minedBlock.getLocation();
                    return miningLocation.getBlockX() == locX
                            && miningLocation.getBlockY() == locY
                            && miningLocation.getBlockZ() == locZ
                            && miningLocation.getWorld().getName().equals(locWorld);
                })
                .findFirst()
                .orElse(null);

        if(blockDetails == null)
            return;




        //Block is mined by a used with AutoAquire on.
        Player player = blockDetails.getPlayer();
        Item item = event.getEntity();

        //Change Itemstack if user has autofurnace enabled
        if(PlayerDetails.instance().hasAutoSmeltEnabled(player)){
            ItemStack itemStack = item.getItemStack();
            switch(itemStack.getType().toString()){
                case "IRON_ORE": itemStack.setType(Material.IRON_INGOT);
                    break;
                case "GOLD_ORE": itemStack.setType(Material.GOLD_INGOT);
                    break;
                case "COBBLESTONE": itemStack.setType(Material.STONE);
                    break;
                default: break;
            }
        }

        if(PlayerDetails.instance().hasAutoAquireEnabled(player)) {
            HashMap<Integer, ItemStack> map = player.getInventory().addItem(item.getItemStack());

            //Map returns items not given to player
            boolean succesfull = map.isEmpty();


            if (succesfull) {
                event.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.1f, 1);
            }

            if (PlayerDetails.instance().hasNotificationsEnabled(player) && !succesfull) {
                player.sendMessage(ChatColor.RED + "Your inventory is full!");
                PlayerDetails.instance().removeAutoNotificationsEnabledTemporary(player);
            }
        }
    }
}
