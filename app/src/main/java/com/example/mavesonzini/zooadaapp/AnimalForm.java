package com.example.mavesonzini.zooadaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AnimalForm extends AppCompatActivity implements Serializable {
    private Spinner animaltypeSpinner;
    private Spinner pettingSpinner;
    private Spinner hostilitySpinner;
    private Spinner penAssignedSpinner;

    private AutoCompleteTextView landEditText;
    private AutoCompleteTextView waterEditText;
    private AutoCompleteTextView airEditText;
    private AutoCompleteTextView nameEditText;

    private Button createAnimalButton;
    private TextView nameLabel;

    private String animalTypeString;
    private String penAssignedString;

    private AnimalType selectedAnimalType;
    private Pen selectedAssignedPen;
    private boolean selectedPettingOption;
    private boolean selectedHostileOption;
    private double selectedLand;
    private double selectedWater;
    private double selectedAir;

    private AnimalType[] animalTypes = AnimalType.getAllAnimalTypes();
    private PenType[] penTypes = PenType.getAllPenTypes();
    private List<Pen> matchingPensList = new ArrayList<>();
    private String[] boolOptionsArray = {"true", "false"};

    private Animal newAnimal;
    private UUID animalId;
    private String landString;
    private String waterString;
    private String airString;
    private String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_form);

        matchingPensList = Pen.getMatchingPensForAnimal();

        animaltypeSpinner = findViewById(R.id.animal_type_spinner);
        landEditText = findViewById(R.id.land_peranimal_text_view);
        waterEditText = findViewById(R.id.water_peranimal_text_view2);
        airEditText = findViewById(R.id.air_peranimal_text_view);
        pettingSpinner = findViewById(R.id.can_pet_spinner);
        hostilitySpinner = findViewById(R.id.hostile_spinner);
        penAssignedSpinner = findViewById(R.id.pen_assigned_spinner);
        createAnimalButton = findViewById(R.id.create_animal_button);
        nameEditText = findViewById(R.id.name_edit_text);
        nameLabel = findViewById(R.id.name_label);

        //Set Adapters for animalType type, penType, petting and hostility spinners
        ArrayAdapter<AnimalType> animalTypeArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, animalTypes);

        ArrayAdapter<PenType> penTypeArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, penTypes);

        ArrayAdapter<String> booleanArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, boolOptionsArray);

        ArrayAdapter<Pen> matchingPenArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, matchingPensList);

        animalTypeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        penTypeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        booleanArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        matchingPenArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        animaltypeSpinner.setAdapter(animalTypeArrayAdapter);
        pettingSpinner.setAdapter(booleanArrayAdapter);
        hostilitySpinner.setAdapter(booleanArrayAdapter);
        penAssignedSpinner.setAdapter(matchingPenArrayAdapter);

        landEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        waterEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        airEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        animaltypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                AnimalType itemValue = (AnimalType) animaltypeSpinner.getItemAtPosition(position);
                animalTypeString = itemValue.toString();
                selectedAnimalType = itemValue;

                if (itemValue.getAnimalTypeEnum() != AnimalTypeEnum.OTHER) {
                    //Hide name label and editText
                    nameLabel.setVisibility(View.GONE);
                    nameEditText.setVisibility(View.GONE);

                    //disable all spinners
                    pettingSpinner.setEnabled(false);
                    pettingSpinner.setEnabled(false);
                    hostilitySpinner.setEnabled(false);
                    landEditText.setEnabled(false);
                    waterEditText.setEnabled(false);
                    airEditText.setEnabled(false);

                    //set default values for animal
                    landEditText.setText(itemValue.getLand());
                    waterEditText.setText(itemValue.getWater());
                    airEditText.setText(itemValue.getAir());

                    int isPet = Arrays.asList(boolOptionsArray).indexOf(itemValue.getIsPet());
                    int isHostileIndex = Arrays.asList(boolOptionsArray).indexOf(itemValue.getIsHostile());
                    pettingSpinner.setSelection(isPet);
                    hostilitySpinner.setSelection(isHostileIndex);
                } else {
                    //show name label and editText
                    nameLabel.setVisibility(View.VISIBLE);
                    nameEditText.setVisibility(View.VISIBLE);

                    //enable all spinners and txt fields
                    pettingSpinner.setEnabled(true);
                    pettingSpinner.setEnabled(true);
                    hostilitySpinner.setEnabled(true);
                    landEditText.setEnabled(true);
                    waterEditText.setEnabled(true);
                    airEditText.setEnabled(true);

                    //empty text fields
                    landEditText.setText(null);
                    waterEditText.setText(null);
                    airEditText.setText(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pettingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String itemValue = (String) pettingSpinner.getItemAtPosition(position);
                selectedPettingOption = Boolean.valueOf(itemValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        hostilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String itemValue = (String) hostilitySpinner.getItemAtPosition(position);
                selectedHostileOption = Boolean.valueOf(itemValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        penAssignedSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Pen itemValue = (Pen) penAssignedSpinner.getItemAtPosition(position);
                penAssignedString = itemValue.toString();
                selectedAssignedPen = itemValue;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        createAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              initialize();
              if (!isFormValid()){
                showAlerts();
              } else {
                Intent intent = new Intent(AnimalForm.this, AnimalsList.class);
                startActivity(intent);
                createAnimal();
              }
            }
        });
    }

  private void createAnimal() {
        if (selectedAnimalType.getAnimalTypeEnum() == AnimalTypeEnum.OTHER) {
            newAnimal = new Animal(animalId, nameString, selectedAnimalType, selectedLand, selectedWater, selectedAir, selectedAssignedPen, selectedPettingOption, selectedHostileOption);
        } else {
            newAnimal = new Animal(animalId, null, selectedAnimalType, selectedLand, selectedWater, selectedAir, selectedAssignedPen, selectedPettingOption, selectedHostileOption);
        }

        Zoo zooInstance = Zoo.getInstance();
        zooInstance.addAnimal(newAnimal);
        zooInstance.increaseAnimalCount();
        zooInstance.decreaseAnimalCountInPen(selectedAssignedPen.getPenId());
        zooInstance.addAnimalToPen(selectedAssignedPen.getPenId(), newAnimal.getAnimalId());
        selectedAssignedPen.addAnimalsToAnimalIdListFromPenId(selectedAssignedPen.getPenId(), animalId);
    }

    private void initialize() {
        nameString = nameEditText.getText().toString();
        landString = landEditText.getText().toString();
        waterString = waterEditText.getText().toString();
        airString = airEditText.getText().toString();
        animalId = UUID.randomUUID();

        selectedLand = Double.parseDouble(landString);
        selectedWater = Double.parseDouble(waterString);
        selectedAir = Double.parseDouble(airString);
    }

    private boolean isFormValid() {
      boolean valid = true;
      if (selectedAssignedPen.toString() == "Create a new pen!") {
        valid = false;
      }
      return valid;
    }
  private void showAlerts() {
      AlertDialog alertDialog = new AlertDialog.Builder(AnimalForm.this).create();
      alertDialog.setTitle("NO AVAILABLE PEN");
      alertDialog.setMessage("Please create a new pen for this animal!");
      alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
          new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
              dialog.dismiss();
              Intent intent = new Intent(AnimalForm.this, PensForm.class);
              startActivity(intent);
            }
          });
      alertDialog.show();
    }
}
