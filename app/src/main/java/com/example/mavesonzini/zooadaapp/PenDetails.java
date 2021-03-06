package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PenDetails extends AppCompatActivity implements Serializable {

    private TextView penTypeLabel;
    private TextView dryAreaLabel;
    private TextView wetAreaLabel;
    private TextView volumeLabel;
    private TextView assignedToZookeeperLabel;
    private TextView penCapacityLabel;
    private TextView animalListInPenLabel;

    private Button backToListButton;

    private String penType;
    private String dryArea;
    private String wetArea;
    private String volume;
    private String zookeeperAssigned;
    private String capacity;
    private String animalString = "";

    private List<UUID> animalIdListFromPen = PensList.getItemFromSelectedPosition().getAnimalIdList();
    private List<String> animalStringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pen_details);

        penTypeLabel = findViewById(R.id.pentype_display_label);
        dryAreaLabel = findViewById(R.id.dry_area_display_label);
        wetAreaLabel = findViewById(R.id.wet_area_display_label);
        volumeLabel = findViewById(R.id.volume_display_label);
        backToListButton = findViewById(R.id.back_to_list_button);
        assignedToZookeeperLabel = findViewById(R.id.zookeeper_assigned_display_label);
        penCapacityLabel = findViewById(R.id.pen_capacity_label);
        animalListInPenLabel = findViewById(R.id.animals_in_pen_label);

        penTypeLabel.setText(getPenTypeFromSelectedRow());
        dryAreaLabel.setText(getDryAreaFromSelectedRow());
        wetAreaLabel.setText(getWetAreaFromSelectedRow());
        volumeLabel.setText(getVolumeFromSelectedRow());
        assignedToZookeeperLabel.setText(getZookeeperAssignedFromSelectedRow());
        penCapacityLabel.setText(getCapacityFromSelectedPen());
        animalListInPenLabel.setText(getAnimalListFromPen());

        backToListButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                PenDetails.this.finish();
            }
        });

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
        zookeeperAssigned = PensList.getItemFromSelectedPosition().getZookeeperString();
        return zookeeperAssigned;
    }

    public String getCapacityFromSelectedPen() {
        UUID penId = PensList.getItemFromSelectedPosition().getPenId();
        Zoo zoo = Zoo.getInstance();
        Pen selectedPen = zoo.getPenById(penId);
        capacity = selectedPen.getCapacity();
        return capacity;
    }

    public String getAnimalListFromPen() {
        animalIdToAnimalStringList();
        for (int i = 0; i < animalStringList.size(); i++) {

            animalString = animalStringList.get(i).toString() + "\n" + animalString;
        }

        return animalString;
    }

    public List<String> animalIdToAnimalStringList() {
        Zoo zoo = Zoo.getInstance();
        for (int i = 0; i < animalIdListFromPen.size(); i ++) {
            animalStringList.add(zoo.getAnimalById(animalIdListFromPen.get(i)).toString());
        }
        return animalStringList;
    }
}
