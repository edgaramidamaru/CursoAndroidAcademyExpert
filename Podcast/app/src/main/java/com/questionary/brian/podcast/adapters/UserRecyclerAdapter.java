package com.questionary.brian.podcast.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.questionary.brian.podcast.R;
import com.questionary.brian.podcast.models.User;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserViewHolder> {

    List<User> userList;
    Activity activity;

    public UserRecyclerAdapter(List<User> userList, Activity activity) {
        this.userList = userList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final User user = userList.get(position);
        holder. bind(user);
        holder.itemUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.delete();
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
