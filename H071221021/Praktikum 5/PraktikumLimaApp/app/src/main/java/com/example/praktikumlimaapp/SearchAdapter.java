package com.example.praktikumlimaapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private ArrayList<Celebrity> celebrities;

    public SearchAdapter(ArrayList<Celebrity> celebrities) {

        this.celebrities = celebrities;
    }


    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Celebrity celebrity2 = celebrities.get(position);

        holder.iv_search.setImageResource(celebrity2.getFotoProfile());
        holder.tv_username.setText(celebrity2.getUsername());
        holder.tv_name.setText(celebrity2.getName());

        holder.iv_search.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("celebrity", celebrity2);
            holder.context.startActivity(intent);
        });

        holder.tv_username.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("celebrity", celebrity2);
            holder.context.startActivity(intent);
        });
        holder.tv_name.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("celebrity", celebrity2);
            holder.context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return celebrities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView iv_search;
            TextView tv_username, tv_name;
            Context context;
        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                iv_search = itemView.findViewById(R.id.iv_search);
                tv_username = itemView.findViewById(R.id.tv_username);
                tv_name = itemView.findViewById(R.id.tv_name);
                context = itemView.getContext();
            }
        }
    }

