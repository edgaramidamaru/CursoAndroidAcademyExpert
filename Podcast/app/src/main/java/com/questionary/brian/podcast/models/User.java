package com.questionary.brian.podcast.models;

import com.questionary.brian.podcast.AppDatabase;
import com.reactiveandroid.Model;
import com.reactiveandroid.annotation.Column;
import com.reactiveandroid.annotation.PrimaryKey;
import com.reactiveandroid.annotation.Table;

@Table(name = "User", database = AppDatabase.class)
public class User extends Model{

    @PrimaryKey(name = "_id")
    private Long id;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    Integer age;
    @Column(name = "phone")
    String phone;
    @Column(name = "country")
    String  conuntry;
    @Column(name = "isOld")
    Boolean isOld;

    public User(){

    }

    public User(String name, Integer age, String phone, String conuntry, Boolean isOld) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.conuntry = conuntry;
        this.isOld = isOld;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConuntry() {
        return conuntry;
    }

    public void setConuntry(String conuntry) {
        this.conuntry = conuntry;
    }

    public Boolean getOld() {
        return isOld;
    }

    public void setOld(Boolean old) {
        isOld = old;
    }
}
