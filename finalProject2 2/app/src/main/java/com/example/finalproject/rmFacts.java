package com.example.finalproject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class rmFacts {
    private ArrayList<String> facts;
    private JSONObject data;
    private int index = 0;

    public rmFacts(ArrayList<String> facts, JSONObject data) {
        this.facts = facts;
        this.data = data;

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
        return facts.get(index++);
    }
}


