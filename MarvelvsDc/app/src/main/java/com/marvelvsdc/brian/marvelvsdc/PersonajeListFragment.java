package com.marvelvsdc.brian.marvelvsdc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvelvsdc.brian.marvelvsdc.modelos.Personaje;
import com.marvelvsdc.brian.marvelvsdc.recyclerView.PersonjeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonajeListFragment extends Fragment {

    RecyclerView rcvPersonaje;
    View viewLayout;
    PersonjeRecyclerViewAdapter personjeRecyclerViewAdapter;

    public PersonajeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewLayout = inflater.inflate(R.layout.fragment_personaje_list, container, false);
        rcvPersonaje = viewLayout.findViewById(R.id.rcv_personaje);
        personjeRecyclerViewAdapter = new PersonjeRecyclerViewAdapter(cargarPersoajes(), getActivity());
        rcvPersonaje.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvPersonaje.setLayoutManager(linearLayoutManager);
        rcvPersonaje.setAdapter(personjeRecyclerViewAdapter);

        return viewLayout;
    }


    public List<Personaje> cargarPersoajes() {
        List<Personaje> personajeList = new ArrayList<>();
        personajeList.add(new Personaje("", "Persoaje1", 1));
        personajeList.add(new Personaje("", "Persoaje2", 2));
        personajeList.add(new Personaje("", "Persoaje3", 3));
        personajeList.add(new Personaje("", "Persoaje4", 4));
        personajeList.add(new Personaje("", "Persoaje5", 5));
        personajeList.add(new Personaje("", "Persoaje6", 6));
        personajeList.add(new Personaje("", "Persoaje7", 7));
        personajeList.add(new Personaje("", "Persoaje8", 8));
        personajeList.add(new Personaje("", "Persoaje9", 9));
        personajeList.add(new Personaje("", "Persoaje1", 1));
        personajeList.add(new Personaje("", "Persoaje2", 2));
        personajeList.add(new Personaje("", "Persoaje3", 3));
        personajeList.add(new Personaje("", "Persoaje4", 4));
        personajeList.add(new Personaje("", "Persoaje5", 5));
        personajeList.add(new Personaje("", "Persoaje6", 6));
        personajeList.add(new Personaje("", "Persoaje7", 7));
        personajeList.add(new Personaje("", "Persoaje8", 8));
        personajeList.add(new Personaje("", "Persoaje9", 9));
        personajeList.add(new Personaje("", "Persoaje1", 1));
        personajeList.add(new Personaje("", "Persoaje2", 2));
        personajeList.add(new Personaje("", "Persoaje3", 3));
        personajeList.add(new Personaje("", "Persoaje4", 4));
        personajeList.add(new Personaje("", "Persoaje5", 5));
        personajeList.add(new Personaje("", "Persoaje6", 6));
        personajeList.add(new Personaje("", "Persoaje7", 7));
        personajeList.add(new Personaje("", "Persoaje8", 8));
        personajeList.add(new Personaje("", "Persoaje9", 9));
        personajeList.add(new Personaje("", "Persoaje1", 1));
        personajeList.add(new Personaje("", "Persoaje2", 2));
        personajeList.add(new Personaje("", "Persoaje3", 3));
        personajeList.add(new Personaje("", "Persoaje4", 4));
        personajeList.add(new Personaje("", "Persoaje5", 5));
        personajeList.add(new Personaje("", "Persoaje6", 6));
        personajeList.add(new Personaje("", "Persoaje7", 7));
        personajeList.add(new Personaje("", "Persoaje8", 8));
        personajeList.add(new Personaje("", "Persoaje9", 9));
    return personajeList;
    }
}
