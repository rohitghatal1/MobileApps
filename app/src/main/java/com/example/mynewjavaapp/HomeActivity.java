package com.example.mynewjavaapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button homebtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home);
            homebtn = findViewById(R.id.homebtn);
            String username = getIntent().getStringExtra("Username");
            homebtn.setText(username);
    }
}
