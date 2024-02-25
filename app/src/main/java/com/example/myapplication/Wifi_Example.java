package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Wifi_Example extends AppCompatActivity implements View.OnClickListener {
    Button btn_on,btn_off;
    WifiManager wm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_example);

        btn_on = findViewById(R.id.btn_wifi_on);
        btn_off = findViewById(R.id.btn_wifi_off);

        wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        btn_on.setOnClickListener(this);
        btn_off.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_on){
            if(Build.VERSION.SDK_INT<Build.VERSION_CODES.Q){
                if(!wm.isWifiEnabled()){
                    wm.setWifiEnabled(true);
                } else {
                    wm.setWifiEnabled(false);
                }

            }else{
                if(!wm.isWifiEnabled()){
                    Intent pi = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(pi,4);
                }else{
                    Toast.makeText(this, "Wifi is already on", Toast.LENGTH_SHORT).show();
                }
            }

        }
        if(v == btn_off){
            if(wm.isWifiEnabled()){

                Intent pi = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                    pi = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(pi,5);
                }
            }else {
                Toast.makeText(this, "Wifi is already off", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
