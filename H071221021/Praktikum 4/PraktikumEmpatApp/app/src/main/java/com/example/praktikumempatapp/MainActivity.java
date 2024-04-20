package com.example.praktikumempatapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.praktikumempatapp.fragment.HomeFragment;
import com.example.praktikumempatapp.fragment.PostinganFragment;
import com.example.praktikumempatapp.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ImageView iv_posting = findViewById(R.id.iv_post);
        ImageView iv_profile = findViewById(R.id.iv_profile);
        ImageView iv_home = findViewById(R.id.iv_home);

        FragmentManager fragmentManager = getSupportFragmentManager();

        HomeFragment homeFragment = new HomeFragment();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment)
                    .commit();
        }



        iv_posting.setOnClickListener(v -> {
            PostinganFragment postinganFragment = new PostinganFragment();
            Fragment f = fragmentManager.findFragmentByTag(PostinganFragment.class.getSimpleName());
            if (!(f instanceof PostinganFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, postinganFragment)
                        .addToBackStack(null)
                        .commit();
            }

        });

        iv_profile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            Fragment p = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
            if (!(p instanceof PostinganFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, profileFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        iv_home.setOnClickListener(v -> {
            HomeFragment homeFragment1 = new HomeFragment();
            Fragment h = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
            if (!(h instanceof PostinganFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, homeFragment1)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}