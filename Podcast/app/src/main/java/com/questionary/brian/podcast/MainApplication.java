package com.questionary.brian.podcast;

import android.app.Application;

import com.questionary.brian.podcast.models.Car;
import com.questionary.brian.podcast.models.User;
import com.reactiveandroid.ReActiveAndroid;
import com.reactiveandroid.ReActiveConfig;
import com.reactiveandroid.internal.database.DatabaseConfig;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseConfig databaseConfig = new DatabaseConfig.Builder(AppDatabase.class)
                .addModelClasses(User.class, Car.class)
                .build();
        ReActiveAndroid.init(new ReActiveConfig.Builder(this)
        .addDatabaseConfigs(databaseConfig).build());
    }
}
