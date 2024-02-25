package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Spinner_Example extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spin_lang;
    String L[] = {"C","C++","Java","Python",".Net","Android","Flutter","MySQL","PHP"};

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

            Intent i = new Intent(Spinner_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_example);

        spin_lang = (Spinner) findViewById(R.id.spinner_lang);

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,L);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_lang.setAdapter(ad);

        spin_lang.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, "You have selected " + L[position] + " language ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
