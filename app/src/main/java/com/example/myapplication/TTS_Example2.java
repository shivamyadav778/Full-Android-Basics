package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TTS_Example2 extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText edmsg,edpitch;
    Button btnsubmit;
    Spinner sp1;
    String speed;
    TextToSpeech tts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tts_example2);

        edmsg = findViewById(R.id.ed_tts2_msg);
        edpitch = findViewById(R.id.ed_tts2_pitch);

        tts = new TextToSpeech(this,this);

        btnsubmit = findViewById(R.id.btn_tts2_speak);

        sp1 = findViewById(R.id.spinner_tts_speed);

        btnsubmit.setOnClickListener(this);

        sp1.setOnItemSelectedListener(this);

       loadspinnerdata();




    }

    private void loadspinnerdata() {
        List<String> list = new ArrayList<String>();
        list.add("Very Slow");
        list.add("Slow");
        list.add("Normal");
        list.add("Fast");
        list.add("Very Fast");

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,list);
        sp1.setAdapter(aa);
    }

    @Override
    public void onClick(View v) {
        setspeed();
        speakout();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();
    }

    private void setspeed() {
        if(speed.equals("Very Slow")){
            tts.setSpeechRate(0.1f);
        } else if (speed.equals("Slow")) {
            tts.setSpeechRate(0.5f);
        } else if (speed.equals("Normal")) {
            tts.setSpeechRate(1.0f);      //Default Value.
        } else if (speed.equals("Fast")) {
            tts.setSpeechRate(1.5f);
        } else if (speed.equals("Very Fast")) {
            tts.setSpeechRate(2.0f);
        }

        float pitch = Float.parseFloat(edpitch.getText().toString());
        tts.setPitch(pitch);
    }

    private void speakout() {

        String msg = edmsg.getText().toString();
        tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.US);
            if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Toast.makeText(this, "Language Not Supported", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Intialization Fail", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        speed = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Speed" + speed, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
