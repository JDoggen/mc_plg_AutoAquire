package com.backslide999.autopickup.runnables;

import com.backslide999.autopickup.MinedBlockDetails;

import java.util.Date;

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
