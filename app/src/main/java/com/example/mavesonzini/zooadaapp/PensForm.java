package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.UUID;

public class PensForm extends AppCompatActivity {

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
    private Button createButton;
    private PenType selectedPen;
    private ZooKeeper selectedZookeeper;
    private double dryAreaDouble;
    private double wetAreaDouble;
    private double volumeDouble;
    private Pen newPen;
    private UUID penId;

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

        //Set Adapters for pen type and zookeepers
        ArrayAdapter<PenType> pensAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, penTypes);

        ArrayAdapter<ZooKeeper> zookeepersAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, zooKeepers);


        pensAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zookeepersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        penTypeSpinner.setAdapter(pensAdapter);
        zookeeperSpinner.setAdapter(zookeepersAdapter);

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
                createPen();

                Intent intent = new Intent(PensForm.this, PensList.class);
                startActivity(intent);
            }
        });
    }

    public void createPen() {
        initialize();
        if (!validate()) {
            Toast.makeText(this, "Don't leave areas empty!", Toast.LENGTH_SHORT).show();
        }
//        newPen = new Pen(penId, selectedPen, dryAreaDouble, wetAreaDouble, volumeDouble, selectedZookeeper);

        Zoo zooInstance = Zoo.getInstance();
        zooInstance.addPen(newPen);
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

    private boolean validate() {
        boolean valid = true;

        if (dryAreaString.isEmpty() || dryAreaString.length() > 6 || wetAreaString.isEmpty() || wetAreaString.length() > 6 || volumeString.isEmpty() || volumeString.length() > 6) {
            dryAreaEditText.setError("Please enter valid numbers");
            valid = false;
        }
        return valid;
    }
}
