package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.UUID;

public class AnimalForm extends AppCompatActivity {
    private Spinner animaltypeSpinner;
    private Spinner penTypeSpinner;
    private Spinner pettingSpinner;
    private Spinner hostilitySpinner;
    private Spinner penAssignedSpinner;

    private AutoCompleteTextView areaEditText;
    private AutoCompleteTextView volumeEditText;

    private Button createAnimalButton;

    private String animalTypeString;
    private String penTypeString;
    private String penAssignedString;

    private AnimalType selectedAnimalType;
    private PenType selectedPenType;
    private PenType selectedAssignedPenType;
    private boolean selectedPettingOption;
    private boolean selectedHostileOption;
    private double selectedArea;
    private double selectedVolume;

    private AnimalType[] animalTypes = AnimalType.getAllAnimalTypes();
    private PenType[] penTypes = PenType.getAllPenTypes();
    private String[] boolOptionsArray = {"Yes", "No"};

    private Animal newAnimal;
    private UUID animalId;
    private String areaString;
    private String volumeString;
    private Double areaDouble;
    private Double volumeDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_form);

        animaltypeSpinner = findViewById(R.id.animal_type_spinner);
        penTypeSpinner = findViewById(R.id.penType_spinner);
        areaEditText = findViewById(R.id.area_peranimal_text_view);
        volumeEditText = findViewById(R.id.volume_peranimal_text_view);
        pettingSpinner = findViewById(R.id.can_pet_spinner);
        hostilitySpinner = findViewById(R.id.hostile_spinner);
        penAssignedSpinner = findViewById(R.id.pen_assigned_spinner);
        createAnimalButton = findViewById(R.id.create_animal_button);

        //Set Adapters for animalType type, penType, petting and hostility spinners
        ArrayAdapter<AnimalType> animalTypeArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, animalTypes);

        ArrayAdapter<PenType> penTypeArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, penTypes);

        ArrayAdapter<String> booleanArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, boolOptionsArray);

        animalTypeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        penTypeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        booleanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        animaltypeSpinner.setAdapter(animalTypeArrayAdapter);
        penTypeSpinner.setAdapter(penTypeArrayAdapter);
        pettingSpinner.setAdapter(booleanArrayAdapter);
        hostilitySpinner.setAdapter(booleanArrayAdapter);
        penAssignedSpinner.setAdapter(penTypeArrayAdapter);

        animaltypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                AnimalType itemValue = (AnimalType) animaltypeSpinner.getItemAtPosition(position);
                animalTypeString = itemValue.toString();
                selectedAnimalType = itemValue;
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + animalTypeString, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        penTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                PenType itemValue = (PenType) penTypeSpinner.getItemAtPosition(position);
                penTypeString = itemValue.toString();
                selectedPenType = itemValue;
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + penTypeString, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pettingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                String itemValue = (String) pettingSpinner.getItemAtPosition(position);
                selectedPettingOption = Boolean.valueOf(itemValue);
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + selectedPettingOption, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        hostilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                String itemValue = (String) hostilitySpinner.getItemAtPosition(position);
                selectedHostileOption = Boolean.valueOf(itemValue);
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + selectedHostileOption, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        penAssignedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                PenType itemValue = (PenType) penAssignedSpinner.getItemAtPosition(position);
                penAssignedString = itemValue.toString();
                selectedAssignedPenType = itemValue;
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + penAssignedString, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        createAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAnimal();
                Intent intent = new Intent(AnimalForm.this, AnimalsList.class);
                startActivity(intent);
            }
        });
    }

    public void createAnimal() {
        initialize();
        newAnimal = new Animal(animalId, selectedAnimalType, selectedPenType, selectedArea, selectedVolume, selectedAssignedPenType, selectedPettingOption, selectedHostileOption);

        Zoo zooInstance = Zoo.getInstance();
        zooInstance.addAnimal(newAnimal);
    }

    public void initialize(){
        areaString = areaEditText.getText().toString();
        volumeString = volumeEditText.getText().toString();

        areaDouble = Double.parseDouble(areaString);
        volumeDouble = Double.parseDouble(volumeString);
    }
}
