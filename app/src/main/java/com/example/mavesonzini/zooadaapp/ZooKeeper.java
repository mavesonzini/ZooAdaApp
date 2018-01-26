package com.example.mavesonzini.zooadaapp;

/**
 * Created by mavesonzini on 26/01/2018.
 */

public class ZooKeeper {
    private String name;
    private String[] penTypes;

    public static ZooKeeper[] getAllZookeepers() {
        String[] hardipPenTypes = {"Dry Pen"};
        ZooKeeper hardip = new ZooKeeper("Hardip", hardipPenTypes);
        String[] alexPens = {"Aquarium", "Part water, part Dry"};
        ZooKeeper alex = new ZooKeeper("Alex", alexPens);
        String[] farhadPens = {"Aviary"};
        ZooKeeper farhad = new ZooKeeper("Farhad", farhadPens);
        String[] alanPens = {"Petting pen"};
        ZooKeeper alan = new ZooKeeper("Alan", alanPens);

        ZooKeeper[] zookeepers = {hardip, alex, farhad, alan};

        return  zookeepers;
    }

    public ZooKeeper(String name, String[] penTypes){
        this.name = name;
        this.penTypes = penTypes;
    }
}
