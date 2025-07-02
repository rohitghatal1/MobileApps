package com.example.mynewjavaapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleViewAdapter extends RecyclerView.Adapter<recycleViewAdapter.ViewHolder> {

    private final Activity context;
    private final ArrayList<myData> data;

    public recycleViewAdapter(Activity context, ArrayList<myData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.recycle_view_items, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        myData current = data.get(position);
        holder.txtName.setText(current.getName());
        holder.txtAddress.setText(current.getAddress());
        holder.imageView.setImageResource(current.getImage());

        holder.imageView.setOnClickListener(v ->
                Toast.makeText(context, current.getName(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.nameTxt);
            txtAddress = itemView.findViewById(R.id.addressTxt);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
