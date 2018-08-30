package com.questionary.brian.podcast.models;

public class Title {

    String title;
    String titleTwo;

    public Title(){}

    public Title(String title, String titleTwo) {
        this.title = title;
        this.titleTwo = titleTwo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleTwo() {
        return titleTwo;
    }

    public void setTitleTwo(String titleTwo) {
        this.titleTwo = titleTwo;
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", titleTwo='" + titleTwo + '\'' +
                '}';
    }
}
