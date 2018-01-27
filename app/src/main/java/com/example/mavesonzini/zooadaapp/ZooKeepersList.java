package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ZooKeepersList extends AppCompatActivity {

    private ListView listView;
    private ZooKeeper[] zooKeepers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_keepers_list);

        listView = findViewById(R.id.zookeepers_list);

        //Get array of zookeepers
        zooKeepers = Zoo.getInstance().zooKeepers;

        //Define new adapter
        ArrayAdapter<ZooKeeper> adapter = new ArrayAdapter<ZooKeeper>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, zooKeepers);

        //Assign adapter to listView
        listView.setAdapter(adapter);

        //ListView item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                ZooKeeper itemValue = (ZooKeeper) listView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + " list item: " + itemValue, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
