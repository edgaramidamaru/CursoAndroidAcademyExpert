package com.marvelvsdc.brian.marvelvsdc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    View viewLayout;
    TextView txtest;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewLayout = inflater.inflate(R.layout.fragment_blank, container, false);
        txtest = viewLayout.findViewById(R.id.txt_fragmennt_test);
        return viewLayout;
    }

}
