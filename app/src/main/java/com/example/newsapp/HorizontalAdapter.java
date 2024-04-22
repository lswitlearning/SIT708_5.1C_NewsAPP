package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {
    private final List<String> titles;
    private final List<Integer> images; // List of image resources
    private OnItemClickListener onItemClickListener; // 用于保存监听器的实例

    public HorizontalAdapter(List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
    }

    // 定义接口
    public interface OnItemClickListener {
        void onItemClick(int position); // 接口方法，传递位置参数
    }

    // 设置监听器
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener; // 保存监听器的实例
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new ViewHolder(view, onItemClickListener); // 将监听器传递给 ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 绑定图像和标题
        holder.imageView.setImageResource(images.get(position));
        holder.titleTextView.setText(titles.get(position));

        // 设置点击事件
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position); // 调用接口方法
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size(); // 返回总项目数
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView titleTextView;

        public ViewHolder(View itemView, OnItemClickListener listener) { // 接收监听器实例
            super(itemView);
            imageView = itemView.findViewById(R.id.horizontal_image);
            titleTextView = itemView.findViewById(R.id.horizontal_title);

            // 在 ViewHolder 中设置点击事件
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition()); // 调用接口方法
                }
            });
        }
    }
}