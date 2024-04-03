package com.example.praktikumtigaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private ImageView iv_profile;
    private ImageView iv_feed;
    private TextView tv_nama, tv_followers, tv_following, tv_postingan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();

        Celebrity celebrity = intent.getParcelableExtra("celebrity");

        iv_profile = findViewById(R.id.iv_profile3);
        iv_feed = findViewById(R.id.iv_feed2);
        tv_nama = findViewById(R.id.tv_nama3);
        tv_followers = findViewById(R.id.tv_followers);
        tv_following = findViewById(R.id.tv_following);
        tv_postingan = findViewById(R.id.tv_post);

        iv_profile.setImageResource(celebrity.getImageprofil());
        iv_feed.setImageResource(celebrity.getImagefeed());
        tv_nama.setText(celebrity.getNama());
        tv_followers.setText(String.valueOf(celebrity.getFollowers()));
        tv_following.setText(String.valueOf(celebrity.getFollowing()));
        tv_postingan.setText(String.valueOf(celebrity.getPostingan()));

        iv_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("celebrity", celebrity);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("celebrity", celebrity);
                startActivity(intent);
            }
        });

    }
}