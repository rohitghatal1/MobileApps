package com.example.mynewjavaapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class contextMenu extends AppCompatActivity {

    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu);

        tvMessage = findViewById(R.id.tvMessage);

        // Register the TextView for context menu
        registerForContextMenu(tvMessage);
    }

    // Inflate context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Action");
        menu.add(0, v.getId(), 0, "Edit");
        menu.add(0, v.getId(), 1, "Delete");
        menu.add(0, v.getId(), 2, "Share");
    }

    // Handle context menu item clicks
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String selectedItem = item.getTitle().toString();

        switch (selectedItem) {
            case "Edit":
                Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
                return true;
            case "Delete":
                Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
                return true;
            case "Share":
                Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
