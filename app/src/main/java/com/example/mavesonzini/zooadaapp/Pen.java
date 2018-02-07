package com.example.mavesonzini.zooadaapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.RecursiveTask;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class Pen implements Serializable {
    private UUID penId;
    private UUID animalId;
    private PenType penType;
    public int capacity;
    private double dryArea;
    private double wetArea;
    private double volume;
    private ZooKeeper zookeeper;
    private List<UUID> animalIdList;


    public Pen(UUID penId, PenType penType, int capacity, double dryArea, double wetArea, double  volume, ZooKeeper zooKeeper, List<UUID> animalIdList) {
        this.penId = penId;
        this.penType = penType;
        this.capacity = capacity;
        this.dryArea = dryArea;
        this.wetArea = wetArea;
        this.volume = volume;
        this.zookeeper = zooKeeper;
        this.animalIdList = animalIdList;

    }

    @Override
    public String toString() {
        return this.penType.toString();
    }

    public List<UUID> getAnimalIdList() {
        return animalIdList;
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

    public void addAnimalsToAnimalIdListFromPenId(UUID penId, UUID animalId) {
        Pen pen = zooInstance.getPenById(penId);
        pen.animalIdList.add(animalId);
    }

    public List<UUID> getAnimalListForPen(UUID penId) {
        Pen pen = zooInstance.getPenById(penId);
        return pen.animalIdList;
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

}
