package com.example.mavesonzini.zooadaapp;

import java.io.Serializable;

/**
 * Created by mavesonzini on 26/01/2018.
 */

public class ZooKeeper implements Serializable {
    private static ZooKeeper ourInstance = new ZooKeeper();
    private String name;
    private String[] penTypes;
    public int penCount;

    static ZooKeeper getInstance() {
        return ourInstance;
    }

    public static ZooKeeper[] getAllZookeepers() {
        String[] hardipPenTypes = {"DRY PEN"};
        String[] alexPens = {"AQUARIUM", "PART WATER, PART DRY"};
        String[] farhadPens = {"AVIARY"};
        String[] alanPens = {"PETTING PEN"};

        ZooKeeper hardip = new ZooKeeper("HARDIP", hardipPenTypes);
        ZooKeeper alex = new ZooKeeper("ALEX", alexPens);
        ZooKeeper farhad = new ZooKeeper("FARHAD", farhadPens);
        ZooKeeper alan = new ZooKeeper("ALAN", alanPens);

        ZooKeeper[] zookeepers = {hardip, alex, farhad, alan};

        return  zookeepers;
    }

    public ZooKeeper(String name, String[] penTypes){
        this.name = name;
        this.penTypes = penTypes;
        this.penCount = 0;
    }

    public ZooKeeper() {}

    @Override
    public String toString() {
        return this.name;
    }

    public String[] getPenTypes(){
        return this.penTypes;
    }
}