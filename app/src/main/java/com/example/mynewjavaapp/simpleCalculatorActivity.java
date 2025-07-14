package com.example.mynewjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class simpleCalculatorActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calculator);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        tvResult = findViewById(R.id.tvResult);

        View.OnClickListener calculateListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = etNumber1.getText().toString();
                String num2Str = etNumber2.getText().toString();

                if (num1Str.isEmpty() || num2Str.isEmpty()) {
                    tvResult.setText("Please enter both numbers.");
                    return;
                }

                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;
                String operation = "";

                if (view.getId() == R.id.btnAdd) {
                    result = num1 + num2;
                    operation = "Addition";
                } else if (view.getId() == R.id.btnSubtract) {
                    result = num1 - num2;
                    operation = "Subtraction";
                } else if (view.getId() == R.id.btnMultiply) {
                    result = num1 * num2;
                    operation = "Multiplication";
                } else if (view.getId() == R.id.btnDivide) {
                    if (num2 == 0) {
                        tvResult.setText("Cannot divide by zero.");
                        return;
                    }
                    result = num1 / num2;
                    operation = "Division";
                }

                tvResult.setText(operation + " Result: " + String.format("%.2f", result));
            }
        };

        btnAdd.setOnClickListener(calculateListener);
        btnSubtract.setOnClickListener(calculateListener);
        btnMultiply.setOnClickListener(calculateListener);
        btnDivide.setOnClickListener(calculateListener);
    }
}
