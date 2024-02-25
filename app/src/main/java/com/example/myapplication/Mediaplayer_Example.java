package com.example.myapplication;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;

public class Mediaplayer_Example extends AppCompatActivity implements View.OnClickListener {
    Button btnstart,btnpause,btnstop;

    MediaPlayer mp;
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer_example);
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
        },1);
        mp = new MediaPlayer();

        try {
            mp.setDataSource(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/pm.mp3");
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnstart = findViewById(R.id.btn_med_start);
        btnpause = findViewById(R.id.btn_med_pause);
        btnstop = findViewById(R.id.btn_med_stop);

        btnstart.setOnClickListener(this);
        btnpause.setOnClickListener(this);
        btnstop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == btnstart){

            mp.start();


        }
        if(v == btnpause){
            mp.pause();
        }
        if(v == btnstop){

            mp.stop();
            mp.prepareAsync();
            mp.seekTo(0);
        }

    }
}
