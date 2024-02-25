package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class TTS_Example extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    EditText ttsmsg;
    Button btnspeak;
    TextToSpeech tts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tts_example);

        ttsmsg = findViewById(R.id.pt_tts_msg);

        btnspeak = findViewById(R.id.btn_tts_speak);

        tts = new TextToSpeech(this,this);

        btnspeak.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnspeak){
            startspeak();
        }
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.US);
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Language Not Supported", Toast.LENGTH_SHORT).show();
            }else{
                startspeak();
            }
        }else{
            Toast.makeText(this, "Initialization Fail", Toast.LENGTH_SHORT).show();
        }

    }

    private void startspeak() {
        String msg = ttsmsg.getText().toString();
        tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent( this, Main_menu.class);
        startActivity(i);
        finish();

    }

}
