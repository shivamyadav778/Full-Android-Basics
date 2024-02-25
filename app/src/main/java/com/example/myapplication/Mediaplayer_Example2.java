package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Mediaplayer_Example2 extends AppCompatActivity implements View.OnClickListener {
    Button btnsp,btnstop;
    MediaPlayer mp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer_example2);
        mp = new MediaPlayer();
        try {
            mp.setDataSource(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/pm.mp3");
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnsp = findViewById(R.id.btn_med_start2);
        btnstop = findViewById(R.id.btn_med_stop);

        btnsp.setOnClickListener(this);
        btnstop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnsp){
            if(mp.isPlaying()){
                btnsp.setText("Start");
                mp.pause();
            }else{
                mp.start();
                btnsp.setText("Pause");
            }
        }
        if(v == btnstop){
            mp.stop();
            mp.prepareAsync();
            mp.seekTo(0);
            btnsp.setText("Start");
        }

    }
}
