package com.example.praktikumempatapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

        holder.ivDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
            builder.setTitle("Konfirmasi");
            builder.setMessage("Apakah Anda yakin ingin menghapus postingan ini?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        celebrities.remove(adapterPosition);
                        notifyItemRemoved(adapterPosition);
                    }
                }
            });
            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        });

    }

    @Override
    public int getItemCount() {
        return celebrities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFeed, ivProfile, ivDelete, IVFeed;
        TextView tv_caption, tv_username, tv_name;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFeed = itemView.findViewById(R.id.IV_Postingan);
            IVFeed = itemView.findViewById(R.id.IV_Postingan);
            ivProfile = itemView.findViewById(R.id.IV_Profile);
            ivDelete = itemView.findViewById(R.id.IV_Delete);
            tv_caption = itemView.findViewById(R.id.TV_Desc);
            tv_username = itemView.findViewById(R.id.TV_username);
            tv_name = itemView.findViewById(R.id.TV_name);
            context = itemView.getContext();
        }
    }
}
