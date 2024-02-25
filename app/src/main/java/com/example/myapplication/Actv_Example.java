package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Actv_Example extends AppCompatActivity {
    AutoCompleteTextView actv;
    String[] lang = {"C","C++","Python","Android","Java","HTML"};
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Actv_Example.this, Main_menu.class);
            startActivity(i);
            finish();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actv_example);

        actv =  (AutoCompleteTextView) findViewById(R.id.actv_1);

        ArrayAdapter<String> act = new ArrayAdapter<>(this, android.R.layout.select_dialog_item,lang);
        actv.setAdapter(act);
        actv.setThreshold(1);
        actv.setTextColor(Color.BLUE);




    }
}
