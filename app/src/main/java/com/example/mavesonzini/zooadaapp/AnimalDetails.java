package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnimalDetails extends AppCompatActivity {
    private TextView animalNameTextView;
    private TextView landTextView;
    private TextView waterTextView;
    private TextView airTextView;
    private TextView penAssignedTextView;
    private TextView pettingTextView;

    private String animalName;
    private String land;
    private String water;
    private String air;
    private String assignedPen;
    private String petting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        animalNameTextView = findViewById(R.id.animal_name_label);
        landTextView = findViewById(R.id.animal_area_label);
        waterTextView = findViewById(R.id.animal_volume_label);
        airTextView = findViewById(R.id.air_peranimal_text_view);
        penAssignedTextView = findViewById(R.id.animal_assigned_pen_label);
        pettingTextView = findViewById(R.id.animal_pet_label);

        animalNameTextView.setText(getAnimalNameFromSelectedRow());
        landTextView.setText(getAreaFromSelectedRow());
        waterTextView.setText(getVolumeFromSelectedRow());
        airTextView.setText(getAirFromSelectedRow());
        penAssignedTextView.setText(getAssignedPenFromSelectedRow());
        pettingTextView.setText(getPettingFromSelectedRow());
    }

    public String getAnimalNameFromSelectedRow() {
        animalName = AnimalsList.getItemFromSelectedPosition().toString();
        return animalName;
    }

    public String getAreaFromSelectedRow() {
        land =  AnimalsList.getItemFromSelectedPosition().getLand();
        return land;
    }

    public String getVolumeFromSelectedRow() {
        water = AnimalsList.getItemFromSelectedPosition().getWater();
        return water;
    }

    public String getAirFromSelectedRow() {
        air = AnimalsList.getItemFromSelectedPosition().getAir();
        return air;
    }

    public String getAssignedPenFromSelectedRow() {
        assignedPen = AnimalsList.getItemFromSelectedPosition().getAssignedPen();
        return assignedPen;
    }

    public String getPettingFromSelectedRow() {
        petting = AnimalsList.getItemFromSelectedPosition().getIsPet();
        return petting;
    }

}


