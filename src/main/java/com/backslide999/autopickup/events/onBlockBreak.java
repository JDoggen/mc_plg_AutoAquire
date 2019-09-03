package com.backslide999.autopickup.events;

import com.backslide999.autopickup.MinedBlockDetails;
import com.backslide999.autopickup.PlayerDetails;
import com.backslide999.autopickup.containers.MinedBlock;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Date;

public class onBlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        //Only store events from players that either have autopickup or autofurnce enabled
        if(!PlayerDetails.instance().hasAutoPickupEnabled(player)
                && !PlayerDetails.instance().hasAutoSmeltEnabled(player))
            return;

        //Player might have lost permission once enabled
        if(!player.hasPermission("autopickup.autopickup") && !player.hasPermission("autopickup.autosmelt")){
            PlayerDetails.instance().removeAutoSmeltEnabled(player);
            PlayerDetails.instance().removeAutoPickupEnable(player);
            return;
        }


        Block block = event.getBlock();
        Location loc = block.getLocation();
        MinedBlock minedBlock = new MinedBlock(player, loc, new Date());
        int exp = event.getExpToDrop();

        MinedBlockDetails.instance().addMinedBlock(minedBlock);
        player.giveExp(exp);
        event.setExpToDrop(0);
    }
}
