package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Phone_Call_Example extends AppCompatActivity implements View.OnClickListener {
    EditText edno;
    Button btncall;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_example);

        edno = findViewById(R.id.ed_call_no);

        btncall = findViewById(R.id.btn_call_call);

        btncall.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v == btncall){

            String mno = edno.getText().toString().trim();
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel: "+ mno));
            startActivity(i);

        }

    }
}
