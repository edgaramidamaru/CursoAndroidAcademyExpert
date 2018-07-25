package com.marvelvsdc.brian.marvelvsdc.recyclerView;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvelvsdc.brian.marvelvsdc.R;
import com.marvelvsdc.brian.marvelvsdc.modelos.Personaje;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    CardView cardPerssona;
    TextView txtNombrePersonje;
    TextView txtipo;
    Button btnEditar;
    ImageView imgPersonaje;

    public PersonajeViewHolder(View itemView) {
        super(itemView);
        cardPerssona = itemView.findViewById(R.id.card_personaje);
        txtNombrePersonje = itemView.findViewById(R.id.txt_nombre_personaje);
        txtipo = itemView.findViewById(R.id.txt_tipo);
        btnEditar = itemView.findViewById(R.id.btn_edit);
        imgPersonaje = itemView.findViewById(R.id.img_personaje);
    }

    public void bind(Personaje personaje){
        txtNombrePersonje.setText(personaje.getNombre());
        txtipo.setText(personaje.getTipo().toString());
    }

}
