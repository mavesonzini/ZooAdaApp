package com.example.mavesonzini.zooadaapp;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class Pen {
    private PenType penType;
    private double dryArea;
    private double wetArea;
    private double volume;
    private ZooKeeper zookeeper;

    public Pen(PenType penType, double dryArea, double wetArea, double  volume, ZooKeeper zooKeeper) {
        this.penType = penType;
        this.dryArea = dryArea;
        this.wetArea = wetArea;
        this.volume = volume;
        this.zookeeper = zooKeeper;
    }
}
