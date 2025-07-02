package com.example.mynewjavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondaryScreen extends AppCompatActivity {
    TextView textView;
    Button backToPriamry;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen);
        textView = findViewById(R.id.secondaryScreenText);
        String username = getIntent().getStringExtra("Username");
        textView.setText(username);
    }
    public void goToPrimaryScreen(){
        Intent i = new Intent(this, PrimaryScreenActivity.class);
        startActivity(i);
    }
}
