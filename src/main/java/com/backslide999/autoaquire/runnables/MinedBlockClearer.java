package com.backslide999.autoaquire.runnables;

import com.backslide999.autoaquire.MinedBlockDetails;
import com.backslide999.autoaquire.containers.MinedBlock;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Date;
import java.util.logging.Logger;

public class MinedBlockClearer implements Runnable{


    @Override
    public void run() {
        Date threshHold = new Date();
        threshHold.setTime(threshHold.getTime() - 1000);
        MinedBlockDetails.instance().getMinedBlocks()
                .stream()
                .filter(minedBlock -> {
                    return minedBlock.getTime().before(threshHold);
                })
                .forEach(minedBlock -> {
                    MinedBlockDetails.instance().removeMinedBlock(minedBlock);
                });
    }
}
