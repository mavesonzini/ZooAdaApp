package com.example.mavesonzini.zooadaapp;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by mavesonzini on 29/01/2018.
 */

public class Animal implements Serializable {
    private static UUID animalId;
    private AnimalType animalType;
    private double land;
    private double water;
    private double air;
    private Pen penAssigned;
    private boolean isPet;
    private boolean isHostile;
    private String name;

    public Animal(UUID animalId, String name, AnimalType animalType, double land, double water, double air, Pen penAssigned, boolean isPet, boolean isHostile) {
        this.animalId = animalId;
        this.name = name;
        this.animalType = animalType;
        this.land = land;
        this.water = water;
        this.air = air;
        this.penAssigned = penAssigned;
        this.isPet = isPet;
        this.isHostile = isHostile;
    }

    public String toString() {
        return this.animalType.toString();
    }

    public String getAssignedPen() {
        return this.penAssigned.toString();
    }

    public String getWater() {
        return String.valueOf(water);
    }

    public String getLand() {
        return String.valueOf(land);
    }
    public String getAir() {
        return String.valueOf(air);
    }

    public String getIsPet(){
        return String.valueOf(isPet);
    }

    public String getName() {
        return this.name;
    }

    public String getIsHostile() {
        return String.valueOf(isHostile);
    }

    public static UUID getAnimalId() {
        return animalId;
    }

}
