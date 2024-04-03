package com.example.praktikumtigaapp;

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
import java.util.Collections;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<Celebrity> celebrities;
    private ArrayList<Celebrity> shuffelcelebrity;

    public StoryAdapter (ArrayList<Celebrity> celebrities) {

        this.celebrities = celebrities;
        this.shuffelcelebrity = new ArrayList<>(celebrities);
        Collections.shuffle(shuffelcelebrity);
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Celebrity celebrity = shuffelcelebrity.get(position);

        holder.ivStoryProfile.setImageResource(celebrity.getImageprofil());
        holder.tv_name.setText(celebrity.getNama());

        holder.ivStoryProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, MainActivity2.class);
                intent.putExtra("celebrity", celebrity);
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return celebrities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivStoryProfile;
        TextView tv_name;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivStoryProfile = itemView.findViewById(R.id.iv_storyprofile);
            tv_name = itemView.findViewById(R.id.tv_nama);
            context = itemView.getContext();

        }
    }
}


