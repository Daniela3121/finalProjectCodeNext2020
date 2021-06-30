package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class movieActivity extends AppCompatActivity {
    TextView movieTitle;
    TextView facts4movieDisplay;
    Button moreHintsMoviebtn;
    Button guessMoviebtn;
    Button giveupMoviesbtn;
    EditText et3hidden;
    Button submit3;
    ImageView movieImage;
    objectmovies tenet;
    objectmovies toy_Story;
    objectmovies theLittleMermaid;
    objectmovies maleficent;
    objectmovies ratatouille;
    int movieindex = 0;
    private CountDownTimer imageTime;
    ArrayList <objectmovies> moviesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        movieTitle = findViewById(R.id.movieTitle);
        facts4movieDisplay = findViewById(R.id.facts4moviesDisplay);
        moreHintsMoviebtn = findViewById(R.id.moreHintsMoviebtn);
        guessMoviebtn = findViewById(R.id.guessMoviebtn);
        giveupMoviesbtn = findViewById(R.id.giveupMoviebtn);
        et3hidden = findViewById(R.id.et3hidden);
        submit3 = findViewById(R.id.submit3);
        movieImage = findViewById(R.id.movieImage);

        moviesList = new ArrayList<objectmovies>();

        ArrayList<String> tenetFacts = new ArrayList<String>();
        tenetFacts.add("A secret agent is given a single word as his weapon and sent to prevent the onset of World War III");
        tenetFacts.add("The main character must travel through time and bend the laws of nature in order to be successful in his mission.");
        tenetFacts.add("This film is slightly connected to Alfred Hitchcock");
        tenetFacts.add("this movie was released in August 12, 2020)'");
        tenetFacts.add("this movie is over two hours long");
        tenet = new objectmovies(tenetFacts, "Tenet", "" +
                "", R.drawable.tenet);
        moviesList.add(tenet);

        ArrayList<String> toy_storyFacts = new ArrayList<String>();
        toy_storyFacts.add("Toys come to life when humans are not present");
        toy_storyFacts.add("The plot focuses on the relationship between an old-fashioned pull-string cowboy doll and an astronaut action figure");
        toy_storyFacts.add("This film is strongly focused on friendship");
        toy_storyFacts.add("There are 4 sequels total and the first one was released in 1995");
        toy_storyFacts.add("The main characters have many adventures but always come back to their owner or their 'kid'");
        toy_Story = new objectmovies(toy_storyFacts, "Toy Story", "" +
                "", R.drawable.toystory);
        moviesList.add(toy_Story);

        ArrayList<String> the_little_mermaid = new ArrayList<String>();
        the_little_mermaid.add("A rebellious mermaid is fascinated with legs, so the trades her voice for a pair of these.");
        the_little_mermaid.add("The main character has red hair");
        the_little_mermaid.add("This film was released in November 13, 1989");
        the_little_mermaid.add("At the end the character gets to keep her legs");
        the_little_mermaid.add("There is a singing crab");
        theLittleMermaid = new objectmovies(the_little_mermaid, "The Little Mermaid", "" +
                "", R.drawable.lilmermaid);
        moviesList.add(theLittleMermaid);

        ArrayList<String> maleficentFacts = new ArrayList<String>();
        maleficentFacts.add("The main character has an idyllic life in a forest kingdom and had a pure heart.");
        maleficentFacts.add("When an invading army threatens the land, the main character rises up to become its fiercest protector. However, a terrible betrayal hardens her heart and twists her into a creature bent on revenge");
        maleficentFacts.add("This film was released in May 28, 2014");
        maleficentFacts.add("The movie is based on the evil character of another Disney movie");
        maleficentFacts.add("The main character was not invited to an event and this is what caused her to hold a grudge against the characters involved.");
        maleficent = new objectmovies(maleficentFacts, "Maleficent", "" +
                "", R.drawable.maleficent);
        moviesList.add(maleficent);

        ArrayList<String> ratatouilleFacts = new ArrayList<String>();
        ratatouilleFacts.add("The main character is not a human");
        ratatouilleFacts.add("The main character dreams of becoming a chef");
        ratatouilleFacts.add("This film takes place in Paris");
        ratatouilleFacts.add("The main character who is not human and another main character who is a human work together to achieve their dream");
        ratatouilleFacts.add("This film was released in June 29, 2007");
        ratatouille = new objectmovies(maleficentFacts, "Maleficent", "" +
                "", R.drawable.ratatouille);
        moviesList.add(ratatouille);

        Collections.shuffle(moviesList);

        facts4movieDisplay.setText(moviesList.get(movieindex).getFact());

    moreHintsMoviebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            facts4movieDisplay.setText(moviesList.get(movieindex).getFact());
        }
    });
    guessMoviebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            et3hidden.setVisibility(View.VISIBLE);
            submit3.setVisibility(View.VISIBLE);
        }
    });
    giveupMoviesbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new CountDownTimer(4000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    movieImage.setVisibility(View.VISIBLE);
                    facts4movieDisplay.setVisibility(View.INVISIBLE);
                    movieImage.setImageResource(moviesList.get(movieindex).getImg());
                    et3hidden.setVisibility(View.INVISIBLE);
                    submit3.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onFinish() {

                    movieImage.setVisibility(View.INVISIBLE);
                    et3hidden.setVisibility(View.INVISIBLE);
                    submit3.setVisibility(View.INVISIBLE);
                    movieindex++;
                    facts4movieDisplay.setText(moviesList.get(movieindex).getFact());
                    facts4movieDisplay.setVisibility(View.VISIBLE);
                }
            }.start();
        }
    });

        submit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieGuess = et3hidden.getText().toString().toLowerCase();
                final String movieName = moviesList.get(movieindex).getMovieName().toLowerCase();

                if (movieGuess.equals(movieName)) {
                    et3hidden.setVisibility(View.INVISIBLE);
                    submit3.setVisibility(View.INVISIBLE);
                    facts4movieDisplay.setVisibility(View.INVISIBLE);
                    movieImage.setVisibility(View.VISIBLE);
                    movieImage.setImageResource(moviesList.get(movieindex).getImg());

                    new CountDownTimer(4000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            movieImage.setVisibility(View.VISIBLE);
                            facts4movieDisplay.setVisibility(View.INVISIBLE);
                            movieImage.setImageResource(moviesList.get(movieindex).getImg());
                            et3hidden.setVisibility(View.INVISIBLE);
                            submit3.setVisibility(View.INVISIBLE);
                            movieTitle.setText("       "+movieName);
                        }
                        @Override
                        public void onFinish() {
                            movieImage.setVisibility(View.INVISIBLE);
                            et3hidden.setVisibility(View.INVISIBLE);
                            et3hidden.setText("");
                            submit3.setVisibility(View.INVISIBLE);
                            facts4movieDisplay.setVisibility(View.VISIBLE);
                            movieindex++;
                            movieTitle.setText("         Movies");
                            facts4movieDisplay.setText(moviesList.get(movieindex).getFact());
                        }
                    }.start();
                }
            }
        });

    }
    public void layoutChange(){
        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                movieImage.setVisibility(View.VISIBLE);
                facts4movieDisplay.setVisibility(View.INVISIBLE);
                movieImage.setImageResource(moviesList.get(movieindex).getImg());
                et3hidden.setVisibility(View.INVISIBLE);
                submit3.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFinish() {

                movieImage.setVisibility(View.INVISIBLE);
                et3hidden.setVisibility(View.INVISIBLE);
                submit3.setVisibility(View.INVISIBLE);
                movieindex++;
                facts4movieDisplay.setText(moviesList.get(movieindex).getFact());
                facts4movieDisplay.setVisibility(View.VISIBLE);
            }
        }.start();
    }
}