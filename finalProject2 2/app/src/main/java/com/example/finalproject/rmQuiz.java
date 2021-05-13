package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    rmFacts beth;
    rmFacts jerry;
    EditText etHidden;
    Button submit;
    ImageView correctChar;
    ArrayList<rmFacts> quizCharacters;
    private CountDownTimer pictureTime;
    private long timer=4000;
    int characterIndex  = 0;


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
        etHidden=findViewById(R.id.et);
        submit=findViewById(R.id.submitbtn);
        correctChar=findViewById(R.id.correctChar);
        quizCharacters = new ArrayList<rmFacts>();


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
                        Log.d("request", "response:  "+ response.toString());
                        try {
                            JSONArray data  = response.getJSONArray("results");
                            Log.d("data",data.toString());

                            for (int i=0; i<data.length();i++){
                                String name= data.getJSONObject(i).getString("name").toLowerCase();
                                if (wantedChars.contains(name)){
                                    charactersrm.add(data.getJSONObject(i));
                                }
                            }
                           // rmTittle.setText(charactersrm.get(0).getString("name")+"");

                            ArrayList<String> RickFacts= new ArrayList<String>();
                            RickFacts.add("this character likes to drink");
                            RickFacts.add("this character likes science");
                            RickFacts.add("this character has 2 grandchildren");

                            // rick=new rmFacts(RickFacts,charactersrm.get(0),R.drawable.confusedcat);
                            rick=new rmFacts(RickFacts,charactersrm.get(0),R.drawable.rsanchez);


                            quizCharacters.add(rick);

                            ArrayList<String> MortyFacts= new ArrayList<String>();
                            MortyFacts.add("this character is a male");
                            MortyFacts.add("this character has brown hair");
                            MortyFacts.add("this character says oh jeez");

                            morty=new rmFacts(MortyFacts,charactersrm.get(1),R.drawable.morty2);

                            quizCharacters.add(morty);

                            ArrayList<String> SummerFacts= new ArrayList<String>();
                            SummerFacts.add("this character is a female");
                            SummerFacts.add("this character goes to High School");
                            SummerFacts.add("this character uses her phone a lot");

                            summer=new rmFacts(SummerFacts,charactersrm.get(2),R.drawable.ssmith);

                            quizCharacters.add(summer);

                            ArrayList<String> BethFacts= new ArrayList<String>();
                            BethFacts.add("this character is a female");
                            BethFacts.add("this character has blond hair");
                            BethFacts.add("this character is married");

                            beth=new rmFacts(BethFacts,charactersrm.get(3),R.drawable.bsmith);

                            quizCharacters.add(beth);

                            ArrayList<String> JerryFacts= new ArrayList<String>();
                            JerryFacts.add("this character is a male");
                            JerryFacts.add("this character is not considered as smart");
                            JerryFacts.add("this character has brown hair");

                            jerry=new rmFacts(JerryFacts,charactersrm.get(4),R.drawable.jsmith);

                            quizCharacters.add(jerry);

                            Collections.shuffle(quizCharacters);
                            factsDisplay.setText(quizCharacters.get(characterIndex).getFact());


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

        knowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etHidden.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String charguess = etHidden.getText().toString().toLowerCase();
                String charName= quizCharacters.get(characterIndex).getName().toLowerCase();
                Log.d("test", charName);

                if (charguess.equals(charName)){

                    etHidden.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.INVISIBLE);
                    factsDisplay.setVisibility(View.INVISIBLE);

                    new CountDownTimer(4000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                            correctChar.setVisibility(View.VISIBLE);
                            factsDisplay.setVisibility(View.INVISIBLE);
                            correctChar.setImageResource(quizCharacters.get(characterIndex).getPic());
                            etHidden.setVisibility(View.INVISIBLE);
                            submit.setVisibility(View.INVISIBLE);
                            rmTittle.setText("        "+quizCharacters.get(characterIndex).getName());

                        }

                        @Override
                        public void onFinish() {

                            correctChar.setVisibility(View.INVISIBLE);
                            etHidden.setVisibility(View.INVISIBLE);
                            submit.setVisibility(View.INVISIBLE);
                            factsDisplay.setVisibility(View.VISIBLE);
                            characterIndex++;
                            factsDisplay.setText(quizCharacters.get(characterIndex).getFact());
                            rmTittle.setText("        Rick And Morty");

                        }
                    }.start();


                }

            }
        });

        giveupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(4000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Log.d("test", "hi");

                        correctChar.setVisibility(View.VISIBLE);
                        factsDisplay.setVisibility(View.INVISIBLE);
                        correctChar.setImageResource(quizCharacters.get(characterIndex).getPic());
                        etHidden.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        rmTittle.setText("        "+quizCharacters.get(characterIndex).getName());
                    }
                    @Override
                    public void onFinish() {

                        correctChar.setVisibility(View.INVISIBLE);
                        etHidden.setVisibility(View.INVISIBLE);
                        etHidden.setText("");
                        submit.setVisibility(View.INVISIBLE);
                        factsDisplay.setVisibility(View.VISIBLE);
                        characterIndex++;
                        rmTittle.setText("        Rick And Morty");
                        factsDisplay.setText(quizCharacters.get(characterIndex).getFact());
                    }
                }.start();


            }
        });

        moreHintsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                factsDisplay.setText(quizCharacters.get(characterIndex).getFact());

            }
        });

    }

}