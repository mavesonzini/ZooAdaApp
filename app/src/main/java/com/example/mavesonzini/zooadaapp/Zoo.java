package com.example.mavesonzini.zooadaapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by mavesonzini on 26/01/2018.
 */

class Zoo {
    private static final Zoo ourInstance = new Zoo();
    public ZooKeeper[] zooKeepers;
    public HashMap<UUID, Pen> idsToPens = new HashMap<>();
    public HashMap<UUID, Animal> idsToAnimals = new HashMap<>();
    public int animalCount = 0;
    public int penCount = 0;

    static Zoo getInstance() {
        return ourInstance;
    }

    private Zoo() {
        zooKeepers = ZooKeeper.getAllZookeepers();

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

    public void addPen(Pen pen) {
        if (!getPens().contains(pen)) {
            UUID newUUID = UUID.randomUUID();
            idsToPens.put(newUUID, pen);
        }
    }

    public void addAnimal(Animal animal) {
        if (!getAnimals().contains(animal)) {
            UUID newUUID = UUID.randomUUID();
            idsToAnimals.put(newUUID, animal);
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
}
