package com.example.mavesonzini.zooadaapp;

/**
 * Created by mavesonzini on 26/01/2018.
 */

class Zoo {
    private static final Zoo ourInstance = new Zoo();

    static Zoo getInstance() {
        return ourInstance;
    }

    private Zoo() {
        ZooKeeper.getAllZookeepers();
    }
}
