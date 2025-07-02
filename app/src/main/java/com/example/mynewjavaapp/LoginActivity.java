package com.example.mynewjavaapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    Button next;
    TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);
//            Spinner spinner = findViewById(R.id.nationalitySpinner);
            String nationalities[] = {"Nepalese", "India"};
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.nationality_spinner_item, nationalities);
//            spinner.setAdapter(arrayAdapter);
            next = findViewById(R.id.nextBtn);
            String nextBtnText = getString(R.string.submitBtn);
            next.setText(nextBtnText);
            text = findViewById(R.id.textView);
            Resources res = getResources();
            String nationalities1[] = res.getStringArray(R.array.nationalitydripdown);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Next Button Cliked", Toast.LENGTH_SHORT).show();
                    goToNext();
                }
            });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2){
            String message = data.getStringExtra("message");
            text.setText(message);
        }
    }

    public void goToNext(){
        Intent i = new Intent(this, PrimaryScreenActivity.class);
        i.putExtra("Username", "Rohit Ghatal");
        startActivityForResult(i, 2);
    }
}
