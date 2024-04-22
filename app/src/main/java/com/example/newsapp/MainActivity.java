package com.example.newsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent; // Import the Intent class


import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView horizontalRv;
    private RecyclerView verticalRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Horizontal RecyclerView的數據源
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

        // 設置水平RecyclerView
        horizontalRv = findViewById(R.id.horizontalRv);
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(horizontalTitles, horizontalImages);
        horizontalRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRv.setAdapter(horizontalAdapter);


        // 设置监听器，在点击时启动新闻详情页面
        horizontalAdapter.setOnItemClickListener(position -> {
            String title = horizontalTitles.get(position);
            int imageResId = horizontalImages.get(position);
            String content = horizontalContent.get(position);

            // 启动新闻详情活动
            Intent intent = new Intent(this, NewsDetailActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("imageResId", imageResId);
            intent.putExtra("content", content);
            startActivity(intent);
        });

        horizontalRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRv.setAdapter(horizontalAdapter);

        // 垂直RecyclerView的數據源
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

        // 垂直RecyclerView的數據源
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

        // 設置垂直RecyclerView
        verticalRv = findViewById(R.id.verticalRv);
        VerticalAdapter verticalAdapter = new VerticalAdapter(verticalTitles, verticalImages);
        verticalRv.setLayoutManager(new GridLayoutManager(this, 2));
        verticalRv.setAdapter(verticalAdapter);

        // 设置监听器
        verticalAdapter.setOnItemClickListener(position -> {
            String title = verticalTitles.get(position);
            int imageResId = verticalImages.get(position);
            String content = verticalContent.get(position); // 获取相应的内容

            // 创建Intent，并传递数据
            Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("imageResId", imageResId);
            intent.putExtra("content", content);
            startActivity(intent);
        });

        verticalRv.setLayoutManager(new GridLayoutManager(this, 2));
        verticalRv.setAdapter(verticalAdapter);
    }
}
