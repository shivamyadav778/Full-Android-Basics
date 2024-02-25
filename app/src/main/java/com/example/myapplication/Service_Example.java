package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Service_Example extends AppCompatActivity implements View.OnClickListener {
    Button btnstart,btnstop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_example);

        btnstart = (Button) findViewById(R.id.btn_ser_start);
        btnstop = (Button) findViewById(R.id.btn_serv_stop);

        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnstart){
            startService(new Intent( Service_Example.this,MyService.class));

        }
        if(v == btnstop){
            stopService(new Intent(Service_Example.this, MyService.class));

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();

    }
}
