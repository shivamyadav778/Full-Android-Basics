package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second_Activity_Example extends AppCompatActivity implements View.OnClickListener {
    Button btn2;
    TextView txt;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Second_Activity_Example.this, First_Activity_Example.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_example);
        Bundle b = getIntent().getExtras();
        String n = b.getString("Name");
        String m = b.getString("Age");
        btn2 = findViewById(R.id.btnexp1);
        txt = findViewById(R.id.textView8);
        txt.setText("Name: "+ n +"\n Age: "+m);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn2)
        {
            Intent i = new Intent(Second_Activity_Example.this,First_Activity_Example.class);
            startActivity(i);
        }
    }
}
