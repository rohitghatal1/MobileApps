package com.example.mynewjavaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class secondLayout extends AppCompatActivity {

    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        tvDisplay = findViewById(R.id.tvDisplay);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String phone = getIntent().getStringExtra("phone");
        String gender = getIntent().getStringExtra("gender");

        String display = "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Phone: " + phone + "\n"
                + "Gender: " + gender;

        tvDisplay.setText(display);
    }
}
