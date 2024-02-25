package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First_Activity_Example extends AppCompatActivity implements View.OnClickListener {
    Button btn1;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

            Intent i = new Intent(First_Activity_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_example);
        btn1 = findViewById(R.id.btnexp);

        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btn1)
        {
            Intent i = new Intent(First_Activity_Example.this,Second_Activity_Example.class);
            i.putExtra( "Name", "Shivam" );
            i.putExtra("Age", "25");
            startActivity(i);
        }
    }
}
