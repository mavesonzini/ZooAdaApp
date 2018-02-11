package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.concurrent.Executor;

public class ZooController extends AppCompatActivity implements Serializable {

    Button zookeepersButton;
    Button pensButton;
    Button animalsButton;
    FloatingActionButton refreshWeatherButton;

    TextView animalCountTextView;
    TextView temperature;
    TextView weatherDescription;

    int animalCount;
    int penCount;

    private final FileManager fileManager = new FileManager(this);

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_controller);

        animalCountTextView = findViewById(R.id.animal_count_textView);
        zookeepersButton = findViewById(R.id.zookeepers_button);
        animalsButton = findViewById(R.id.animals_button);
        pensButton = findViewById(R.id.pens_button);
        temperature = findViewById(R.id.temperature_label);
        weatherDescription = findViewById(R.id.weather_description_label);
        refreshWeatherButton = findViewById(R.id.refresh_weather_button);


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

        refreshWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWeather();
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

        updateWeather();
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


  void updateWeather() {

      RequestQueue queue = Volley.newRequestQueue(this);

      JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, "http://api.openweathermap.org/data/2.5/weather?APPID=42195305d2e93de308617f0967d19413&q=London", null,
              new Response.Listener<JSONObject>()
              {
                  @Override
                  public void onResponse(JSONObject response) {
                      // display response
                      Weather weather = new Weather(response);

                      temperature.setText(String.valueOf(weather.temperature) + "C");
                      weatherDescription.setText(weather.weatherDescription + " and ");
                      Log.d("Response", response.toString());
                  }
              },
              new Response.ErrorListener()
              {
                  @Override
                  public void onErrorResponse(VolleyError error) {

                  }
              }
      );

      // add it to the RequestQueue
      queue.add(getRequest);
  }
}
