package com.example.mavesonzini.zooadaapp;

import java.util.UUID;

/**
 * Created by mavesonzini on 29/01/2018.
 */

public class Animal {
    private static UUID animalId;
    private AnimalType animalType;
    private PenType penType;
    private double area;
    private double volume;
    private PenType penAssigned;
    private boolean isPet;
    private boolean isHostile;

    public Animal(UUID animalId, AnimalType animalType, PenType penType, double area, double volume, PenType penAssigned, boolean isPet, boolean isHostile) {
        this.animalId = animalId;
        this.animalType = animalType;
        this.penType = penType;
        this.area = area;
        this.volume = volume;
        this.penAssigned = penAssigned;
        this.isPet = isPet;
        this.isHostile = isHostile;
    }

    public String toString() {
        return this.animalType.toString();
    }

    public String getPenType() {
        return this.penType.toString();
    }

    public String getAssignedPen() {
        return this.penAssigned.toString();
    }

    public String getVolume() {
        return String.valueOf(volume);
    }

    public String getArea() {
        return String.valueOf(area);
    }

    public String getIsPet(){
        return String.valueOf(isPet);
    }

    public String getIsHostile() {
        return String.valueOf(isHostile);
    }

    public static UUID getAnimalId() {
        return animalId;
    }

}
