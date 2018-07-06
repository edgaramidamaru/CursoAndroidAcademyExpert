package com.tracking.brian.holamundo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class HolaActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola);
        System.out.println("Hola Mundo onCreate");
    }
    
    @Override
    public void onStart() {
        Log.d("Ciclo de vida", "Hola Mundo onStart");
        System.out.println("Hola Mundo onStart");
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Hola mundo onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Hola mundo onResume");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Hola mundo onDestroy");
    }
}
