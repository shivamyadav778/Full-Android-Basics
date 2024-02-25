package com.example.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class Audiorecorder_Example extends AppCompatActivity implements View.OnClickListener {
    Button btnstart,btnstop;
    MediaRecorder mr;
    String afp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiorecorder_example);

        btnstart = findViewById(R.id.btn_aud_start);
        btnstop = findViewById(R.id.btn_aud_stop);

        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnstart){
            btnstop.setEnabled(true);
            btnstart.setEnabled(false);

            afp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/myaudio.3gp";


            try {
                mr = new MediaRecorder();
                mr.setAudioSource(MediaRecorder.AudioSource.MIC);
                mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mr.setOutputFile(afp);
                mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                mr.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mr.start();

        }
        if (v == btnstop){
            btnstart.setEnabled(true);
            btnstop.setEnabled(false);

            mr.stop();
            mr.release();
            mr = null;

            add_recording_to_media_library();
        }
    }

    private void add_recording_to_media_library() {
        ContentValues cv = new ContentValues(5);
        cv.put(MediaStore.Audio.Media.TITLE,"audio"+"myaudio.3gp");

        long milsec = System.currentTimeMillis();

        cv.put(MediaStore.Audio.Media.DATE_ADDED,(int)(milsec/1000));
        cv.put(MediaStore.Audio.Media.MIME_TYPE,"audio/3gpp");
        cv.put(MediaStore.Audio.Media.RELATIVE_PATH,afp);
        cv.put(MediaStore.Audio.Media.DISPLAY_NAME,"audio123");
        cv.put(MediaStore.Audio.Media.DATA, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/myaudio.3gp");

        ContentResolver cr = getContentResolver();

        //Uri base = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Uri base = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            base = MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL);
        }else{
            base = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        Uri newuri = cr.insert(base, cv);

        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, newuri));
        Toast.makeText(this, "Recording has been to "+ newuri, Toast.LENGTH_LONG).show();

    }
}
