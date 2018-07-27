package com.marvelvsdc.brian.marvelvsdc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.marvelvsdc.brian.marvelvsdc.R;
import com.marvelvsdc.brian.marvelvsdc.utils.UtilNavigationiActivity;
import com.marvelvsdc.brian.marvelvsdc.activities.MenuActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarvelSelecFragment extends Fragment {

    ImageView imgMarvel;
    View viewRoot;

    public MarvelSelecFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewRoot = inflater.inflate(R.layout.fragment_marvel_selec, container, false);
        imgMarvel = viewRoot.findViewById(R.id.img_marvel);
        imgMarvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNavigationiActivity.goToActivityFins(getActivity(), MenuActivity.class);
            }
        });
        return viewRoot;
    }

}
