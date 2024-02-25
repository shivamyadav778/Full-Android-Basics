package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Popup_Menu_Example extends AppCompatActivity {
    Button bpop;
    ConstraintLayout conlay1;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu_example);
        bpop = findViewById(R.id.buttonpop);
        conlay1 =findViewById(R.id.cl1);

        bpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(Popup_Menu_Example.this, bpop );
                pm.getMenuInflater().inflate(R.menu.popupmenu,pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.Blue)
                        {
                            conlay1.setBackgroundColor(Color.BLUE);
                        } else if (item.getItemId() == R.id.Red) {
                            conlay1.setBackgroundColor(Color.RED);
                        }else if (item.getItemId() == R.id.Green)
                        {
                            conlay1.setBackgroundColor(Color.GREEN);
                        }
                        return false;
                    }
                });pm.show();
            }
        });
    }
}
