package com.backslide999.autoaquire.events;

import com.backslide999.autoaquire.MinedBlockDetails;
import com.backslide999.autoaquire.PlayerDetails;
import com.backslide999.autoaquire.containers.MinedBlock;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
        HashMap<Integer, ItemStack> map = player.getInventory().addItem(item.getItemStack());

        boolean succesfull = map.isEmpty();
        //Map returns items not given to player
        event.setCancelled(succesfull);
        if(PlayerDetails.instance().hasNotificationsEnabled(player) && !succesfull){
            player.sendMessage(ChatColor.RED + "Your inventory is full!");
        }
    }
}
