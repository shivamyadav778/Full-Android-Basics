package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First_Activity1_Example extends AppCompatActivity implements View.OnClickListener {
    TextView tx1;
    Button btn1,btn2;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

            Intent i = new Intent(First_Activity1_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity1_example);
        tx1 = findViewById(R.id.textView11);
        btn1 = findViewById(R.id.button5);
        btn2 = findViewById(R.id.button7);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btn1)
        {
            Intent i = new Intent(First_Activity1_Example.this, Second_Activity2_Example.class);
            startActivityForResult(i,2001);


        }
        if (v == btn2)
        {
            Intent j = new Intent(First_Activity1_Example.this, Main_menu.class);
            startActivity(j);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2001)
        {
            String msg = data.getStringExtra( "Message");
            tx1.setText(msg);
        }
    }
}
