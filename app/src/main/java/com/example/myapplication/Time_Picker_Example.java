package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Time_Picker_Example extends AppCompatActivity implements View.OnClickListener {
    TimePicker tp1;
    Button btsub;
    TextView txview;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Time_Picker_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_picker_example);

        tp1= findViewById(R.id.tp1);
        btsub=findViewById(R.id.btp1);
        txview=findViewById(R.id.tdp);

        btsub.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == btsub )
        {
            StringBuilder tp = new StringBuilder();
            tp.append("Selected Time = ");
            tp.append(tp1.getHour() + ":");
            tp.append(tp1.getMinute());

            txview.setText(tp.toString());
        }
    }
}

