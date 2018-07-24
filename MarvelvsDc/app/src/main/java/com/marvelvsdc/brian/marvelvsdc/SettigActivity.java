package com.marvelvsdc.brian.marvelvsdc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import static com.marvelvsdc.brian.marvelvsdc.R.drawable.dclogo;

public class SettigActivity extends AppCompatActivity {

    ImageView imgMarvel;
    ImageView imgDc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settig);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgMarvel = findViewById(R.id.img_marvel);
        imgDc = findViewById(R.id.img_dc);
        //imgMarvel.setBackgroundResource(R.drawable.ic_logo_dc);

        imgMarvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNavigationiActivity.goToActivityFins(SettigActivity.this, MenuActivity.class);
            }
        });

        imgDc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilNavigationiActivity.goToActivityFins(SettigActivity.this, MenuActivity.class);
            }
        });
    }

}
