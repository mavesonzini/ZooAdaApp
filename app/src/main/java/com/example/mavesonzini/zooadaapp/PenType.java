package com.example.mavesonzini.zooadaapp;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class PenType implements Serializable {
        private String penTypeName;
        private static PenType[] penTypes = PenType.getAllPenTypes();
        private String responsibleZookeeper;

    public PenType(String penTypeName, String responsibleZookeeper) {
            this.penTypeName = penTypeName;
            this.responsibleZookeeper = responsibleZookeeper;
        }

    public static PenType createNewPen = new PenType("Create a new pen!", null);

    public static PenType[] getAllPenTypes() {
            PenType dryPen = new PenType("Dry Pen", "HARDIP");
            PenType aquarium =  new PenType("Aquarium", "ALEX");
            PenType partWaterPartDry = new PenType("Part water - part dry", "ALEX");
            PenType aviary = new PenType("Aviary", "FARHAD");
            PenType pettingPen = new PenType("Petting pen", "ALAN");
            PenType empty = new PenType("No selection", null);

            PenType[] penTypes = {empty, dryPen, aquarium, partWaterPartDry, aviary, pettingPen};
            return penTypes;
        }

        public static PenType getDryPen() {
            return penTypes[0];
        }

        public static PenType getAquarium() {
        return penTypes[1];
        }

        public static PenType getPartWaterPartDry() {
        return penTypes[2];
        }

        public static PenType getAviary() {
            return penTypes[3];
        }

        public static PenType getPetting() {
            return penTypes[4];
        }

        public static PenType getCreateNewPen() {
            return createNewPen;
        }

    @Override
    public String toString() {
        return this.penTypeName;
    }
}
