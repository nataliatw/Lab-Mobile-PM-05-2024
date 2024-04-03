package com.example.praktikumtigaapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_story;
    private RecyclerView rv_feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_story = findViewById(R.id.rv_story);
        rv_feed = findViewById(R.id.rv_feed);

        rv_story.setHasFixedSize(true);
        rv_feed.setHasFixedSize(true);

        StoryAdapter storyAdapter = new StoryAdapter(DataSource.celebrities);
        rv_story.setAdapter(storyAdapter);

        FeedAdapter feedAdapter = new FeedAdapter(DataSource.celebrities);
        rv_feed.setAdapter(feedAdapter);
    }
}