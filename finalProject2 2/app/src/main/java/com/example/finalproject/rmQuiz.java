package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class rmQuiz extends AppCompatActivity {

    private ArrayList<JSONObject> charactersrm;
    HashSet<String> wantedChars;

    private String URL="https://rickandmortyapi.com/api/character/";

    RequestQueue requestQueue;
    TextView rmTittle;
    TextView factsDisplay;
    Button moreHintsbtn;
    Button knowbtn;
    Button giveupbtn;
    rmFacts rick;
    rmFacts morty;
    rmFacts summer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rm_quiz);

        wantedChars= new HashSet<String>();
        charactersrm= new ArrayList<>();
        rmTittle= findViewById(R.id.rmTitle);
        factsDisplay=findViewById(R.id.factsDisplay);
        moreHintsbtn=findViewById(R.id.moreHintsbtn);
        knowbtn=findViewById(R.id.knowItbtn);
        giveupbtn=findViewById(R.id.giveupbtn);

       // factsDisplay.setText();

        wantedChars.add("morty smith");
        wantedChars.add("summer smith");
        wantedChars.add("jerry smith");
        wantedChars.add("beth smith");
        wantedChars.add("rick sanchez");

        requestQueue= Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.d("request", "response:  "+ response.toString());
                        try {
                            JSONArray data  = response.getJSONArray("results");
                            Log.d("data",data.toString());

                            for (int i=0; i<data.length();i++){
                                String name= data.getJSONObject(i).getString("name").toLowerCase();
                                if (wantedChars.contains(name)){
                                    charactersrm.add(data.getJSONObject(i));
                                }
                            }
                            //rmTittle.setText(charactersrm.get(0).getString("name")+"");

                            ArrayList<String> RickFacts= new ArrayList<String>();
                            RickFacts.add("this character likes to drink");
                            RickFacts.add("this character likes science");
                            RickFacts.add("this character has 2 grandchildren");

                            rick=new rmFacts(RickFacts,charactersrm.get(0));

                            ArrayList<String> MortyFacts= new ArrayList<String>();
                            MortyFacts.add("this character is a male");
                            MortyFacts.add("this character has brown hair");
                            MortyFacts.add("this character says oh jeez");

                            morty=new rmFacts(MortyFacts,charactersrm.get(0));

                            ArrayList<String> SummerFacts= new ArrayList<String>();
                            SummerFacts.add("this character is a female");
                            SummerFacts.add("this character goes to High School");
                            SummerFacts.add("this character uses her phone a lot");

                            summer=new rmFacts(SummerFacts,charactersrm.get(0));




                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("catched", "catched");
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("response" , "Something went wrong");
                    }
                }

        );

        requestQueue.add(jsonObjectRequest); //make the request

        //ArrayList<String> RickFacts= new ArrayList<String>();
        //RickFacts.add("has 2 grandchildren");
        //RickFacts.add("likes to drink");
        //RickFacts.add("likes science");
        //rmTittle.setText(charactersrm.size()+"");

        //Collections.shuffle(RickFacts);
        //rmFacts rick=new rmFacts(RickFacts,charactersrm.get(0));
        //rmTittle.setText(RickFacts.size()+"");
        //ArrayList<String> mortyFacts= new ArrayList<String>();

        //mortyFacts.add("this character is a male");
        //mortyFacts.add("this character is in High School");

        //Collections.shuffle(RickFacts);
        //rmFacts morty =new rmFacts(mortyFacts,charactersrm.get(0));

    }

}