package com.example.praktikumlimaapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.praktikumlimaapp.Celebrity;
import com.example.praktikumlimaapp.DataSource;
import com.example.praktikumlimaapp.PostAdapter;
import com.example.praktikumlimaapp.R;

public class HomeFragment extends Fragment {

    public static final String EXTRA_CELEBRITY = "extra_celebrity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPostingan = view.findViewById(R.id.rv_post);
        rvPostingan.setHasFixedSize(true);
        PostAdapter postinganAdapter = new PostAdapter(DataSource.celebrities);
        rvPostingan.setAdapter(postinganAdapter);

        ImageView iv_search = view.findViewById(R.id.iv_search);
        ImageView iv_posting = view.findViewById(R.id.iv_post);
        ImageView iv_profile = view.findViewById(R.id.IV_Profile);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Celebrity celebrity = bundle.getParcelable(EXTRA_CELEBRITY);
            if (celebrity != null) {
                DataSource.celebrities.add(0, celebrity);
                postinganAdapter.notifyDataSetChanged();
            }
        }

    }
}