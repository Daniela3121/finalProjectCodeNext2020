package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TvShowsActivity extends AppCompatActivity {

    Button movies;
    Button GeneraltvShows;
    Button rickandmortyActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);

        movies=findViewById(R.id.buttonMovies);
        GeneraltvShows=findViewById(R.id.buttonGTV);
        rickandmortyActivity=findViewById(R.id.buttonRM);

        rickandmortyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRmactivity();
            }
        });

        GeneraltvShows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            goToGeneraltvshows();
            }
        });
    }

    public void goToRmactivity(){
        Intent toRmactivity = new Intent(this,rmQuiz.class);
        startActivity(toRmactivity);
    }

    public void goToGeneraltvshows(){
        Intent toGeneraltvShows = new Intent(this,GeneraltvShows.class);
        startActivity(toGeneraltvShows);
    }
}