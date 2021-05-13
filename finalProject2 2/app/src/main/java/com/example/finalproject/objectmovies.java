package com.example.finalproject;

import org.json.JSONObject;

import java.util.ArrayList;

public class objectmovies {

    private ArrayList<String> MovieFacts;
    private String MovieName;
    private String description;
    private int index;
    private int img;

    public objectmovies(ArrayList<String> movieFacts, String movieName, String description, int img) {
        MovieFacts = movieFacts;
        MovieName = movieName;
        this.description = description;
        this.img = img;
    }

    public ArrayList<String> getMovieFacts() {
        return MovieFacts;
    }

    public void setMovieFacts(ArrayList<String> movieFacts) {
        MovieFacts = movieFacts;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public String getFact(){
        if (MovieFacts.size()>index) {
            return MovieFacts.get(index++);
        }
        else {
            return MovieFacts.get(4);
        }
    }

}
