package com.example.finalproject;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class rmFacts {
    private ArrayList<String> facts;
    private JSONObject data;
    private int img;
    private int index = 0;

    public rmFacts(ArrayList<String> facts, JSONObject data, int img) {
        this.facts = facts;
        this.data = data;
        this.img = img;
    }
    public String getName(){
        try {
           return data.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        } return "";
    }

    public String getGender(){
        try {
            return data.getString("gender");
        } catch (JSONException e) {
            e.printStackTrace();
        } return "";
    }

    public int getPic(){
        return img;
    }

    public String getStatus(){
        try {
            return data.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        } return "";
    }

    public String getSpecies(){
        try {
            return data.getString("species");
        } catch (JSONException e) {
            e.printStackTrace();
        } return "";
    }

    public String getFact(){
        if (facts.size()>index) {
            return facts.get(index++);
        }
        else {
            return facts.get(2);
        }
    }
}


