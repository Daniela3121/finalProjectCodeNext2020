package com.example.finalproject;

import org.json.JSONObject;

import java.util.ArrayList;

public class objectTvshows {

    private ArrayList<String> TvShowsFacts;
    private String ShowName;
    private String description;
    private int index;
    private int img;

    public objectTvshows(ArrayList<String> tvShowsFacts, String showName, String description, int img) {
        TvShowsFacts = tvShowsFacts;
        ShowName = showName;
        this.description = description;
        this.img = img;
    }

    public ArrayList<String> getTvShowsFacts() {
        return TvShowsFacts;
    }

    public void setTvShowsFacts(ArrayList<String> tvShowsFacts) {
        TvShowsFacts = tvShowsFacts;
    }

    public String getShowName() {
        return ShowName;
    }

    public void setShowName(String showName) {
        ShowName = showName;
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
        if (TvShowsFacts.size()>index) {
            return TvShowsFacts.get(index++);
        }
        else {
            return TvShowsFacts.get(4);
        }
    }
//    public TvShowsFacts(ArrayList<String> facts) {
//        this.TvShowsFacts = TvShowsFacts;
//    }











}
