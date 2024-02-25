package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Email_Example extends AppCompatActivity implements View.OnClickListener {
    EditText edmsg,edmail,edsub;
    Button btnsend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_example);

        edmsg = findViewById(R.id.ed_email_text);
        edsub = findViewById(R.id.ed_email_sub);
        edmail = findViewById(R.id.ed_email_add);

        btnsend = findViewById(R.id.btn_email_send);

        btnsend.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnsend){
            String to = edmail.getText().toString().trim();
            String sub = edsub.getText().toString().trim();
            String text = edmsg.getText().toString().trim();

            Intent i = new Intent(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
            i.putExtra(Intent.EXTRA_SUBJECT,sub);
            i.putExtra(Intent.EXTRA_TEXT,text);
            i.setType("message/rfc822");

            startActivity(Intent.createChooser(i,"Choose the app"));
        }
    }
}
