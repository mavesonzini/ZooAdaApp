package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class ZooKeeperDetails extends AppCompatActivity implements Serializable {

    private TextView nameLabel;
    private TextView detailsLabel;
    private String zookeeperName;
    private String[] zookeeperPenTypesArray = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_keeper_details);

        nameLabel = findViewById(R.id.zookeeper_name_label);
        detailsLabel = findViewById(R.id.zookeeper_details_label);

        nameLabel.setText(getNameFromSelectedRow());

        getPenTypesForZookeeper();
    }

    public String getNameFromSelectedRow() {
        zookeeperName = ZooKeepersList.getItemFromSelectedPosition().toString();
        return zookeeperName;
    }

    public void getPenTypesForZookeeper() {
        zookeeperPenTypesArray = ZooKeepersList.getItemFromSelectedPosition().getPenTypes();
        String penTypes = "";
        for (int i = 0; i < zookeeperPenTypesArray.length; i++) {
            penTypes = penTypes + zookeeperPenTypesArray[i].toString() + "\n";
        }
        detailsLabel.setText(penTypes);
    }
}