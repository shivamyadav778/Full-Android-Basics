package com.example.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sms_Example extends AppCompatActivity implements View.OnClickListener {
    EditText edmno,edmsg;
    Button btnsend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_example);

        edmno = findViewById(R.id.ed_sms_mno);
        edmsg = findViewById(R.id.ed_sms_msg);

        btnsend = findViewById(R.id.btn_sms_send);

        btnsend.setOnClickListener(this);
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

        if(v == btnsend){

            String mno = edmno.getText().toString().trim();
            String msg = edmsg.getText().toString().trim();

            Intent i = new Intent(this, Sms_Example.class);
            PendingIntent pm = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_IMMUTABLE);

            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(mno,null,msg,pm,null);
            Toast.makeText(this, "Message Delivered Successfully", Toast.LENGTH_SHORT).show();
        }

    }
}
