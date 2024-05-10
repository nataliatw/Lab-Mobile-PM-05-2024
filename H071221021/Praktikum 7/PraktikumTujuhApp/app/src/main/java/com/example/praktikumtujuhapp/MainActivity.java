package com.example.praktikumtujuhapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText Username, Password;
    private Button Login, Register;
    private boolean nightMode;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.editTextUsername);
        Password = findViewById(R.id.editTextPassword);
        Login = findViewById(R.id.buttonLogin);
        Register = findViewById(R.id.buttonRegister);

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);

        nightMode = sharedPreferences.getBoolean("nightMode", false);

        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
            finish();
        }


        Login.setOnClickListener(v -> {
            String inputUser = Username.getText().toString().trim();
            String inputPass = Password.getText().toString().trim();

            String registeredUser = sharedPreferences.getString("user", "");
            String registeredPass = sharedPreferences.getString("pass", "");

            if (registeredUser.isEmpty()) {
                Toast.makeText(MainActivity.this, "Akun belum terdaftar, silakan register terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                if (inputUser.equals(registeredUser) && inputPass.equals(registeredPass)) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);

                    Username.setText("");
                    Password.setText("");
                    finish();

                } else {
                    Toast.makeText(MainActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Register.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}