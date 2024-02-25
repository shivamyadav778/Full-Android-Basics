package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.Inet4Address;

public class Area_Square_Example extends AppCompatActivity implements View.OnClickListener {
    EditText edtext,edtext2;
    Button Areasquare,Arearectangle;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Area_Square_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_square_example);
        edtext = (EditText) findViewById(R.id.editText_sqr);
        edtext2 = (EditText) findViewById(R.id.editText_rec);
        Areasquare = (Button) findViewById(R.id.fas1);
        Arearectangle = (Button) findViewById(R.id.far1);
        Areasquare.setOnClickListener(this);
        Arearectangle.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == Areasquare)
        {
            int l,ans;
            l = Integer.parseInt(edtext.getText().toString().trim());
            ans = l * l;
            Toast.makeText(this, "Area of Square is " + ans, Toast.LENGTH_SHORT).show();
        }
        if (v == Arearectangle)
        {
            int l,b,ans;
            l = Integer.parseInt(edtext.getText().toString().trim());
            b =  Integer.parseInt(edtext2.getText().toString().trim());
            ans = l * b;
            Toast.makeText(this, "Area of Rectangle is " + ans, Toast.LENGTH_SHORT).show();
        }
    }
}
