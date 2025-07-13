package com.example.mynewjavaapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class rootLayout extends AppCompatActivity {
    Button contactBtn, aboutBtn, showAlert, openCalculator;
    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rootlayout);
        text = findViewById(R.id.someText);
        contactBtn = findViewById(R.id.contactBtn);
        showAlert = findViewById(R.id.showDialogBtn);
        showAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

        openCalculator = findViewById(R.id.openCalculatorBtn);
        openCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculator();
            }
        });
        aboutBtn = findViewById(R.id.aboutBtn);
        String username = getIntent().getStringExtra("Username");
        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new contactActivity();
                setFragment(fragment);
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new aboutActivity();
                setFragment(fragment);
            }
        });
    }

    public void setFragment(Fragment frag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.displayFragment, frag);
        fragmentTransaction.commit();
    }

    public void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete");
        builder.setMessage("Are you sure you want to delete this?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text.setText("");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text.setText("No button clicked");
            }
        });
        builder.create();
        builder.show();
    }

    public void showCalculator() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Calculator");

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.calculator, null);
        Button Add = view.findViewById(R.id.addBtn);
        EditText firstNumField = view.findViewById(R.id.firstNumber);
        EditText secondNumField = view.findViewById(R.id.secondNumber);
        TextView resultText = view.findViewById(R.id.resultField);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = Integer.parseInt(firstNumField.getText().toString()) + Integer.parseInt(secondNumField.getText().toString());
                resultText.setText(sum + " result");
            }
        });
        builder.setView(view);
        builder.create();
        builder.show();
    }
}
