package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.InetAddresses;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Implicit_Intent_Example extends AppCompatActivity implements View.OnClickListener {

    EditText edturl;
    Button btngo;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Implicit_Intent_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent_example);

        edturl = findViewById(R.id.edtxturl);
        btngo = findViewById(R.id.btngo);

        btngo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btngo)
        {
            String a = "https://"+edturl.getText().toString();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(a));
            startActivity(i);
        }
    }
}
