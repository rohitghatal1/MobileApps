package com.example.mynewjavaapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class userFormActivity extends AppCompatActivity {
    Button submitBtn;
    EditText idField, nameField;
    TextView resultField;
    RadioButton maleRadio, femaleRadio;
    CheckBox bcaCheckbox, bbmCheckbox, csitCheckbox;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userform);

        idField = findViewById(R.id.idField);
        nameField = findViewById(R.id.nameField);
        maleRadio = findViewById(R.id.maleRadio);

        femaleRadio = findViewById(R.id.femaleRadio);
        bcaCheckbox = findViewById(R.id.bcaCheckbox);
        bbmCheckbox = findViewById(R.id.bbmCheckbox);
        csitCheckbox = findViewById(R.id.csitCheckbox);

        resultField = findViewById(R.id.results);

        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idField.getText().toString());
                String name = nameField.getText().toString();

                String gender = maleRadio.isChecked() ? "Male" : "Female";

                // Use a StringBuilder or List for dynamic program collection
                StringBuilder programsBuilder = new StringBuilder();

                if (bcaCheckbox.isChecked()) {
                    programsBuilder.append("BCA, ");
                }
                if (csitCheckbox.isChecked()) {
                    programsBuilder.append("CSIT, ");
                }
                if (bbmCheckbox.isChecked()) {
                    programsBuilder.append("BBM, ");
                }

                // Remove the last comma and space if any programs were added
                String programs = programsBuilder.length() > 0
                        ? programsBuilder.substring(0, programsBuilder.length() - 2)
                        : "None";

                String resultText = "Filled values:\n" +
                        "ID: " + id + "\n" +
                        "Name: " + name + "\n" +
                        "Gender: " + gender + "\n" +
                        "Programs: " + programs;

                resultField.setText(resultText);
            }
        });

    }
}
