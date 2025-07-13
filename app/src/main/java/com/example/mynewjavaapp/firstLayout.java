package com.example.mynewjavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class firstLayout extends AppCompatActivity {

    EditText etName, etAddress, etPhone;
    RadioGroup rgGender;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        rgGender = findViewById(R.id.rgGender);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String address = etAddress.getText().toString();
            String phone = etPhone.getText().toString();
            int selectedGenderId = rgGender.getCheckedRadioButtonId();

            String gender = "";
            if (selectedGenderId != -1) {
                RadioButton selected = findViewById(selectedGenderId);
                gender = selected.getText().toString();
            }

            Intent intent = new Intent(firstLayout.this, secondLayout.class);
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            intent.putExtra("phone", phone);
            intent.putExtra("gender", gender);
            startActivity(intent);
        });
    }
}
