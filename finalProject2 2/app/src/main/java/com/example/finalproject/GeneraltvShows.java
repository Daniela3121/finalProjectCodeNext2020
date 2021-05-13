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
    private CountDownTimer pictureTime;
    ArrayList <objectTvshows> tvshowsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generaltv_shows);

        tvtitleShows = findViewById(R.id.tvtitleShows);
        Facts4tvshowsDisplay = findViewById(R.id.Facts4tvshowsDisplay);
        moreHintsShowsbtn = findViewById(R.id.moreHintsShowsbtn);
        guessShowbtn = findViewById(R.id.guessShowbtn);
        giveupShowsbtn = findViewById(R.id.giveupShowsbtn);
        et2hidden = findViewById(R.id.et2hidden);
        submit2 = findViewById(R.id.submit2);
        showImage = findViewById(R.id.showImage);


        tvshowsList = new ArrayList<objectTvshows>();

        ArrayList<String> FriendsFacts = new ArrayList<String>();
        FriendsFacts.add("this show has 6 main characters");
        FriendsFacts.add("this show has 4 boys and 3 girls");
        FriendsFacts.add("this show has 10 seasons");
        FriendsFacts.add("this show was originally called 'Insomnia Cafe (and a bunch of other things)'");
        FriendsFacts.add("two of the main characters are siblings");
        friends = new objectTvshows(FriendsFacts, "FRIENDS", "TV show about 6 friends who go through " +
                "just about every life experience imaginable together.", R.drawable.friendsimg);
        tvshowsList.add(friends);

        ArrayList<String> reasonsFacts = new ArrayList<>();
        reasonsFacts.add("This show has 4 seasons");
        reasonsFacts.add("5 characters died throughout the series");
        reasonsFacts.add("The actor Brandon Flynn plays one of the main characters");
        reasonsFacts.add("The main characters are trying to figure out a character's death");
        reasonsFacts.add("Selena Gomez was supposed to play the main character");
        reasons = new objectTvshows(reasonsFacts, "13 REASONS WHY", "the story of a young high school student that " +
                "suicides after falling in dispair.", R.drawable.reasonsimg);
        tvshowsList.add(reasons);


        ArrayList<String> moneyHeistfacts = new ArrayList<>();
        moneyHeistfacts.add("This is a netflix show");
        moneyHeistfacts.add("this show has 4 parts");
        moneyHeistfacts.add("the focus of this show is to pull a big heist and print billions of Euros");
        moneyHeistfacts.add("the show is originally in Spanish");
        moneyHeistfacts.add("the main characters wear red suits");
        moneyHeist = new objectTvshows(moneyHeistfacts, "MONEY HEIST", "Spanish heist crime drama television series " +
                "created by Álex Pina", R.drawable.moneyheist);
        tvshowsList.add(moneyHeist);


        ArrayList<String> onePieceFacts = new ArrayList<>();
        onePieceFacts.add("This is a Japanese manga and Anime series");
        onePieceFacts.add("This show has 23 seasons of 741 episodes total");
        onePieceFacts.add("Dragon Ball was a major inspiration for this this Anime");
        onePieceFacts.add("The main character wears a hat");
        onePieceFacts.add("There is a real life version of a memorial from the series");
        onePiece = new objectTvshows(onePieceFacts, "ONE PIECE", "One Piece is a steampunk manga and anime series. " +
                "It revolves around a crew of pirates led by captain Monkey D. Luffy, whose dream is to obtain the ultimate treasure One " +
                "Piece", R.drawable.onepieceimg);
        tvshowsList.add(onePiece);


        ArrayList<String> riverdaleFacts = new ArrayList<>();
        riverdaleFacts.add("Cole Sprouse plays one of the main characters");
        riverdaleFacts.add("This show has 4 seasons");
        riverdaleFacts.add("At the end of most seasons it's said that the same character has died");
        riverdaleFacts.add("Every episode of this series is based on a movie");
        riverdale = new objectTvshows(riverdaleFacts, "Riverdale", "", R.drawable.riverdaleimg);
        tvshowsList.add(riverdale);


        Collections.shuffle(tvshowsList);
        Facts4tvshowsDisplay.setText(tvshowsList.get(showindex).getFact());


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
               // Log.d("test", "hi");

                new CountDownTimer(4000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        showImage.setVisibility(View.VISIBLE);
                        Facts4tvshowsDisplay.setVisibility(View.INVISIBLE);
                        showImage.setImageResource(tvshowsList.get(showindex).getImg());
                        et2hidden.setVisibility(View.INVISIBLE);
                        submit2.setVisibility(View.INVISIBLE);
                        Log.d("test", "hi");

                    }

                    @Override
                    public void onFinish() {

                        showImage.setVisibility(View.INVISIBLE);
                        et2hidden.setVisibility(View.INVISIBLE);
                        submit2.setVisibility(View.INVISIBLE);
                        Facts4tvshowsDisplay.setVisibility(View.VISIBLE);
                        showindex++;
                        Facts4tvshowsDisplay.setText(tvshowsList.get(showindex).getFact());
                    }
                }.start();

            }
        });
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String showGuess = et2hidden.getText().toString().toLowerCase();
                final String showName = tvshowsList.get(showindex).getShowName().toLowerCase();

                if (showGuess.equals(showName)) {
                    et2hidden.setVisibility(View.INVISIBLE);
                    submit2.setVisibility(View.INVISIBLE);
                    Facts4tvshowsDisplay.setVisibility(View.INVISIBLE);
                    showImage.setVisibility(View.VISIBLE);
                    showImage.setImageResource(tvshowsList.get(showindex).getImg());

                    new CountDownTimer(4000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                            showImage.setVisibility(View.VISIBLE);
                            Facts4tvshowsDisplay.setVisibility(View.INVISIBLE);
                            showImage.setImageResource(tvshowsList.get(showindex).getImg());
                            et2hidden.setVisibility(View.INVISIBLE);
                            submit2.setVisibility(View.INVISIBLE);
                            tvtitleShows.setText("        "+showName);

                        }

                        @Override
                        public void onFinish() {

                            showImage.setVisibility(View.INVISIBLE);
                            et2hidden.setVisibility(View.INVISIBLE);
                            et2hidden.setText("");
                            submit2.setVisibility(View.INVISIBLE);
                            Facts4tvshowsDisplay.setVisibility(View.VISIBLE);
                            showindex++;
                            tvtitleShows.setText("    General TV Shows");
                            Facts4tvshowsDisplay.setText(tvshowsList.get(showindex).getFact());

                        }
                    }.start();

                }

            }
        });
    }
}