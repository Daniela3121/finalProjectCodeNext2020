package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class GeneraltvShows extends AppCompatActivity {
    TextView tvtitleShows;
    TextView Facts4tvshowsDisplay;
    Button moreHintsShowsbtn;
    Button guessShowbtn;
    Button giveupShowsbtn;
    EditText et2hidden;
    Button submit2;
    ImageView showImage;
    objectTvshows friends;
    objectTvshows reasons;
    objectTvshows moneyHeist;
    objectTvshows onePiece;
    objectTvshows riverdale;
    int showindex = 0;
    ArrayList <objectTvshows> tvshowsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generaltv_shows);

        tvtitleShows=findViewById(R.id.tvtitleShows);
        Facts4tvshowsDisplay=findViewById(R.id.Facts4tvshowsDisplay);
        moreHintsShowsbtn=findViewById(R.id.moreHintsbtn);
        guessShowbtn=findViewById(R.id.guessShowbtn);
        giveupShowsbtn=findViewById(R.id.giveupbtn);
        et2hidden=findViewById(R.id.et2hidden);
        submit2=findViewById(R.id.submit2);


        tvshowsList=new ArrayList<objectTvshows>();

        ArrayList<String> FriendsFacts= new ArrayList<String>(); 
            FriendsFacts.add("this show has 6 main characters");
            FriendsFacts.add("this show has 4 boys and 3 girls");
            FriendsFacts.add("this show has 10 seasons");
        friends=new objectTvshows(FriendsFacts,"FRIENDS","TV show about 6 friends who go through " +
                "just about every life experience imaginable together.", R.drawable.confusedcat);
        tvshowsList.add(friends);

        ArrayList<String> reasonsFacts=new ArrayList<>();
            reasonsFacts.add("This show has 4 seasons");
            reasonsFacts.add("5 characters died throughout the series");
            reasonsFacts.add("");
        reasons=new objectTvshows(reasonsFacts,"13 REASONS WHY","the story of a young high school student that " +
                "suicides after falling in dispair.",R.drawable.jsmith);
        tvshowsList.add(reasons);


        ArrayList<String> moneyHeistfacts=new ArrayList<>();
            moneyHeistfacts.add("");
            moneyHeistfacts.add("");
            moneyHeistfacts.add("");
        moneyHeist=new objectTvshows(moneyHeistfacts,"MONEY HEIST","Spanish heist crime drama television series " +
                "created by Álex Pina",R.drawable.bsmith);
        tvshowsList.add(moneyHeist);


        ArrayList<String> onePieceFacts=new ArrayList<>();
            onePieceFacts.add("");
            onePieceFacts.add("");
            onePieceFacts.add("");
        onePiece=new objectTvshows(onePieceFacts,"ONE PIECE","One Piece is a steampunk manga and anime series. " +
                "It revolves around a crew of pirates led by captain Monkey D. Luffy, whose dream is to obtain the ultimate treasure One " +
                "Piece",R.drawable.morty2);
        tvshowsList.add(onePiece);


        ArrayList<String> riverdaleFacts=new ArrayList<>();
            riverdaleFacts.add("");
            riverdaleFacts.add("");
            riverdaleFacts.add("");
        riverdale=new objectTvshows(riverdaleFacts,"riverdale","",R.drawable.rsanchez);
        tvshowsList.add(riverdale);


        Collections.shuffle(tvshowsList);


        moreHintsShowsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facts4tvshowsDisplay.setText(tvshowsList.get(showindex).getFact());
            }
        });
        guessShowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et2hidden.setVisibility(View.VISIBLE);
                submit2.setVisibility(View.VISIBLE);
            }
        });

        giveupShowsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage.setVisibility(View.VISIBLE);
                tvtitleShows.setText("     "+tvshowsList.get(showindex).getShowName().toUpperCase());
                showImage.setImageResource(tvshowsList.get(showindex).getImg());
                Facts4tvshowsDisplay.setVisibility(View.INVISIBLE);


            }
        });
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String charguess = et2hidden.getText().toString().toLowerCase();
                String charName= tvshowsList.get(showindex).getShowName().toLowerCase();

                if (charguess.equals(charName)){
                    et2hidden.setVisibility(View.INVISIBLE);
                    submit2.setVisibility(View.INVISIBLE);
                    Facts4tvshowsDisplay.setVisibility(View.INVISIBLE);
                    showImage.setVisibility(View.VISIBLE);
                    showImage.setImageResource(tvshowsList.get(showindex).getImg());
                }

            }
        });

//            objectTvshows friends=new objectTvshows(FriendsFacts, "FRIENDS","TV show about 6 friends who go through just about every life experience" +
//                    " imaginable together.", R.drawable.confusedcat);


    }
}