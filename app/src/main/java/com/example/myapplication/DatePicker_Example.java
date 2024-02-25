package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.Inet4Address;
import java.time.DayOfWeek;

public class DatePicker_Example extends AppCompatActivity implements View.OnClickListener {
    DatePicker dp1;
    TextView tx1;
    Button bt1;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(DatePicker_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_example);
        dp1= (DatePicker) findViewById(R.id.dp1);
        tx1= (TextView) findViewById(R.id.txtres);
        bt1 = (Button) findViewById(R.id.button4);

        bt1.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        StringBuilder sp = new StringBuilder();
        sp.append("Selected Date: ").append(dp1.getDayOfMonth()).append("-");
        sp.append(dp1.getMonth()+1).append("-");
        sp.append(dp1.getYear());
        tx1.setText(sp);

    }
}