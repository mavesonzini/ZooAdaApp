package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class PensForm extends AppCompatActivity {

    private PenType [] penTypes;
    private ZooKeeper[] zooKeepers;
    private Spinner penTypeSpinner;
    private Spinner zookeeperSpinner;
    private String penTypeString;
    private String zookeeperString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pens_form);

        penTypes = PenType.getAllPenTypes();
        zooKeepers = ZooKeeper.getAllZookeepers();

        penTypeSpinner = findViewById(R.id.pen_type_spinner);
        zookeeperSpinner = findViewById(R.id.zookeeper_spinner);

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
                penTypeString =  itemValue.toString();
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + penTypeString, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        zookeeperSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                ZooKeeper itemValue = (ZooKeeper) zookeeperSpinner.getItemAtPosition(position);
                zookeeperString =  itemValue.toString();
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " item selected: " + zookeeperString, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
