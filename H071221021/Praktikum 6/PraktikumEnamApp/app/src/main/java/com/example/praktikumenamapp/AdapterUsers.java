package com.example.praktikumenamapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.ViewHolder> {
    ArrayList<UserResponse> users;

    public AdapterUsers(ArrayList<UserResponse> users) {

        this.users = users;
    }

    @NonNull
    @Override
    public AdapterUsers.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsers.ViewHolder holder, int position) {
        UserResponse userResponse = users.get(position);
        holder.tv_name.setText(userResponse.getFirstName());
        holder.tv_email.setText(userResponse.getEmail());
        Picasso.get().load(userResponse.getAvatarUrl()).into(holder.iv_foto);

        holder.itemView.setOnClickListener(v -> {
            int data = users.get(holder.getAdapterPosition()).getId();
            String id = Integer.toString(data);
            Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
            intent.putExtra("id", id);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void addData(List<UserResponse> newData) {
        int startPosition = users.size();
        users.addAll(newData);
        notifyItemRangeInserted(startPosition, newData.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_foto;
        TextView tv_name, tv_email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto = itemView.findViewById(R.id.iv_foto);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_email = itemView.findViewById(R.id.tv_email);
        }
    }
}
