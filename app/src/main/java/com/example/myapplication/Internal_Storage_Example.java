package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Internal_Storage_Example extends AppCompatActivity implements View.OnClickListener {
    EditText edfname,eddate;

    Button button1,button2;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_storage_example);
        edfname = findViewById(R.id.ed_file);
        eddate = findViewById(R.id.ed_data);

        button1 = findViewById(R.id.btn_save);
        button2 = findViewById(R.id.btn_read);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == button1)
        {
            String fname,data;
            fname = edfname.getText().toString();
            data = eddate.getText().toString();

            FileOutputStream fos;

            try {
                fos = openFileOutput(fname, Context.MODE_PRIVATE);

                fos.write(data.getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
        }
        if(v == button2)
        {
            String fname = edfname.getText().toString();
            StringBuffer sb =new StringBuffer();
            String temp = "";

            try {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(openFileInput(fname)));

                while((temp = br1.readLine()) != null){
                    sb.append(temp);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(this, " "+ sb.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
