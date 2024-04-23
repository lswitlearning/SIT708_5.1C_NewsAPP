package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {
    // Lists to store the titles and image resource IDs for each item in the RecyclerView
    private final List<String> titles;
    private final List<Integer> images;

    // Interface for item click event handling
    private OnItemClickListener onItemClickListener;

    // Constructor to initialize the adapter with titles and images
    public VerticalAdapter(List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
    }

    // Define the interface for click events
    public interface OnItemClickListener {
        // Method to be called when an item is clicked
        void onItemClick(int position); // Passes the position of the clicked item
    }

    // Set the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener; // Store the listener instance
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a vertical item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new ViewHolder(view, onItemClickListener); // Pass the listener to the ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the image and title for the current item
        holder.imageView.setImageResource(images.get(position));
        holder.titleTextView.setText(titles.get(position));

        // If a click listener is set, trigger the click event
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position); // Notify about the item click
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size(); // Return the total number of items in the list
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView; // ImageView for displaying the item image
        final TextView titleTextView; // TextView for displaying the item title

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            // Initialize the image and title views
            imageView = itemView.findViewById(R.id.vertical_image);
            titleTextView = itemView.findViewById(R.id.vertical_title);

            // Set a click listener for the item view
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    // Notify the listener when the item is clicked, passing the adapter position
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
