package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ZooController extends AppCompatActivity {

    Button zookeepersButton;
    Button pensButton;
    Button animalsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_controller);

        zookeepersButton = findViewById(R.id.zookeepers_button);

        zookeepersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZooController.this, ZooKeepersList.class);
                startActivity(intent);
            }
        });

        pensButton = findViewById(R.id.pens_button);

        pensButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZooController.this, PensList.class);
                startActivity(intent);
            }
        });

        animalsButton = findViewById(R.id.animals_button);

        animalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(ZooController.this, AnimalsList.class);
                startActivity(intent);
            }
        });
    }
}
