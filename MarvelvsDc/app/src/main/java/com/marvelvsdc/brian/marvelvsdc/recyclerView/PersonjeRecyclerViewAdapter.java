package com.marvelvsdc.brian.marvelvsdc.recyclerView;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.marvelvsdc.brian.marvelvsdc.PersonjeActivity;
import com.marvelvsdc.brian.marvelvsdc.R;
import com.marvelvsdc.brian.marvelvsdc.modelos.Personaje;

import java.util.List;

public class PersonjeRecyclerViewAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {

    List<Personaje> personajeList;
    Activity activity;

    public PersonjeRecyclerViewAdapter(List<Personaje> personajeList, Activity activity) {
        this.personajeList = personajeList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        final Personaje personaje = personajeList.get(position);
        holder.bind(personaje);
        holder.cardPerssona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ( (PersonjeActivity)activity).showToast(personaje.getNombre());
            }
        });
    }

    @Override
    public int getItemCount() {
        return personajeList.size();
    }
}
