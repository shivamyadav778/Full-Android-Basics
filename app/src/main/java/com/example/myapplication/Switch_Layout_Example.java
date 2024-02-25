package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Switch_Layout_Example extends AppCompatActivity
{
    Switch red,green,blue,magenta;
    ConstraintLayout clayout;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Switch_Layout_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_layout_example);

        red = (Switch) findViewById(R.id.swt_red);
        green = (Switch) findViewById(R.id.swt_green);
        blue = (Switch) findViewById(R.id.swt_blue);
        magenta = (Switch) findViewById(R.id.swt_magenta);
        clayout = (ConstraintLayout) findViewById(R.id.c_layout1);

        red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    clayout.setBackgroundColor(Color.RED);
                    green.setChecked(false);
                    blue.setChecked(false);
                    magenta.setChecked(false);
                }
            }
        });
        green.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    clayout.setBackgroundColor(Color.GREEN);
                    red.setChecked(false);
                    blue.setChecked(false);
                    magenta.setChecked(false);
                }
            }
        });

        blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    clayout.setBackgroundColor(Color.BLUE);
                    red.setChecked(false);
                    green.setChecked(false);
                    magenta.setChecked(false);

                }
            }
        });

        magenta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    clayout.setBackgroundColor(Color.MAGENTA);
                    red.setChecked(false);
                    green.setChecked(false);
                    blue.setChecked(false);
                }
            }
        });
    }
}
