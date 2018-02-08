package com.example.mavesonzini.zooadaapp;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by mavesonzini on 29/01/2018.
 */

public class AnimalType extends Animal implements Serializable {
    private String animalTypeName;
    private String name;
    private PenType assignedPen;

    private AnimalTypeEnum type;

    public AnimalType(String animalTypeName, @Nullable PenType penType, double land, double water, double air, @Nullable PenType assignedPen, boolean isHostile, boolean isPet, AnimalTypeEnum type){
        super();
        this.animalTypeName = animalTypeName;
        this.assignedPen = assignedPen;
        this.type = type;
    }

    public AnimalType(String animalTypeName, String name, @Nullable PenType penType, double land, double water, double air, @Nullable PenType assignedPen, boolean isHostile, boolean isPet, AnimalTypeEnum type){
        super();
        this.animalTypeName = animalTypeName;
        this.assignedPen = assignedPen;
        this.name = name;
        this.type = type;
    }

    public static AnimalType[] getAllAnimalTypes() {
        AnimalType sloth = new AnimalType("Sloth", PenType.getDryPen(), 3.0, 0.0, 0.0,null, false, false, AnimalTypeEnum.SLOTH);
        AnimalType penguin = new AnimalType("Penguin", PenType.getPartWaterPartDry(), 2.0, 4.0, 0.0,null, false, false , AnimalTypeEnum.PENGUIN);
        AnimalType goat = new AnimalType("Goat", PenType.getDryPen(), 3.0, 0.0,0.0,null, false, true, AnimalTypeEnum.GOAT);
        AnimalType dog = new AnimalType("Dog", PenType.getPetting(), 3.5, 0.0, 0.0, null, false, true, AnimalTypeEnum.DOG);
        AnimalType owl = new AnimalType("Owl", PenType.getAviary(), 0.0, 00.0,20, null, false, false, AnimalTypeEnum.OWL);
        AnimalType dolphin = new AnimalType("Dolphin", PenType.getAquarium(), 0.0, 40.0,0, null, false, false, AnimalTypeEnum.DOLPHIN);
        AnimalType hippo = new AnimalType("Hippo", PenType.getPartWaterPartDry(), 10.0, 20.0,0, null, false, false, AnimalTypeEnum.HIPPO);
        AnimalType cat = new AnimalType("Cat", PenType.getPetting(), 4.0, 0.0, 0,null, false, true, AnimalTypeEnum.CAT);
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

    public String getAssignedPen() {
        return String.valueOf(assignedPen);
    }

    public AnimalTypeEnum getAnimalTypeEnum() {
        return this.type;
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
    OTHER
}