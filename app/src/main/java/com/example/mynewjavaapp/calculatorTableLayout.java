package com.example.mynewjavaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class calculatorTableLayout extends AppCompatActivity {
    EditText num1, num2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_table_layout);

        num1 = findViewById(R.id.editTextNumber1);
        num2 = findViewById(R.id.editTextNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        result = findViewById(R.id.textViewResult);

    }
}
