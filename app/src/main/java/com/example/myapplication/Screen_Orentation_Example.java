package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.Inet4Address;

public class Screen_Orentation_Example extends AppCompatActivity {
    EditText edtext;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Screen_Orentation_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_orentation_example);
        edtext = (EditText) findViewById(R.id.editText_Text);

    }

    public void OnClick(View V)
    {
        String text; 
        text = edtext.getText().toString().trim();
        Toast.makeText(this, "Hello "+text, Toast.LENGTH_SHORT).show();
    }

}
