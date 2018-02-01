package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class AnimalsList extends AppCompatActivity {
    private ListView listView;
    private List<Animal> animalList;
    private static Animal item = null;
    private static FloatingActionButton homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        homeButton = findViewById(R.id.home_button);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(AnimalsList.this, AnimalForm.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.animal_list);
        animalList = Zoo.getInstance().getAnimals();

        ArrayAdapter<Animal> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, animalList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int itemPosition = position;
                Animal itemValue = (Animal) listView.getItemAtPosition(position);
                item = itemValue;

                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " list item: " + itemValue, Toast.LENGTH_LONG)
                        .show();
                Intent intent = new Intent(AnimalsList.this, AnimalDetails.class);
                startActivity(intent);

            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimalsList.this.finish();
                Intent intent = new Intent(AnimalsList.this, ZooController.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public static Animal getItemFromSelectedPosition(){
        return item;
    }

}
