package com.example.mavesonzini.zooadaapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by mavesonzini on 26/01/2018.
 */

class Zoo implements Serializable {
    private static Zoo ourInstance = new Zoo();
    public ZooKeeper[] zooKeepers;
    private HashMap<UUID, Pen> idsToPens = new HashMap<>();
    private HashMap<UUID, Animal> idsToAnimals = new HashMap<>();
    private HashMap<Pen, Animal> pensToAnimals = new HashMap<>();

    private int animalCount = 0;
    private int penCount = 0;

    static Zoo getInstance() {
        return ourInstance;
    }

    private Zoo() {
        zooKeepers = ZooKeeper.getAllZookeepers();
    }

    public static void initializeZoo(Zoo zoo) {
        ourInstance = zoo;
    }

    public List<Pen> getPens() {
        return new ArrayList<>(idsToPens.values());
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(idsToAnimals.values());
    }

    public Set<UUID> getPenIds() {
        return idsToPens.keySet();
    }

    public Pen getPenById(UUID penId) {
        return idsToPens.get(penId);
    }

    public Animal getAnimalById(UUID animalId) {
        return idsToAnimals.get(animalId);
    }

    public void addPen(Pen pen) {
        if (!getPens().contains(pen)) {
            idsToPens.put(pen.getPenId(), pen);
        }
    }

    public void addAnimal(Animal animal) {
        if (!getAnimals().contains(animal)) {
            idsToAnimals.put(animal.getAnimalId(), animal);
        }
    }

    public int getNumberOfAnimals() {
        return animalCount;
    }

    public int getNumberOfPens() {
        return penCount;
    }
    public void increaseAnimalCount() {
        animalCount = animalCount + 1;
    }

    public void increasePenCount() {
        penCount = penCount + 1;
    }

    public void decreaseAnimalCountInPen(UUID penId) {
        Pen pen = getPenById(penId);
        System.out.print(pen);
        int penCapacity = pen.capacity;
        if (penCapacity >= 1) {
            penCapacity = penCapacity - 1;
            pen.capacity = penCapacity;
        }
    }

    public void addAnimalToPen(UUID penId, UUID animalId){
        Pen pen = getPenById(penId);
        Animal animal = getAnimalById(animalId);
        pensToAnimals.put(pen, animal);
    }
}
