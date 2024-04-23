package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {
    private final List<String> titles; // List of titles for the items
    private final List<Integer> images; // List of image resource IDs for the items
    private OnItemClickListener onItemClickListener; // Listener for click events on the items

    public HorizontalAdapter(List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
    }

    // Interface for item click events
    public interface OnItemClickListener {
        void onItemClick(int position); // Triggered when an item is clicked, with its position passed as a parameter
    }

    // Method to set the item click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener; // Stores the provided listener instance
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for the individual items in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new ViewHolder(view, onItemClickListener); // Pass the listener to the ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the image and title for the current item
        holder.imageView.setImageResource(images.get(position));
        holder.titleTextView.setText(titles.get(position));

        // Set the click listener for the item
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) { // Ensure the listener is not null
                onItemClickListener.onItemClick(position); // Trigger the click event
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size(); // Return the total number of items in the adapter
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView; // Reference to the ImageView for the item
        final TextView titleTextView; // Reference to the TextView for the item's title

        public ViewHolder(View itemView, OnItemClickListener listener) { // Constructor with a click listener
            super(itemView);
            imageView = itemView.findViewById(R.id.horizontal_image);
            titleTextView = itemView.findViewById(R.id.horizontal_title);

            // Set the click listener in the ViewHolder
            itemView.setOnClickListener(v -> {
                if (listener != null) { // Check if the listener is set
                    listener.onItemClick(getAdapterPosition()); // Trigger the click event
                }
            });
        }
    }
}
