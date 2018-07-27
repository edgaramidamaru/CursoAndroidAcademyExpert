package com.marvelvsdc.brian.marvelvsdc.fragments;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvelvsdc.brian.marvelvsdc.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragmentComic extends DialogFragment {


    public DialogFragmentComic() {
        // Required empty public constructor
    }

    public static  DialogFragmentComic newInstance(){
        DialogFragmentComic dialogFragment = new DialogFragmentComic();
        return dialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_fragment_comic, container, false);
    }

}
