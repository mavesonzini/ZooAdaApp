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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PensForm extends AppCompatActivity implements Serializable {

    private PenType [] penTypes;
    private ZooKeeper[] zooKeepers;

    private Spinner penTypeSpinner;
    private Spinner zookeeperSpinner;

    private String penTypeString;
    private String zookeeperString;
    private String dryAreaString;
    private String wetAreaString;
    private String volumeString;

    private EditText dryAreaEditText;
    private EditText wetAreaEditText;
    private EditText volumeEditText;
    private TextView spaceNumberLabel;
    private TextView animalTypeLabel;

    private Button createButton;

    private PenType selectedPen;
    private ZooKeeper selectedZookeeper;
    private double dryAreaDouble;
    private double wetAreaDouble;
    private double volumeDouble;
    private Pen newPen;
    private UUID penId;
    private List<UUID> animalIdList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pens_form);

        //Get penTypes and Zookeepers
        penTypes = PenType.getAllPenTypes();
        zooKeepers = ZooKeeper.getAllZookeepers();

        //Get view for all elements
        penTypeSpinner = findViewById(R.id.pen_type_spinner);
        zookeeperSpinner = findViewById(R.id.zookeeper_spinner);

        dryAreaEditText = findViewById(R.id.dry_area_editText);
        wetAreaEditText = findViewById(R.id.wet_area_editText);
        volumeEditText = findViewById(R.id.volume_area_editText);

        createButton = findViewById(R.id.create_pen_button);

        spaceNumberLabel = findViewById(R.id.space_number_label);
        animalTypeLabel  = findViewById(R.id.animal_assigned_label);


        //Set Adapters for pen type and zookeepers
        ArrayAdapter<PenType> pensAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, penTypes);

        ArrayAdapter<ZooKeeper> zookeepersAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, zooKeepers);


        pensAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zookeepersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        penTypeSpinner.setAdapter(pensAdapter);
        zookeeperSpinner.setAdapter(zookeepersAdapter);

        dryAreaEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        wetAreaEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        volumeEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        //set Text to labels
        animalTypeLabel.setText("This pen has no animals assigned to it!");
        spaceNumberLabel.setText("Tihs pen is EMPTY! 10 spaces left");



        penTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                PenType itemValue = (PenType) penTypeSpinner.getItemAtPosition(position);
                penTypeString = itemValue.toString();
                selectedPen = itemValue;
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + penTypeString, Toast.LENGTH_LONG)
                        .show();
                if (penTypeString == "Dry Pen") {
                    zookeeperSpinner.setEnabled(false);
                    zookeeperSpinner.setSelection(0);
                } else if (penTypeString == "Aquarium") {
                    zookeeperSpinner.setEnabled(false);
                    zookeeperSpinner.setSelection(1);
                } else if (penTypeString == "Part wet - part dry") {
                    zookeeperSpinner.setEnabled(false);
                    zookeeperSpinner.setSelection(1);
                } else if (penTypeString == "Aviary") {
                    zookeeperSpinner.setEnabled(false);
                    zookeeperSpinner.setSelection(2);
                } else if (penTypeString == "Petting pen") {
                    zookeeperSpinner.setEnabled(false);
                    zookeeperSpinner.setSelection(3);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),
                        "Pen type unselected", Toast.LENGTH_LONG)
                        .show();
            }
        });

        zookeeperSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                ZooKeeper itemValue = (ZooKeeper) zookeeperSpinner.getItemAtPosition(position);
                zookeeperString = itemValue.toString();
                selectedZookeeper = itemValue;
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + zookeeperString, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),
                        "Zookeeper unselected", Toast.LENGTH_LONG)
                        .show();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialize();
                if (isFormValid()) {
                    Intent intent = new Intent(PensForm.this, PensList.class);
                    startActivity(intent);
                }
                showAlerts();
                createPen();
            }
        });

    }

    public void createPen() {
        newPen = new Pen(penId, selectedPen, 10,dryAreaDouble, wetAreaDouble, volumeDouble, selectedZookeeper, animalIdList);

        Zoo zooInstance = Zoo.getInstance();
        zooInstance.addPen(newPen);
        zooInstance.increasePenCount();
    }

    private void initialize() {
            dryAreaString = dryAreaEditText.getText().toString();
            wetAreaString = wetAreaEditText.getText().toString().trim();
            volumeString = volumeEditText.getText().toString().trim();

            dryAreaDouble = Double.parseDouble(dryAreaString);
            wetAreaDouble = Double.parseDouble(wetAreaString);
            volumeDouble = Double.parseDouble(volumeString);
            penId = UUID.randomUUID();

    }

    private boolean isFormValid() {
        boolean valid = true;
        if (penTypeString == "No selection") {
            valid = false;
        }
        return valid;
    }

    private void showAlerts() {
        if (!isFormValid()) {
            AlertDialog alertDialog = new AlertDialog.Builder(PensForm.this).create();
            alertDialog.setTitle("No pentype found");
            alertDialog.setMessage("Please assign a pen type!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else {
            return;
        }
    }
}