package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {
    private final List<String> titles;
    private final List<Integer> images;
    private VerticalAdapter.OnItemClickListener onItemClickListener; // 用于保存监听器的实例

    public VerticalAdapter(List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
    }

    // 定义接口
    public interface OnItemClickListener {
        void onItemClick(int position); // 接口方法，传递位置参数
    }

    // 设置监听器
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new ViewHolder(view, onItemClickListener); // 将监听器传递给 ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));
        holder.titleTextView.setText(titles.get(position));

        // 如果设置了监听器，则触发点击事件
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView titleTextView;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.vertical_image);
            titleTextView = itemView.findViewById(R.id.vertical_title);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}