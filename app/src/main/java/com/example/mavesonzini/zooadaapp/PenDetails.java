package com.example.mavesonzini.zooadaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PenDetails extends AppCompatActivity {

    private TextView penDetailLabel;
    private String penDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pen_details);

        penDetailLabel = findViewById(R.id.pen_details_textView);

        penDetailLabel.setText(getDetailsFromSelectedRow());
    }

    public String getDetailsFromSelectedRow() {
        penDetail = PensList.getItemFromSelectedPosition().toString();
        return penDetail;

    }
}
