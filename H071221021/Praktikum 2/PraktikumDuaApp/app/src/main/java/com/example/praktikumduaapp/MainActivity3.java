package com.example.praktikumduaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private ImageView iv2;
    private TextView tvnama;
    private TextView tvuser;
    private TextView tvtitle;
    private TextView tvcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        iv2 = findViewById(R.id.iv2);
        tvnama = findViewById(R.id.tvnama);
        tvuser = findViewById(R.id.tvuser);
        tvtitle = findViewById(R.id.tvtitle);
        tvcontent = findViewById(R.id.tvcontent);

        Intent intent = getIntent();

        String nama = intent.getStringExtra("nama");
        String username = intent.getStringExtra("username");
        Uri uri = intent.getParcelableExtra("image");

        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        iv2.setImageURI(uri);
        tvnama.setText(nama);
        tvuser.setText(username);
        tvtitle.setText(title);
        tvcontent.setText(content);

    }
}