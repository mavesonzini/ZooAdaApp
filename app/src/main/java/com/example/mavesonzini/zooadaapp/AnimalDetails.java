package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class AnimalDetails extends AppCompatActivity implements Serializable {
    private TextView animalNameTextView;
    private TextView landTextView;
    private TextView waterTextView;
    private TextView airTextView;
    private TextView penAssignedTextView;
    private TextView pettingTextView;

    private Button backToListButton;

    private String animalName;
    private String land;
    private String water;
    private String air;
    private String assignedPen;
    private String petting;
    private String name;

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
        backToListButton = findViewById(R.id.back_animal_list_button);

        if (getAnimalNameFromSelectedRow() == "Other...") {
            animalNameTextView.setText(getNameFromSelectedRow());
            landTextView.setText(getAreaFromSelectedRow());
            waterTextView.setText(getVolumeFromSelectedRow());
            airTextView.setText(getAirFromSelectedRow());
            penAssignedTextView.setText(getAssignedPenFromSelectedRow());
            pettingTextView.setText(getPettingFromSelectedRow());

        } else {
            animalNameTextView.setText(getAnimalNameFromSelectedRow());
            animalNameTextView.setText(getAnimalNameFromSelectedRow());
            landTextView.setText(getAreaFromSelectedRow());
            waterTextView.setText(getVolumeFromSelectedRow());
            airTextView.setText(getAirFromSelectedRow());
            penAssignedTextView.setText(getAssignedPenFromSelectedRow());
            pettingTextView.setText(getPettingFromSelectedRow());
        }

        backToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimalDetails.this.finish();
            }
        });

    }

    public String getAnimalNameFromSelectedRow() {
        animalName = AnimalsList.getItemFromSelectedPosition().toString();
        System.out.print(animalName);
        return animalName;
    }

    public String getAreaFromSelectedRow() {
        land =  AnimalsList.getItemFromSelectedPosition().getLandString();
        return land;
    }

    public String getVolumeFromSelectedRow() {
        water = AnimalsList.getItemFromSelectedPosition().getWaterString();
        return water;
    }

    public String getAirFromSelectedRow() {
        air = AnimalsList.getItemFromSelectedPosition().getAirString();
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

    public String getNameFromSelectedRow() {
        name = AnimalsList.getItemFromSelectedPosition().getName();
        System.out.print(name);
        return name;
    }

}


