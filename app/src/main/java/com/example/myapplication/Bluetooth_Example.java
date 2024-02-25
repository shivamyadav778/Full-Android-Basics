package com.example.myapplication;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Bluetooth_Example extends AppCompatActivity implements View.OnClickListener {
    Button btn_on, btn_dis, btn_off;

    BluetoothAdapter ba;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_example);

        ba = BluetoothAdapter.getDefaultAdapter();

        if (ba == null) {
            Toast.makeText(this, "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
        }

        btn_on = findViewById(R.id.btn_blu1_on);
        btn_dis = findViewById(R.id.btn_blu1_dis);
        btn_off = findViewById(R.id.btn_blu1_off);

        btn_on.setOnClickListener(this);
        btn_dis.setOnClickListener(this);
        btn_off.setOnClickListener(this);

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {

        if (v == btn_on) {
            if (!ba.isEnabled()) {

                Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivityForResult(i, 1);
                Toast.makeText(this, "Bluetooth Turned On", Toast.LENGTH_SHORT).show();
            }
        }
        if (v == btn_dis){
            if(!ba.isDiscovering()){

                Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

                startActivityForResult(i,2);
            }
            Toast.makeText(this, "Started Discoverable Bluetooth", Toast.LENGTH_SHORT).show();
        }
        if(v == btn_off){
                ba.disable();
                Toast.makeText(this, "Bluetooth Turned Off", Toast.LENGTH_SHORT).show();

        }

    }
}
