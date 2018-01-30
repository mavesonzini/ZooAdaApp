package com.example.mavesonzini.zooadaapp;

import android.support.annotation.Nullable;

/**
 * Created by mavesonzini on 29/01/2018.
 */

public class AnimalType {
    private String animalTypeName;
    private PenType penType;
    private double area;
    private double volume;
    private Pen assignedPen;

    public AnimalType(String animalTypeName, @Nullable PenType penType, double area, double volume,  @Nullable Pen assignedPen){
        this.animalTypeName = animalTypeName;
        this.penType = penType;
        this.area = area;
        this.volume = volume;
        this.assignedPen = assignedPen;
    }

    public static AnimalType[] getAllAnimalTypes() {
        AnimalType sloth = new AnimalType("Sloth", PenType.getDryPen(), 3.0, 0.0, null);
        AnimalType penguin = new AnimalType("Penguin", PenType.getPartWaterPartDry(), 2.0, 4.0, null);
        AnimalType goat = new AnimalType("Goat", PenType.getDryPen(), 3.0, 0.0,null);
        AnimalType dog = new AnimalType("Dog", PenType.getPetting(), 3.5, 0.0, null);
        AnimalType owl = new AnimalType("Owl", PenType.getAviary(), 0.0, 20.0, null);
        AnimalType dolphin = new AnimalType("Dolphin", PenType.getAquarium(), 0.0, 40.0, null);
        AnimalType hippo = new AnimalType("Hippo", PenType.getPartWaterPartDry(), 10.0, 20.0, null);
        AnimalType cat = new AnimalType("Cat", PenType.getPetting(), 4.0, 0.0, null);
        AnimalType other = new AnimalType("Other...", null, 0.0, 0.0, null);

        AnimalType[] animalTypes = {sloth, penguin, goat, dog, owl, dolphin, hippo, cat, other};

        return animalTypes;
    }
}