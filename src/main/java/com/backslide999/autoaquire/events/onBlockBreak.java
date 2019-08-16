package com.backslide999.autoaquire.events;

import com.backslide999.autoaquire.MinedBlockDetails;
import com.backslide999.autoaquire.PlayerDetails;
import com.backslide999.autoaquire.containers.MinedBlock;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

public class onBlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(!PlayerDetails.instance().hasAutoAquireEnabled(player))
            return;

        Block block = event.getBlock();
        Location loc = block.getLocation();
        MinedBlock minedBlock = new MinedBlock(player, loc, new Date());
        int exp = event.getExpToDrop();

        MinedBlockDetails.instance().addMinedBlock(minedBlock);
        player.giveExp(exp);
        event.setExpToDrop(0);
    }
}
