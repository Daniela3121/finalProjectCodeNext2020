package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.VolleyError;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

//comment/
public class MainActivity extends AppCompatActivity {
//Daniela's comment
    TextView GameName;
    TextView GameDescription;
    ImageView ConfusedCatimg;
    Button GameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameName=findViewById(R.id.GameName);
        GameDescription=findViewById(R.id.GameDescript);
        ConfusedCatimg=findViewById(R.id.confusedCat);
        GameMode=findViewById(R.id.GameMode);

          ConfusedCatimg.setImageResource(R.drawable.confusedcat);
          GameMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToshows();
            }
        });
    }

    public void goToshows(){
        Intent toShows=new Intent(this,TvShowsActivity.class);
        startActivity(toShows);
    }
}
