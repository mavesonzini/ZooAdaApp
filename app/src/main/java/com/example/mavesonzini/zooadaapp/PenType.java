package com.example.mavesonzini.zooadaapp;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class PenType {
        private String penTypeName;
        private static PenType[] penTypes = PenType.getAllPenTypes();

        public PenType(String penTypeName) {
            this.penTypeName = penTypeName;
        }
        public static PenType[] getAllPenTypes() {
            PenType dryPen = new PenType("Dry Pen");
            PenType aquarium =  new PenType("Aquarium");
            PenType partWaterPartDry = new PenType("Part water - part dry");
            PenType aviary = new PenType("Aviary");
            PenType pettingPen = new PenType("Petting pen");

            PenType[] penTypes = {dryPen, aquarium, partWaterPartDry, aviary, pettingPen};
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


    @Override
    public String toString() {
        return this.penTypeName;
    }
}
