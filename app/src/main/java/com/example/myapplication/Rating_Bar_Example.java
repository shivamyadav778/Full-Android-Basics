package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class Rating_Bar_Example extends AppCompatActivity implements View.OnClickListener {

    RatingBar rate;
    Button btnsubmit;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

            Intent i = new Intent(Rating_Bar_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_bar_example);

        rate = findViewById(R.id.ratingBar);
        btnsubmit = findViewById(R.id.button3);

        btnsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnsubmit)
        {
            float rating = rate.getRating();
            Toast.makeText(this, "Your Given Rating is " + rating, Toast.LENGTH_SHORT).show();
        }
    }
}
