package com.backslide999.autoaquire;

import com.backslide999.autoaquire.containers.MinedBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class MinedBlockDetails {

    private static MinedBlockDetails _instance;
    public static MinedBlockDetails instance(){
        if(_instance == null)
            _instance = new MinedBlockDetails();
        return _instance;
    }

    private CopyOnWriteArrayList<MinedBlock> minedBlocks;

    private MinedBlockDetails(){
        this.minedBlocks = new CopyOnWriteArrayList <MinedBlock>();
    }

    public CopyOnWriteArrayList <MinedBlock> getMinedBlocks() { return this.minedBlocks; }
    public boolean addMinedBlock(MinedBlock block) {
        return this.minedBlocks.add(block);
    }
    public boolean removeMinedBlock(MinedBlock block) {return this.minedBlocks.remove(block);}



}
