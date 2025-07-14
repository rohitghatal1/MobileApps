package com.example.mynewjavaapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class sqliteActivity extends AppCompatActivity {

    EditText edtId, edtName, edtAddress;
    Button btnInsert, btnSelect, btnUpdate, btnDelete;
    TextView txtData;

    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_ex);

        // Initialize DB Helper
        myDbHelper = new MyDbHelper(this);

        // Bind UI elements
        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        txtData = findViewById(R.id.txtData);

        // Insert
        btnInsert.setOnClickListener(view -> {
            int id = Integer.parseInt(edtId.getText().toString());
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            myDbHelper.insertData(id, name, address);
            Toast.makeText(getApplicationContext(), "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
        });


        // Select
        btnSelect.setOnClickListener(view -> {
            Cursor cursor = myDbHelper.selectData();
            StringBuilder builder = new StringBuilder();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                builder.append("Id=").append(id)
                        .append(" Name=").append(name)
                        .append(" Address=").append(address)
                        .append("\n");
            }
            txtData.setText(builder.toString());
        });

        // Update
        btnUpdate.setOnClickListener(view -> {
            String id = edtId.getText().toString();
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            myDbHelper.updateData(id, name, address);
            Toast.makeText(getApplicationContext(), "Data Updated Successfully!", Toast.LENGTH_SHORT).show();
        });

        // Delete
        btnDelete.setOnClickListener(view -> {
            String id = edtId.getText().toString();
            myDbHelper.deleteData(id);
            Toast.makeText(getApplicationContext(), "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
        });
    }
}
