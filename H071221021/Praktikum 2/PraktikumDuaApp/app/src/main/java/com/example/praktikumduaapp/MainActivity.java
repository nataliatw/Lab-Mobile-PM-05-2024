package com.example.praktikumduaapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText nama;
    private EditText username;
    private ImageView iv;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        nama = findViewById(R.id.nama);
        username = findViewById(R.id.username);
        iv = findViewById(R.id.iv);

        submit.setOnClickListener(view -> {
            if (isValidInput()) {
                String namavalue = nama.getText().toString();
                String usernamevalue = username.getText().toString();
                Intent move = new Intent(this, MainActivity2.class);
                move.putExtra("nama",namavalue);
                move.putExtra("username",usernamevalue);
                move.putExtra("image", uri);

                startActivity(move);
            }
        });

        iv.setOnClickListener(view ->{
            Intent opengallery = new Intent(Intent.ACTION_PICK);
            opengallery.setType("image/*");
            launcherIntentGallery.launch(opengallery);
        });
    }

    private boolean isValidInput() {
        if( nama.getText().toString().isEmpty()) {
            nama.setError("name is required!");
            return false;
        }
        if( username.getText().toString().isEmpty() ) {
            username.setError("username is required!");
            return false;
        }
        if (iv == null) {
            Toast.makeText(this, "Please enter your content", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    if (data != null) {
                        uri = data.getData();
                        iv.setImageURI(uri);
                    }
                }
            }
    );
}