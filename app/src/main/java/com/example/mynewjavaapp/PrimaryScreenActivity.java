package com.example.mynewjavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrimaryScreenActivity extends AppCompatActivity {
    Button nextScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primaryscreen);
        nextScreen = findViewById(R.id.secondaryScreenBtn);
        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View v) {
//                goToNextScreen();
//            }
            public void onClick(View v) {
                goBack();
            }

        });
    }

    //    public void goToNextScreen(){
//        Intent i = new Intent(this, SecondaryScreen.class);
//        i.putExtra("Username", "Rohit G");
//        startActivity(i);
//    }
    public void goBack() {
        Intent i = new Intent();
        i.putExtra("message", "Hello from second");
        setResult(2, i);
        finish();
    }
}
