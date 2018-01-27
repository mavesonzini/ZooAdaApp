package com.example.mavesonzini.zooadaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ZooController extends AppCompatActivity {

    Button zookeepersButton;

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
    }
}
