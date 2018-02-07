package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.concurrent.Executor;

public class ZooController extends AppCompatActivity implements Serializable {

    Button zookeepersButton;
    Button pensButton;
    Button animalsButton;
    Button weatherButton;

    int animalCount;
    int penCount;

    TextView animalCountTextView;

    private final FileManager fileManager = new FileManager(this);

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_controller);

        animalCountTextView = findViewById(R.id.animal_count_textView);
        zookeepersButton = findViewById(R.id.zookeepers_button);
        animalsButton = findViewById(R.id.animals_button);
        weatherButton = findViewById(R.id.to_weather_button);
        pensButton = findViewById(R.id.pens_button);


        zookeepersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZooController.this, ZooKeepersList.class);
                startActivity(intent);
            }
        });

        pensButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZooController.this, PensList.class);
                startActivity(intent);
            }
        });


        animalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(ZooController.this, AnimalsList.class);
                startActivity(intent);
            }
        });

        Zoo zooInstance = Zoo.getInstance();

        animalCount = zooInstance.getNumberOfAnimals();
        penCount = zooInstance.getNumberOfPens();

        if (animalCount == 0 && penCount == 0) {
            animalCountTextView.setText("No animals or pens at all. Create some!");
        } else {
            animalCountTextView.setText(animalCount + " animals living here! and " + penCount + "pens created" );
        }

        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent internt = new Intent(ZooController.this, WeatherController.class);
                startActivity(internt);
            }
        });

    }

  @Override
  protected void onResume() {
    super.onResume();

    Executor executor = new Executor() {
      @Override
      public void execute(@NonNull Runnable runnable) {
      }
    };

    executor.execute(new Runnable() {
      @Override
      public void run() {
        fileManager.writeZooToFile();
      }
    });
  }
}
