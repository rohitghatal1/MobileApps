package com.example.mynewjavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class ImageGallery extends AppCompatActivity {

    GridView gridView;
    int[] imageIds = {
            R.drawable.image10, R.drawable.image6,
            R.drawable.image7, R.drawable.image8,
            R.drawable.image9
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_gallery);

        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this, imageIds));

        gridView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(ImageGallery.this, ImageDisplay.class);
            intent.putExtra("imageId", imageIds[position]);
            startActivity(intent);
        });
    }
}
