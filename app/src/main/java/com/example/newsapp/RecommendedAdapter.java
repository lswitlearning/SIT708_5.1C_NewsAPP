package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    private final List<String> titles;
    private final List<Integer> images;
    private OnItemClickListener onItemClickListener;

    public RecommendedAdapter(List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 使用 item_horizontal.xml 作为布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTextView.setText(titles.get(position));
        holder.imageView.setImageResource(images.get(position));

        // 绑定点击事件
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position); // 传递被点击的项目位置
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleTextView;
        final ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.horizontal_title);
            imageView = itemView.findViewById(R.id.horizontal_image);
        }
    }

    // 设置自定义接口用于点击事件
    public interface OnItemClickListener {
        void onItemClick(int position); // 只需要传递位置
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener; // 使用自定义接口
    }

}
