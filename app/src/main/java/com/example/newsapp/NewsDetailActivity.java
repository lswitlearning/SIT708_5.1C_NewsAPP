package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);

// 获取传递的数据
        Intent intent = getIntent(); // 获取Intent
        String newsTitle = intent.getStringExtra("title"); // 获取标题
        int newsImageResId = intent.getIntExtra("imageResId", -1); // 获取图片资源ID
        String content = intent.getStringExtra("content"); // 获取新闻内容

        // 获取布局中的视图
        TextView titleTextView = findViewById(R.id.news_title); // 获取标题的TextView
        ImageView newsImageView = findViewById(R.id.news_image); // 获取图片的ImageView
        TextView newsContentTextView = findViewById(R.id.news_content); // 获取内容的TextView

        // 设置标题
        if (newsTitle != null) {
            titleTextView.setText(newsTitle);
        }

        // 设置图片
        if (newsImageResId != -1) {
            newsImageView.setImageResource(newsImageResId);
        }

        // 设置内容
        if (content != null) {
            newsContentTextView.setText(content);
        }
    }
}
