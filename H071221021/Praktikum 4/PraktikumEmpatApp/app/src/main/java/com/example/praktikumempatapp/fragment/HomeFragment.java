package com.example.praktikumempatapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.praktikumempatapp.Celebrity;
import com.example.praktikumempatapp.DataSource;
import com.example.praktikumempatapp.PostAdapter;
import com.example.praktikumempatapp.R;

public class HomeFragment extends Fragment {

    public static final String EXTRA_CELEBRITY = "extra_celebrity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPostingan = view.findViewById(R.id.rv_post);
        rvPostingan.setHasFixedSize(true);
        PostAdapter postinganAdapter = new PostAdapter(DataSource.celebrities);
        rvPostingan.setAdapter(postinganAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Celebrity celebrity = bundle.getParcelable(EXTRA_CELEBRITY);
            if (celebrity != null) {
                DataSource.celebrities.add(0, celebrity);
            }
        }


    }
}