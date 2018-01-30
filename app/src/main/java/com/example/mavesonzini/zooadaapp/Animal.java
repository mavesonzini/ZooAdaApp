package com.example.mavesonzini.zooadaapp;

/**
 * Created by mavesonzini on 29/01/2018.
 */

public class Animal {
    private AnimalType animalType;
    private PenType penType;
    private double area;
    private double volume;
    private Pen penAssigned;

    public Animal(AnimalType animalType, PenType penType, double area, double volume, Pen penAssigned) {
        this.animalType = animalType;
        this.penType = penType;
        this.area = area;
        this.volume = volume;
        this.penAssigned = penAssigned;
    }
}
