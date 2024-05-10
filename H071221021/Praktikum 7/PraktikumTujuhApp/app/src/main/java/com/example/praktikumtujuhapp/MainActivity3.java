package com.example.praktikumtujuhapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView User;
    private Button Logout, Settings;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        User = findViewById(R.id.Username);
        Logout = findViewById(R.id.buttonLogout);
        Settings = findViewById(R.id.buttonSettings);

        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        String data = sharedPreferences.getString("user", "Data Tidak Ditemukan");
        User.setText(data);

        Logout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false);
            editor.apply();

            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        Settings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            startActivity(intent);
        });

    }
}