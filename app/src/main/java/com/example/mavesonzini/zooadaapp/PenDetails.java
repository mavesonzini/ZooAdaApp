package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.UUID;

public class PenDetails extends AppCompatActivity {

    private TextView penTypeLabel;
    private TextView dryAreaLabel;
    private TextView wetAreaLabel;
    private TextView volumeLabel;
    private TextView assignedToZookeeperLabel;
    private String penType;
    private String dryArea;
    private String wetArea;
    private String volume;
    private String zookeeperAssigned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pen_details);

        penTypeLabel = findViewById(R.id.pentype_display_label);
        dryAreaLabel = findViewById(R.id.dry_area_display_label);
        wetAreaLabel = findViewById(R.id.wet_area_display_label);
        volumeLabel = findViewById(R.id.volume_display_label);
        assignedToZookeeperLabel = findViewById(R.id.zookeeper_assigned_display_label);

        penTypeLabel.setText(getPenTypeFromSelectedRow());
        dryAreaLabel.setText(getDryAreaFromSelectedRow());
        wetAreaLabel.setText(getWetAreaFromSelectedRow());
        volumeLabel.setText(getVolumeFromSelectedRow());
        assignedToZookeeperLabel.setText(getZookeeperAssignedFromSelectedRow());

    }

    public String getPenTypeFromSelectedRow() {
        penType = PensList.getItemFromSelectedPosition().toString();
        return penType;
    }

    public String getDryAreaFromSelectedRow() {
        dryArea = PensList.getItemFromSelectedPosition().getDryArea();
        return dryArea;
    }

    public String getWetAreaFromSelectedRow() {
        wetArea = PensList.getItemFromSelectedPosition().getWetArea();
        return wetArea;
    }

    public String getVolumeFromSelectedRow() {
        volume = PensList.getItemFromSelectedPosition().getVolume();
        return volume;
    }

    public String getZookeeperAssignedFromSelectedRow() {
        zookeeperAssigned = PensList.getItemFromSelectedPosition().getZookeeper();
        return zookeeperAssigned;
    }

    public Pen getPenById(UUID uuid) {
        uuid = Pen.getPenId();
        Pen pen = Zoo.getInstance().getPenById(uuid);
        return pen;
    }
}
