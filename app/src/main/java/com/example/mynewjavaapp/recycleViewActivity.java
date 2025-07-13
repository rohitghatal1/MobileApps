package com.example.mynewjavaapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate( Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.recycle_view);
        recyclerView = findViewById(R.id.recycleView);

        ArrayList<myData> data = new ArrayList<>();
        data.add(new myData("Rohit", "Thasikhel", R.mipmap.ic_launcher));
        data.add(new myData("Ram", "Satdobato", R.mipmap.ic_launcher));
        data.add(new myData("Hari", "Ekantakuna", R.mipmap.ic_launcher));
        data.add(new myData("Shaym", "Dhobighat", R.mipmap.ic_launcher));
        data.add(new myData("Sita", "Sanepa", R.mipmap.ic_launcher));
        data.add(new myData("Rita", "Balkhu", R.mipmap.ic_launcher));
        data.add(new myData("Gita", "Kalanki", R.mipmap.ic_launcher));

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new recycleViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
