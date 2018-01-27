package com.example.mavesonzini.zooadaapp;

import java.util.List;

/**
 * Created by mavesonzini on 26/01/2018.
 */

public class ZooKeeper {
    private String name;
    private String[] penTypes;

    public static ZooKeeper[] getAllZookeepers() {
        String[] hardipPenTypes = {"Dry Pen"};
        String[] alexPens = {"Aquarium", "Part water, part Dry"};
        String[] farhadPens = {"Aviary"};
        String[] alanPens = {"Petting pen"};

        ZooKeeper hardip = new ZooKeeper("Hardip", hardipPenTypes);
        ZooKeeper alex = new ZooKeeper("Alex", alexPens);
        ZooKeeper farhad = new ZooKeeper("Farhad", farhadPens);
        ZooKeeper alan = new ZooKeeper("Alan", alanPens);

        ZooKeeper[] zookeepers = {hardip, alex, farhad, alan};

        return  zookeepers;
    }

    public ZooKeeper(String name, String[] penTypes){
        this.name = name;
        this.penTypes = penTypes;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
