package com.example.mavesonzini.zooadaapp;

import android.support.annotation.Nullable;

/**
 * Created by mavesonzini on 29/01/2018.
 */

public class AnimalType {
    private String animalTypeName;
    private PenType penType;
    private double land;
    private double water;
    private double air;
    private Pen assignedPen;

    public AnimalType(String animalTypeName, @Nullable PenType penType, double land, double water, double air, @Nullable Pen assignedPen){
        this.animalTypeName = animalTypeName;
        this.penType = penType;
        this.land = land;
        this.water = water;
        this.air = air;
        this.assignedPen = assignedPen;
    }

    public static AnimalType[] getAllAnimalTypes() {
        AnimalType sloth = new AnimalType("Sloth", PenType.getDryPen(), 3.0, 0.0, 0.0,null);
        AnimalType penguin = new AnimalType("Penguin", PenType.getPartWaterPartDry(), 2.0, 4.0, 0.0,null);
        AnimalType goat = new AnimalType("Goat", PenType.getDryPen(), 3.0, 0.0,0.0,null);
        AnimalType dog = new AnimalType("Dog", PenType.getPetting(), 3.5, 0.0, 0.0, null);
        AnimalType owl = new AnimalType("Owl", PenType.getAviary(), 0.0, 00.0,20, null);
        AnimalType dolphin = new AnimalType("Dolphin", PenType.getAquarium(), 0.0, 40.0,0, null);
        AnimalType hippo = new AnimalType("Hippo", PenType.getPartWaterPartDry(), 10.0, 20.0,0, null);
        AnimalType cat = new AnimalType("Cat", PenType.getPetting(), 4.0, 0.0, 0,null);
        AnimalType other = new AnimalType("Other...", null, 0.0, 0.0, 0,null);

        AnimalType[] animalTypes = {sloth, penguin, goat, dog, owl, dolphin, hippo, cat, other};

        return animalTypes;
    }


    @Override
    public String toString() {
        return this.animalTypeName;
    }

    public String getPenType() {
        return String.valueOf(penType);
    }

    public String getLand() {
        return String.valueOf(land);
    }

    public String getWater() {
        return String.valueOf(water);
    }

    public String getAir() {
        return String.valueOf(air);
    }

    public String getAssignedPen() {
        return String.valueOf(assignedPen);
    }
}