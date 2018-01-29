package com.example.mavesonzini.zooadaapp;

import java.util.UUID;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class Pen {
    private UUID penId;
    private PenType penType;
    private double dryArea;
    private double wetArea;
    private double volume;
    private ZooKeeper zookeeper;

    public Pen(UUID penId, PenType penType, double dryArea, double wetArea, double  volume, ZooKeeper zooKeeper) {
        this.penId = penId;
        this.penType = penType;
        this.dryArea = dryArea;
        this.wetArea = wetArea;
        this.volume = volume;
        this.zookeeper = zooKeeper;
    }

    @Override
    public String toString() {
        return this.penType.toString();
    }
}
