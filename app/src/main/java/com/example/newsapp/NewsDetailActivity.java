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

        // Get the data passed from the previous activity
        Intent intent = getIntent();
        String newsTitle = intent.getStringExtra("title");
        int newsImageResId = intent.getIntExtra("imageResId", -1);
        String content = intent.getStringExtra("content");

        // Find the views in the layout
        TextView titleTextView = findViewById(R.id.news_title);
        ImageView newsImageView = findViewById(R.id.news_image);
        TextView newsContentTextView = findViewById(R.id.news_content);

        // Set the news title
        if (newsTitle != null) {
            titleTextView.setText(newsTitle);
        }

        // Set the news image
        if (newsImageResId != -1) {
            newsImageView.setImageResource(newsImageResId);
        }

        // Set the news content
        if (content != null) {
            newsContentTextView.setText(content);
        }

        // Configure the RecyclerView for recommended news
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

        // Data for vertical titles, images, and content
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


        // Create recommended news lists excluding the current news item
        List<String> recommendedTitles = new ArrayList<>();
        List<Integer> recommendedImages = new ArrayList<>();
        List<String> recommendedContent = new ArrayList<>();

        // Combine all titles, images, and content into a single list for filtering
        List<String> allTitles = new ArrayList<>();
        List<Integer> allImages = new ArrayList<>();
        List<String> allContent = new ArrayList<>();

        allTitles.addAll(horizontalTitles);
        allImages.addAll(horizontalImages);
        allContent.addAll(horizontalContent);

        allTitles.addAll(verticalTitles);
        allImages.addAll(verticalImages);
        allContent.addAll(verticalContent);




        // Add to recommended lists if not the current news item
        for (int i = 0; i < allTitles.size(); i++) {
            if (!allTitles.get(i).equals(newsTitle) && allImages.get(i) != newsImageResId) {
                recommendedTitles.add(allTitles.get(i));
                recommendedImages.add(allImages.get(i));
                recommendedContent.add(allContent.get(i));
            }
        }

        // Create and set up the RecommendedAdapter
        RecommendedAdapter recommendedAdapter = new RecommendedAdapter(recommendedTitles, recommendedImages);

        // Set a click listener for the recommended items
        recommendedAdapter.setOnItemClickListener(position -> {

            String recommendedTitle = recommendedTitles.get(position);
            int recommendedImageResId = recommendedImages.get(position);
            String relatedContent = recommendedContent.get(position);

            // Launch NewsDetailActivity for the recommended news
            Intent newIntent = new Intent(this, NewsDetailActivity.class);
            newIntent.putExtra("title", recommendedTitle);
            newIntent.putExtra("imageResId", recommendedImageResId);
            newIntent.putExtra("content", relatedContent);

            startActivity(newIntent);
        });

        // Set the adapter for the recommended RecyclerView
        recommendedRv.setAdapter(recommendedAdapter);
    }
}