package com.example.praktikumtujuhapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText Username, Password;
    private Button Register;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Username = findViewById(R.id.editTextUsername);
        Password = findViewById(R.id.editTextPassword);
        Register = findViewById(R.id.buttonRegister);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        Register.setOnClickListener(v -> {
            String user = Username.getText().toString().trim();
            String pass = Password.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show();
            }
            if (pass.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Password harus diisi", Toast.LENGTH_SHORT).show();
            }
            if (user.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Username harus diisi", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user", user);
                editor.putString("pass", pass);
                editor.apply();
                finish();
            }
        });
    }
}