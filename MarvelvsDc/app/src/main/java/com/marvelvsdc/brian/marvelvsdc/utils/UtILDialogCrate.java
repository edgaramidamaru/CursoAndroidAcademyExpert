package com.marvelvsdc.brian.marvelvsdc.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;

import com.marvelvsdc.brian.marvelvsdc.R;

public class UtILDialogCrate {

    public static void createAlertDialog(String titulo, String cotenido, final CallBackDialog callBackDialog,
                                  Activity activity){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new
                ContextThemeWrapper(activity, R.style.myDialog1));
        alertDialogBuilder.setTitle(titulo);
        alertDialogBuilder.setMessage(cotenido);
        alertDialogBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callBackDialog.aceptar();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callBackDialog.cancelar();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
