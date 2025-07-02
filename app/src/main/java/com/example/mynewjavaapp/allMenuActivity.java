package com.example.mynewjavaapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class allMenuActivity extends AppCompatActivity {
    TextView contextMenu, clickedMenuShow;
    Button popupBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.all_menus);

        contextMenu = findViewById(R.id.contextMenuPopup);
        popupBtn = findViewById(R.id.popupBtn);
        clickedMenuShow = findViewById(R.id.displayClickedMenu);

        registerForContextMenu(contextMenu);

        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(allMenuActivity.this, popupBtn);
                popup.getMenuInflater().inflate(R.menu.menu_items, popup.getMenu());
                popup.setOnMenuItemClickListener(item -> {
                    clickedMenuShow.setText(item.getTitle().toString());
                    return true;
                });
                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        clickedMenuShow.setText(item.getTitle().toString());
        switch (item.getTitle().toString()){
            case ("Item 1") :
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        clickedMenuShow.setText(item.getTitle().toString());
        return true;
    }
}
