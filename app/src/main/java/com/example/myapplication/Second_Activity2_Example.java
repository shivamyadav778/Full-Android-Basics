package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second_Activity2_Example extends AppCompatActivity implements View.OnClickListener {
    EditText ed1;
    Button bt1;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Second_Activity2_Example.this, First_Activity1_Example.class);
            startActivity(i);
            finish();
        }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity2_example);

        ed1 = findViewById(R.id.editTextText);
        bt1 = findViewById(R.id.btn8);

        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == bt1)
        {
            String msg = ed1.getText().toString();
            Intent i = new Intent();
            i.putExtra("Message", msg);
            setResult( 2001,i);
            finish();
        }
    }
}
