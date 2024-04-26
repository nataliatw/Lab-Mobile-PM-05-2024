package com.example.praktikumlimaapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.praktikumlimaapp.fragment.HomeFragment;
import com.example.praktikumlimaapp.fragment.PostinganFragment;
import com.example.praktikumlimaapp.fragment.ProfileFragment;
import com.example.praktikumlimaapp.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        FrameLayout frameLayout = findViewById(R.id.frame_container);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.iv_home) {
                    replaceFragment(new HomeFragment());
                } else if (itemId == R.id.iv_search) {
                    replaceFragment(new SearchFragment());
                } else if (itemId == R.id.iv_post) {
                    replaceFragment(new PostinganFragment());
                } else if (itemId == R.id.iv_profile) {
                    replaceFragment(new ProfileFragment());
                } else {
                    return false;
                }
                return true;
            }
        });

        // Set default fragment
        replaceFragment(new HomeFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }
}