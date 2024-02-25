package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Progress_Bar_Example extends AppCompatActivity implements View.OnClickListener {
    Button btndown;
    ProgressDialog pb1;

    int status = 0;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Progress_Bar_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progess_bar_example);

        btndown = findViewById(R.id.btn_down);

        btndown.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v == btndown)
        {
            status=0;
            pb1 = new ProgressDialog(this);
            pb1.setMessage("Downloading...");
            pb1.setCancelable(true);
            pb1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pb1.setProgress(0);
            pb1.setMax(100);
            pb1.show();

            new Thread(new Runnable(){

                @Override
                public void run() {
                    while (status < 100) {
                        status = status + 5;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        pb1.setProgress(status);

                    }
                    if (status >= 100)
                    {

                        pb1.dismiss();
                    }
                }
            }).start();
        }
    }
}
