package com.example.mavesonzini.zooadaapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class Pen implements Serializable {
    private UUID penId;
    private PenType penType;
    public int capacity = 10;
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

    public String getCapacity() {
        return String.valueOf(capacity);
    }

    public UUID getPenId() {
        return penId;
    }

    private static Zoo zooInstance = Zoo.getInstance();

    public static List<Pen> getMatchingPensForAnimal() {
        List<Pen> pens = zooInstance.getPens();
        List<Pen> matchingPens = new ArrayList<>();
        for (int i = 0; i < pens.size(); i ++) {
            Pen pen = pens.get(i);
            if (pen.capacity >= 1) {
                matchingPens.add(pen);
            }
        }
        return matchingPens;
    }

//    public static int getAnimalCountForPen(){
//        List<Pen> pens = zooInstance.getPens();
//        for (int i = 0; i < pens.size(); i ++) {
//            Pen pen = pens.get(i);
//
//        }
//    }
}
