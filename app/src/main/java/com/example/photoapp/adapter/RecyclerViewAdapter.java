package com.example.photoapp.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoapp.R;
import com.example.photoapp.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    public List<Photo> photoList = new ArrayList<>();

    public RecyclerViewAdapter(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_photo_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvAltDescription.setText(photoList.get(position).getAltDescription());
        Picasso.get().load(photoList.get(position).getUrls().getThumb()).resize(200, 200).into(holder.imageView);
        int color = Color.parseColor(photoList.get(position).getColor());
        holder.tvColorArea.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvAltDescription;
        ImageView imageView;
        TextView tvColorArea;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAltDescription = (TextView) itemView.findViewById(R.id.altDescriptionTextView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tvColorArea = (TextView) itemView.findViewById(R.id.colorAreaTextView);
        }
    }


}
