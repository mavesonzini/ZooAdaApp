package com.example.mavesonzini.zooadaapp;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by mavesonzini on 29/01/2018.
 */

public class AnimalType implements Serializable {
    private String animalTypeName;
    private String name;
    private PenType penType;
    private double land;
    private double water;
    private double air;
    private PenType assignedPen;
    private boolean isHostile;
    private boolean isPet;
    private AnimalTypeEnum type;
    private int animalSize;

    public AnimalType(String animalTypeName, @Nullable PenType penType, double land, double water, double air, @Nullable PenType assignedPen, boolean isHostile, boolean isPet, AnimalTypeEnum type, int animalSize){
        this.animalTypeName = animalTypeName;
        this.penType = penType;
        this.land = land;
        this.water = water;
        this.air = air;
        this.assignedPen = assignedPen;
        this.isHostile = isHostile;
        this.isPet = isPet;
        this.type = type;
        this.animalSize = animalSize;
    }

    public AnimalType(String animalTypeName, String name, @Nullable PenType penType, double land, double water, double air, @Nullable PenType assignedPen, boolean isHostile, boolean isPet, AnimalTypeEnum type){
        this.animalTypeName = animalTypeName;
        this.penType = penType;
        this.land = land;
        this.water = water;
        this.air = air;
        this.assignedPen = assignedPen;
        this.isHostile = isHostile;
        this.isPet = isPet;
        this.name = name;
        this.type = type;
    }

    public static AnimalType[] getAllAnimalTypes() {
        AnimalType sloth = new AnimalType("Sloth", PenType.getDryPen(), 3.0, 0.0, 0.0,null, false, false, AnimalTypeEnum.SLOTH, 2);
        AnimalType penguin = new AnimalType("Penguin", PenType.getPartWaterPartDry(), 2.0, 4.0, 0.0,null, false, false , AnimalTypeEnum.PENGUIN, 1);
        AnimalType goat = new AnimalType("Goat", PenType.getDryPen(), 3.0, 0.0,0.0,null, false, true, AnimalTypeEnum.GOAT, 2);
        AnimalType dog = new AnimalType("Dog", PenType.getPetting(), 3.5, 0.0, 0.0, null, false, true, AnimalTypeEnum.DOG, 2);
        AnimalType owl = new AnimalType("Owl", PenType.getAviary(), 0.0, 00.0,20, null, false, false, AnimalTypeEnum.OWL, 1);
        AnimalType dolphin = new AnimalType("Dolphin", PenType.getAquarium(), 0.0, 40.0,0, null, false, false, AnimalTypeEnum.DOLPHIN, 3);
        AnimalType hippo = new AnimalType("Hippo", PenType.getPartWaterPartDry(), 10.0, 20.0,0, null, false, false, AnimalTypeEnum.HIPPO, 3);
        AnimalType cat = new AnimalType("Cat", PenType.getPetting(), 4.0, 0.0, 0,null, false, true, AnimalTypeEnum.CAT, 1);
        AnimalType other = new AnimalType("Other...", "",  null, 0.0, 0.0, 0,null, false, false, AnimalTypeEnum.OTHER);

        AnimalType[] animalTypes = {sloth, penguin, goat, dog, owl, dolphin, hippo, cat, other};

        return animalTypes;
    }

    @Override
    public String toString() {
        return this.animalTypeName;
    }

    public String getName() {
        return name;
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

    public String getIsHostile() {
        String string = String.valueOf(isHostile);
        return string;
    }

    public String getIsPet() {
        return String.valueOf(isPet);
    }

    public AnimalTypeEnum getAnimalTypeEnum() {
        return this.type;
    }

    public String getAnimalName(){
        return name;
    }
}

enum AnimalTypeEnum {
    SLOTH,
    PENGUIN,
    DOG,
    GOAT,
    OWL,
    DOLPHIN,
    HIPPO,
    CAT,
    OTHER;


}