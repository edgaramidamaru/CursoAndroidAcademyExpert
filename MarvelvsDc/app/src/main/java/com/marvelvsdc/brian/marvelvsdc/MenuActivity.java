package com.marvelvsdc.brian.marvelvsdc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView txtComic1;
    TextView txtComic2;
    TextView txtComic3;
    TextView txtComic4;
    FloatingActionButton fbVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadReferences();
    }

    public void loadReferences() {
        txtComic1 = findViewById(R.id.txt_comic1);
        txtComic2 = findViewById(R.id.txt_comic2);
        txtComic3 = findViewById(R.id.txt_comic3);
        txtComic4 = findViewById(R.id.txt_comic4);
        txtComic1.setText("Secret War");
        txtComic2.setText("Rebirth");
        txtComic3.setText("Venom");
        txtComic4.setText("Flash Point");

        fbVisibility = findViewById(R.id.floating_button_view);
        fbVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtComic1.getVisibility() == View.INVISIBLE) {
                    txtComic1.setVisibility(View.VISIBLE);
                    txtComic2.setVisibility(View.VISIBLE);
                    txtComic3.setVisibility(View.VISIBLE);
                    txtComic4.setVisibility(View.VISIBLE);
                } else {
                    txtComic1.setVisibility(View.INVISIBLE);
                    txtComic2.setVisibility(View.INVISIBLE);
                    txtComic3.setVisibility(View.INVISIBLE);
                    txtComic4.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            UtilNavigationiActivity.goToActivity(MenuActivity.this,PersonajeActivity.class);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
