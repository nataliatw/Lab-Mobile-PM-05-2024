package com.example.praktikumduaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText title;
    private EditText content;
    private Button save;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        save = findViewById(R.id.save);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String username = intent.getStringExtra("username");
        uri = intent.getParcelableExtra("image");


        save.setOnClickListener(view -> {
            if (IsValidInput()) {
                String titleText = title.getText().toString();
                String contentText = content.getText().toString();

                Intent moveToNextActivity = new Intent(this, MainActivity3.class);

                moveToNextActivity.putExtra("nama", nama);
                moveToNextActivity.putExtra("username", username);
                moveToNextActivity.putExtra("image", uri);

                moveToNextActivity.putExtra("title", titleText);
                moveToNextActivity.putExtra("content", contentText);

                startActivity(moveToNextActivity);
            }
        });
    }

    private boolean IsValidInput() {
        if( title.getText().toString().isEmpty()) {
            title.setError("title is required!");
            return false;
        }
        if( content.getText().toString().isEmpty() ) {
            content.setError("content is required!");
            return false;
        }
        return true;
    }
}