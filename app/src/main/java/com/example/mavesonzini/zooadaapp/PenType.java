package com.example.mavesonzini.zooadaapp;

/**
 * Created by mavesonzini on 27/01/2018.
 */

public class PenType {
        private String penTypeName;

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


    @Override
    public String toString() {
        return this.penTypeName;
    }
}
