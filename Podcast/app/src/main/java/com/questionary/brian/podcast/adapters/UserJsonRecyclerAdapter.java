package com.questionary.brian.podcast.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.questionary.brian.podcast.R;
import com.questionary.brian.podcast.Retrofit.Usuarios.JsonPlaceHolderApiService;
import com.questionary.brian.podcast.models.UserJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//UserJsonRecyclerAdapter
public class UserJsonRecyclerAdapter extends RecyclerView.Adapter<UserViewHolder> {

    List<UserJson> userList;
    Activity activity;

    public UserJsonRecyclerAdapter(List<UserJson> userList, Activity activity) {
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
        final UserJson user = userList.get(position);
        holder.bindUserJson(user);
        holder.itemUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<UserJson> call = JsonPlaceHolderApiService.getRetrofitUser().getUser(user.getId().toString());
                call.enqueue(new Callback<UserJson>() {
                    @Override
                    public void onResponse(Call<UserJson> call, Response<UserJson> response) {
                        Toast.makeText(activity, response.body().getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UserJson> call, Throwable t) {
                        Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}