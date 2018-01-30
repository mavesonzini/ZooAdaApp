package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AnimalDetails extends AppCompatActivity {
    private TextView animalNameTextView;
    private TextView penTypeTextView;
    private TextView areaTextView;
    private TextView volumeTextView;
    private TextView penAssignedTextView;
    private TextView pettingTextView;

    private String animalName;
    private String penType;
    private String area;
    private String volume;
    private String asiignedPen;
    private String petting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        animalNameTextView = findViewById(R.id.animal_name_label);
        penTypeTextView = findViewById(R.id.animal_lives_in_pen_label);
        areaTextView = findViewById(R.id.animal_area_label);
        volumeTextView = findViewById(R.id.animal_volume_label);
        penAssignedTextView = findViewById(R.id.animal_assigned_pen_label);
        pettingTextView = findViewById(R.id.animal_pet_label);

        animalNameTextView.setText(getAnimalNameFromSelectedRow());
        penTypeTextView.setText(getPenTypeFromSelectedRow());
        areaTextView.setText(getAreaFromSelectedRow());
        volumeTextView.setText(getVolumeFromSelectedRow());
        penAssignedTextView.setText(getAsiignedPenFromSelectedRow());
        pettingTextView.setText(getPettingFromSelectedRow());
    }

    public String getAnimalNameFromSelectedRow() {
        animalName = AnimalsList.getItemFromSelectedPosition().toString();
        return penType;
    }

    public String getPenTypeFromSelectedRow() {
        penType = AnimalsList.getItemFromSelectedPosition().getPenType();
        return penType;
    }

    public String getAreaFromSelectedRow() {
        area =  AnimalsList.getItemFromSelectedPosition().getArea();
        return area;
    }

    public String getVolumeFromSelectedRow() {
        volume = AnimalsList.getItemFromSelectedPosition().getVolume();
        return volume;
    }

    public String getAsiignedPenFromSelectedRow() {
        asiignedPen = AnimalsList.getItemFromSelectedPosition().getAssignedPen();
        return asiignedPen;
    }

    public String getPettingFromSelectedRow() {
        petting = AnimalsList.getItemFromSelectedPosition().getIsPet();
        return petting;
    }
}


