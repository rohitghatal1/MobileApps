package com.example.mynewjavaapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class listActivity extends AppCompatActivity {

    ListView listView;
    String[] listItems = {"List1", "List2", "List3", "List4", "List5"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        listView = findViewById(R.id.listView);

    }
}
