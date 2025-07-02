package com.example.mynewjavaapp;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ImageDisplay extends AppCompatActivity {

    ImageView imageFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_display);

        imageFull = findViewById(R.id.imageFull);

        int imageId = getIntent().getIntExtra("imageId", -1);
        if (imageId != -1) {
            imageFull.setImageResource(imageId);
        }
    }
}
