package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    // Lists to store the titles and image resource IDs for each recommended item
    private final List<String> titles;
    private final List<Integer> images;

    // Interface for item click event handling
    private OnItemClickListener onItemClickListener;

    // Constructor to initialize the adapter with titles and images
    public RecommendedAdapter(List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout from 'item_horizontal.xml' for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Set the title and image for the current item
        holder.titleTextView.setText(titles.get(position));
        holder.imageView.setImageResource(images.get(position));

        // Set a click listener for the item
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position); // Trigger the click event with the item position
            }
        });
    }

    @Override
    public int getItemCount() {
        // Return the total number of items in the list
        return titles.size();
    }

    // ViewHolder class representing an individual item view in the RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleTextView; // TextView to display the item's title
        final ImageView imageView; // ImageView to display the item's image

        ViewHolder(View itemView) {
            super(itemView);
            // Initialize the title and image views from the item layout
            titleTextView = itemView.findViewById(R.id.horizontal_title);
            imageView = itemView.findViewById(R.id.horizontal_image);
        }
    }

    // Interface for handling item click events
    public interface OnItemClickListener {
        // Method to handle item click, passing the item position
        void onItemClick(int position);
    }

    // Method to set the click event listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener; // Assign the custom click listener
    }
}
