package com.questionary.brian.podcast.models;

import com.questionary.brian.podcast.AppDatabase;
import com.reactiveandroid.annotation.Column;
import com.reactiveandroid.annotation.PrimaryKey;
import com.reactiveandroid.annotation.Table;

@Table(name = "Car", database = AppDatabase.class)
public class Car {

    @PrimaryKey(name = "_id")
    private Long id;
    @Column(name = "model")
    String model;

    public Car(){}

    public Car(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
