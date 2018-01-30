package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class PensList extends AppCompatActivity {

    private ListView listView;
    private List<Pen> pensArray;
    private static Pen item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pens_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PensList.this, PensForm.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.pens_list);

        pensArray = Zoo.getInstance().getPens();

        ArrayAdapter<Pen> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pensArray);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int itemPosition = position;
                Pen itemValue = (Pen) listView.getItemAtPosition(position);
                item = itemValue;

                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " list item: " + itemValue, Toast.LENGTH_LONG)
                        .show();
                Intent intent = new Intent(PensList.this, PenDetails.class);
                startActivity(intent);
            }
        });
    }

    public static Pen getItemFromSelectedPosition(){
        return item;
    }

}
