package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ZooKeeperDetails extends AppCompatActivity {

    private TextView nameLabel;
    private TextView detailsLabel;
    private ZooKeeper[] zooKeepers;
    private String zookeeperName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_keeper_details);

        nameLabel = findViewById(R.id.zookeeper_name_label);
        detailsLabel = findViewById(R.id.zookeeper_details_label);

        nameLabel.setText(getNameFromSelectedRow());

    }

    public String getNameFromSelectedRow() {
        zookeeperName = ZooKeepersList.getItemFromSelectedPosition().toString();

        return zookeeperName;
    }

}