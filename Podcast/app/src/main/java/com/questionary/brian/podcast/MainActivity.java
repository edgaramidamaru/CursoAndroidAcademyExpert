package com.questionary.brian.podcast;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.questionary.brian.podcast.Retrofit.Usuarios.JsonPlaceHolderApiService;
import com.questionary.brian.podcast.adapters.UserJsonRecyclerAdapter;
import com.questionary.brian.podcast.adapters.UserRecyclerAdapter;
import com.questionary.brian.podcast.models.Title;
import com.questionary.brian.podcast.models.User;
import com.questionary.brian.podcast.models.UserJson;
import com.reactiveandroid.ReActiveAndroid;
import com.reactiveandroid.query.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.reactiveandroid.ReActiveAndroid.getContext;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //    RecyclerView rcvUser;
    UserRecyclerAdapter recyclerAdapter;
    UserJsonRecyclerAdapter userJsonRecyclerAdapter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rcv_userjson)
    RecyclerView rcvUserjson;
    @BindView(R.id.rcv_user)
    RecyclerView rcvUser;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        db = FirebaseFirestore.getInstance();
        loadReferences();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loadFireBaseData();
    }

    public void showUsers() {
        recyclerAdapter = new UserRecyclerAdapter(Select.from(User.class).fetch(), MainActivity.this);
        rcvUser.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setAdapter(recyclerAdapter);
    }

    public void loadFireBaseData(){
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);
        final Title title =new Title("Titulo1", "tITULO2");
// Add a new document with a generated ID
//        db.collection("titulos").document("titlosseundarios").collection("coleccio2")
//                .add(title)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(MainActivity.this, "Succes", Toast.LENGTH_SHORT).show();
//                        Log.d("onSucces", "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                        Log.w("onFailure", "Error adding document", e);
//                    }
//                });

        DocumentReference docRef = db.collection("titulos").document("titlosseundarios")
                .collection("coleccio2").document("Z5aGsMhwX8lwwjRSbogl");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                Title title1 = snapshot.toObject(Title.class);
                txtTitle.setText(title1.getTitle());
                if (e != null) {

                    Log.w("", "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    Log.d("", "Current data: " + snapshot.getData());
                } else {
                    Log.d("", "Current data: null");
                }
            }
        });

    }

    public void showJsonUser() {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.animate();
        Call<List<UserJson>> call = JsonPlaceHolderApiService.getRetrofitUser().getlistUsuarios();
        call.enqueue(new Callback<List<UserJson>>() {
            @Override
            public void onResponse(Call<List<UserJson>> call, Response<List<UserJson>> response) {
                List<UserJson> userJsons = response.body();
                userJsonRecyclerAdapter = new UserJsonRecyclerAdapter(userJsons, MainActivity.this);
                rcvUserjson.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                rcvUserjson.setLayoutManager(linearLayoutManager);
                rcvUserjson.setAdapter(userJsonRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<UserJson>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadReferences() {
        rcvUser = findViewById(R.id.rcv_user);
        loadUser();
    }

    public void loadUser() {
        ReActiveAndroid.getDatabase(AppDatabase.class).beginTransaction();
        User user1 = new User("name1", 1, "01", "B", true);
        user1.saveAsync();
        User user2 = new User("name2", 2, "02", "B", true);
        user2.save();
        User user3 = new User("name3", 3, "03", "B", true);
        user3.save();
        User user4 = new User("name4", 4, "04", "B", false);
        user4.save();
        User user5 = new User("name5", 5, "05", "B", true);
        user5.save();
        User user6 = new User("name6", 6, "06", "B", false);
        user6.save();
        User user7 = new User("name7", 7, "07", "B", true);
        user7.save();
        User user8 = new User("name8", 8, "08", "B", false);
        user8.save();
        //D ReActiveAndroid.getDatabase(AppDatabase.class);
//        ReActiveAndroid.getDatabase(AppDatabase.class).endTransaction();
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
        getMenuInflater().inflate(R.menu.main, menu);
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
            // Handle the camera action
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

    @OnClick(R.id.fab)
    public void onViewClicked() {
        showUsers();
        showJsonUser();
    }
}
