package com.backslide999.autopickup.containers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Date;

public class MinedBlock {

    private Date time;
    private Location location;
    private Player player;

    public MinedBlock(Player player, Location location, Date time){
        this.player = player;
        this.location = location;
        this.time = time;
    }

    public Location getLocation() {
        return this.location;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Date getTime() { return this.time; }

}
