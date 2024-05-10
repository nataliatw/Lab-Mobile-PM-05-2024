package com.example.praktikumtujuhapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    SwitchCompat switchMode;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        switchMode = findViewById(R.id.switchMode);

        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("nightMode", false);

        switchMode.setChecked(nightMode);

        switchMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor = sharedPreferences.edit();

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }

            editor.putBoolean("nightMode", isChecked);
            editor.apply();
        });
    }
}