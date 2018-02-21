package com.colombomobilemeetup.demo2.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.colombomobilemeetup.demo2.R;
import com.colombomobilemeetup.demo2.database.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<User> users;
    private OnItemClickListener onItemClickListener;
    private final Context context;
    private final LayoutInflater layoutInflater;

    public UserAdapter(Context context, ArrayList<User> users, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.users = users;
        this.onItemClickListener = onItemClickListener;
        this.layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
        holder.itemView.setOnClickListener(v -> onItemClickListener.onClick(user));
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }
}
