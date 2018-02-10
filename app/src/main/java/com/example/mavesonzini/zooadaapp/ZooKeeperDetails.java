package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.ref.PhantomReference;

public class ZooKeeperDetails extends AppCompatActivity implements Serializable {

    private TextView nameLabel;
    private TextView detailsLabel;
    private TextView pensInChargeNumberLabel;

    private Button backToListButton;

    private String zookeeperName;
    private String[] zookeeperPenTypesArray = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_keeper_details);

        nameLabel = findViewById(R.id.zookeeper_name_label);
        detailsLabel = findViewById(R.id.zookeeper_details_label);
        backToListButton = findViewById(R.id.back_to_zookeeper_list);
        pensInChargeNumberLabel = findViewById(R.id.zookeeper_pens_in_charge);

        nameLabel.setText(getNameFromSelectedRow());
        pensInChargeNumberLabel.setText(PensList.getItemFromSelectedPosition().getZookeeper().penCount);
        backToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZooKeeperDetails.this.finish();
            }
        });

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