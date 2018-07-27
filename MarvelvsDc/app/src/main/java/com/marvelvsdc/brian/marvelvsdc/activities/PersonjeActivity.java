package com.marvelvsdc.brian.marvelvsdc.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.marvelvsdc.brian.marvelvsdc.fragments.PersonajeDetailFragment;
import com.marvelvsdc.brian.marvelvsdc.fragments.PersonajeListFragment;
import com.marvelvsdc.brian.marvelvsdc.R;
import com.marvelvsdc.brian.marvelvsdc.modelos.Personaje;

public class PersonjeActivity extends AppCompatActivity {

    PersonajeListFragment personajeListFragment;
    PersonajeDetailFragment personajeDetailFragment;
    FrameLayout frameLayoutContainer;
    FrameLayout frameLayoutContainer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personje);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frameLayoutContainer = findViewById(R.id.framelyout_container);
        frameLayoutContainer2 = findViewById(R.id.fragmelayout_container2);
        personajeListFragment = new PersonajeListFragment();
        personajeDetailFragment = new PersonajeDetailFragment();
        loadFramnet(personajeListFragment, R.id.framelyout_container);
        loadFramnet(personajeDetailFragment, R.id.fragmelayout_container2);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void loadFramnet(Fragment fragment, @IdRes Integer containerView){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerView, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public void showToast(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void showPersonaje(Personaje personaje){
        personajeDetailFragment.showPersonaje(personaje);
    }

}
