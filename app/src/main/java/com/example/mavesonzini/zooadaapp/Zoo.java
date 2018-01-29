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

    static Zoo getInstance() {
        return ourInstance;
    }

    private Zoo() {
        zooKeepers = ZooKeeper.getAllZookeepers();

    }

    public List<Pen> getPens() {
        return new ArrayList<>(idsToPens.values());
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
}
