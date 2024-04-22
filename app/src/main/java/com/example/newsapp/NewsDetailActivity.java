package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
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

        // 配置推荐新闻的 RecyclerView
        RecyclerView recommendedRv = findViewById(R.id.recommended_news);
        recommendedRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<String> horizontalTitles = Arrays.asList(
                "Good Morning",
                "Good Afternoon",
                "Good Evening",
                "How are you"
        );

        List<Integer> horizontalImages = Arrays.asList(
                R.drawable.h_img1,
                R.drawable.h_img2,
                R.drawable.h_img3,
                R.drawable.h_img4
        );

        List<String> horizontalContent = Arrays.asList(
                "This is good morning news. This is good morning news. This is good morning news. This is good morning news.This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news.This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news.This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news.This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news. This is good morning news.This is good morning news. This is good morning news.",
                "This is good afternoon news. This is good afternoon news. This is good afternoon news. This is good afternoon news. This is good afternoon news. This is good afternoon news. This is good afternoon news. ",
                "This is good evening news. This is good evening news. This is good evening news. This is good evening news. This is good evening news. This is good evening news. This is good evening news. ",
                "This is how are you news. This is how are you news. This is how are you news. This is how are you news. This is how are you news. This is how are you news. This is how are you news. "

        );

        List<String> verticalTitles = Arrays.asList(
                "News 1",
                "News 2",
                "News 3",
                "News 4",
                "News 5",
                "News 6",
                "News 7",
                "News 8"
        );

        List<Integer> verticalImages = Arrays.asList(
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7,
                R.drawable.img8
        );

        List<String> verticalContent = Arrays.asList(
                "This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. This is News 1. ",
                "This is News 2. This is News 2. This is News 2. This is News 2. This is News 2. This is News 2. This is News 2. This is News 2. This is News 2. This is News 2. This is News 2. This is News 2.",
                "This is News 3. This is News 3. This is News 3. This is News 3. This is News 3. This is News 3. This is News 3. This is News 3. This is News 3. This is News 3. This is News 3. This is News 3.",
                "This is News 4. This is News 4. This is News 4. This is News 4. This is News 4. This is News 4. This is News 4. This is News 4. This is News 4. This is News 4. This is News 4. This is News 4.",
                "This is News 5. This is News 5. This is News 5. This is News 5. This is News 5. This is News 5. This is News 5. This is News 5. This is News 5. This is News 5. This is News 5. This is News 5.",
                "This is News 6. This is News 6. This is News 6. This is News 6. This is News 6. This is News 6. This is News 6. This is News 6. This is News 6. This is News 6. This is News 6. This is News 6.",
                "This is News 7. This is News 7. This is News 7. This is News 7. This is News 7. This is News 7. This is News 7. This is News 7. This is News 7. This is News 7. This is News 7. This is News 7.",
                "This is News 8. This is News 8. This is News 8. This is News 8. This is News 8. This is News 8. This is News 8. This is News 8. This is News 8. This is News 8. This is News 8. This is News 8."
        );


        // 新的推荐新闻列表，排除当前新闻
        List<String> recommendedTitles = new ArrayList<>();
        List<Integer> recommendedImages = new ArrayList<>();
        List<String> recommendedContent = new ArrayList<>();

        // 合并水平和垂直的所有数据
        List<String> allTitles = new ArrayList<>();
        List<Integer> allImages = new ArrayList<>();
        List<String> allContent = new ArrayList<>();

        allTitles.addAll(horizontalTitles);
        allImages.addAll(horizontalImages);
        allContent.addAll(horizontalContent);

        allTitles.addAll(verticalTitles);
        allImages.addAll(verticalImages);
        allContent.addAll(verticalContent);




        // 过滤掉当前新闻
        for (int i = 0; i < allTitles.size(); i++) {
            if (!allTitles.get(i).equals(newsTitle) && allImages.get(i) != newsImageResId) {
                recommendedTitles.add(allTitles.get(i));
                recommendedImages.add(allImages.get(i));
                recommendedContent.add(allContent.get(i));
            }
        }

        // 创建和设置 RecommendedAdapter
        RecommendedAdapter recommendedAdapter = new RecommendedAdapter(recommendedTitles, recommendedImages);

        // 设置点击事件处理逻辑
        recommendedAdapter.setOnItemClickListener(position -> {
            // 获取推荐新闻的标题和图片
            String recommendedTitle = recommendedTitles.get(position);
            int recommendedImageResId = recommendedImages.get(position);
            String relatedContent = recommendedContent.get(position);

            // 启动新的新闻详情活动
            Intent newIntent = new Intent(this, NewsDetailActivity.class);
            newIntent.putExtra("title", recommendedTitle);
            newIntent.putExtra("imageResId", recommendedImageResId);
            newIntent.putExtra("content", relatedContent);

            startActivity(newIntent);
        });

        recommendedRv.setAdapter(recommendedAdapter);
    }
}