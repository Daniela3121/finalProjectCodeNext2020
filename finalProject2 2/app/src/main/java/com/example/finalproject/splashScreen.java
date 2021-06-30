package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class splashScreen extends AppCompatActivity {

        ImageView gamelogo;
        ImageView nonamelogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        nonamelogo=findViewById(R.id.nonamelogo);
       // gamelogo=findViewById(R.id.gameLogo);

       nonamelogo.setImageResource(R.drawable.nonamelogo);

        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {

                goToMain();
            }
        }.start();
    }
    public void goToMain() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}