package com.questionary.brian.podcast.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.questionary.brian.podcast.R;
import com.questionary.brian.podcast.models.User;
import com.questionary.brian.podcast.models.UserJson;

import org.w3c.dom.Text;

public class UserViewHolder extends RecyclerView.ViewHolder {

    CardView itemUser;
    TextView name;
    TextView age;
    TextView phone;

    public UserViewHolder(View itemView) {
        super(itemView);
        itemUser = itemView.findViewById(R.id.card_item_user);
        name = itemView.findViewById(R.id.id_name);
        age = itemView.findViewById(R.id.id_age);
        phone = itemView.findViewById(R.id.id_phone);
    }

    public void bind(User user){
        name.setText(user.getName());
        age.setText(user.getAge().toString());
        phone.setText(user.getPhone());
    }

    public void bindUserJson(UserJson user){
        name.setText(user.getName());
        age.setText(user.getEmail());
        phone.setText(user.getWebSite());
    }

}
