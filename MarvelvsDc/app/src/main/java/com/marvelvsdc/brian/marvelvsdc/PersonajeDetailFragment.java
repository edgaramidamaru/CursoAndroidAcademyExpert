package com.marvelvsdc.brian.marvelvsdc;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvelvsdc.brian.marvelvsdc.modelos.Personaje;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonajeDetailFragment extends Fragment {

    ConstraintLayout constraintLayoutContainer;
    ImageView imgView;
    TextView txtName;
    TextView txtTipo;
    View viewLayout;
    boolean isRed;

    public PersonajeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewLayout = inflater.inflate(R.layout.fragment_personaje_detail, container, false);
        imgView = viewLayout.findViewById(R.id.imageView3);
        txtName = viewLayout.findViewById(R.id.txt_nombre);
        txtTipo = viewLayout.findViewById(R.id.txt_tipo);
        constraintLayoutContainer = viewLayout.findViewById(R.id.constraint_container);
        return viewLayout;
    }

    public void showPersonaje(Personaje personaje){

        txtName.setText(personaje.getNombre());
        txtTipo.setText(personaje.getTipo().toString());
        if (isRed){
            constraintLayoutContainer.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            isRed = false;
        }else {
            constraintLayoutContainer.setBackgroundColor(getResources().getColor(R.color.colorPrimaryMarvel));
            isRed = true;
        }
    }

}
