package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class External_Storage_Example extends AppCompatActivity implements View.OnClickListener {
    EditText edfname,eddate;

    Button button1,button2;
    @SuppressLint("MissingSuperCall")
    public void onBackPressed() {
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_storage_example);
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_VIDEO},1);
        edfname = findViewById(R.id.ed_file);
        eddate = findViewById(R.id.ed_data);

        button1 = findViewById(R.id.btn_save);
        button2 = findViewById(R.id.btn_read);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == button1){
            String fname,data;
            fname = edfname.getText().toString();
            data = eddate.getText().toString();
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath()+"/"+fname);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                osw.write(data);
                osw.close();
                fos.close();

                Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(v == button2){
            String fname = edfname.getText().toString();
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath()+"/"+fname);
            StringBuffer sb =new StringBuffer();
            String temp = "";
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
                while ((temp = br1.readLine())!=null){
                    sb.append(temp);
                }
                br1.close();
                fis.close();
                Toast.makeText(this, ""+sb.toString(), Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
