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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Celebrity> celebrities;

    public PostAdapter(ArrayList<Celebrity> celebrities) {

        this.celebrities = celebrities;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Celebrity celebrity = celebrities.get(position);

        holder.tv_username.setText(celebrity.getUsername());
        holder.tv_name.setText(celebrity.getName());
        holder.ivProfile.setImageResource(celebrity.getFotoProfile());
        holder.ivFeed.setImageResource(celebrity.getFotoPostingan());
        holder.IVFeed.setImageURI(celebrity.getSelectedImageUri());
        holder.tv_caption.setText(celebrity.getDesc());

        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("celebrity", celebrity);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("celebrity", celebrity);
                holder.context.startActivity(intent);
            }
        });
        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("celebrity", celebrity);
                holder.context.startActivity(intent);
            }
        });
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celebrity.setFavorite(!celebrity.isFavorite());
                if (celebrity.isFavorite()) {
                    holder.like.setImageResource(R.drawable.heart);
                } else {
                    holder.like.setImageResource(R.drawable.heart__1_);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return celebrities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFeed, ivProfile, IVFeed, like;
        TextView tv_caption, tv_username, tv_name;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFeed = itemView.findViewById(R.id.IV_Postingan);
            IVFeed = itemView.findViewById(R.id.IV_Postingan);
            ivProfile = itemView.findViewById(R.id.IV_Profile);
            tv_caption = itemView.findViewById(R.id.TV_Desc);
            tv_username = itemView.findViewById(R.id.TV_username);
            tv_name = itemView.findViewById(R.id.TV_name);
            context = itemView.getContext();
            like = itemView.findViewById(R.id.like1);

        }
    }
}
