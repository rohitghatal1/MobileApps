package com.example.mynewjavaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    Button Add;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        Add = findViewById(R.id.addBtn);
        EditText firstNumField =  findViewById(R.id.firstNumber);
        EditText secondNumField = findViewById(R.id.secondNumber);
        TextView resultText = findViewById(R.id.resultField);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int sum =  Integer.parseInt(firstNumField.getText().toString()) + Integer.parseInt(secondNumField.getText().toString());
               resultText.setText(sum + " result");
            }
        });
    }
}
