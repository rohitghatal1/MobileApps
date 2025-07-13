package com.example.mynewjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class signUpFormActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioGroup rgGender;
    Spinner spinnerCountry;
    CheckBox cbAgree;
    Button btnSubmit;
    TextView tvResult;

    String[] countries = {"Nepal", "India", "USA", "UK", "Canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cbAgree.isChecked()) {
                    tvResult.setText("Please agree to the terms.");
                    return;
                }

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String gender = "";
                int selectedId = rgGender.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadio = findViewById(selectedId);
                    gender = selectedRadio.getText().toString();
                }
                String country = spinnerCountry.getSelectedItem().toString();

                String result = "Name: " + name + "\n"
                        + "Email: " + email + "\n"
                        + "Password: " + password + "\n"
                        + "Gender: " + gender + "\n"
                        + "Country: " + country;

                tvResult.setText(result);
            }
        });
    }
}
