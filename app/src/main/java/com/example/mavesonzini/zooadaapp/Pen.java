package com.example.mavesonzini.zooadaapp;

import java.util.UUID;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class Pen {
    private static UUID penId;
    private PenType penType;
    private int capacity;
    private double dryArea;
    private double wetArea;
    private double volume;
    private ZooKeeper zookeeper;

    public Pen(UUID penId, PenType penType, int capacity, double dryArea, double wetArea, double  volume, ZooKeeper zooKeeper) {
        this.penId = penId;
        this.penType = penType;
        this.capacity = capacity;
        this.dryArea = dryArea;
        this.wetArea = wetArea;
        this.volume = volume;
        this.zookeeper = zooKeeper;
    }

    @Override
    public String toString() {
        return this.penType.toString();
    }
    
    public String getDryArea() {
        return String.valueOf(dryArea);
    }

    public String getWetArea() {
        return String.valueOf(wetArea);
    }

    public String getVolume() {
        return String.valueOf(volume);
    }

    public String getZookeeper() {
        return this.zookeeper.toString();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public static UUID getPenId() {
        return penId;
    }

    public void setCapacity(int animalSize) {
        if (animalSize == 1) {
            capacity = 10;
        } else if (animalSize == 2) {
            capacity = 5;
        } else {
            capacity = 2;
        }
    }
}
