package com.example.mynewjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class simpleInterestActivity extends AppCompatActivity {

    EditText etPrincipal, etRate, etTime;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_interest);

        etPrincipal = findViewById(R.id.etPrincipal);
        etRate = findViewById(R.id.etRate);
        etTime = findViewById(R.id.etTime);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String principalStr = etPrincipal.getText().toString();
                String rateStr = etRate.getText().toString();
                String timeStr = etTime.getText().toString();

                if (principalStr.isEmpty() || rateStr.isEmpty() || timeStr.isEmpty()) {
                    tvResult.setText("Please fill all the fields.");
                    return;
                }

                double principal = Double.parseDouble(principalStr);
                double rate = Double.parseDouble(rateStr);
                double time = Double.parseDouble(timeStr);

                double interest = (principal * rate * time) / 100;

                tvResult.setText("Simple Interest: Rs. " + String.format("%.2f", interest));
            }
        });
    }
}
