package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class Db_Example extends AppCompatActivity implements View.OnClickListener {
    EditText edname,edaddress;
    Button btnsave,btnview;
    SQLiteDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_example);
        createDatabase();

        edname = findViewById(R.id.etdbname);
        edaddress = findViewById(R.id.et_dbtext);

        btnsave = findViewById(R.id.btn_dbsave);
        btnview = findViewById(R.id.btn_dbread);

        btnview.setOnClickListener(this);
        btnsave.setOnClickListener(this);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();
    }

    private void createDatabase() {
        db = openOrCreateDatabase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/PersonDB", Context.MODE_PRIVATE,null);
        db.execSQL("create table if not exists persons(id integer primary key autoincrement,pname varchar, address varchar);");
    }

    @Override
    public void onClick(View v) {
        if(v == btnsave)
        {
            String name = edname.getText().toString().trim();
            String add = edaddress.getText().toString().trim();

            if(name.equals("'") || add.equals("")){
                Toast.makeText(this, "Please enter proper values", Toast.LENGTH_SHORT).show();
            }else{
                String query = "insert into persons(pname,address) values('"+name+"','"+add+"')";
                try {
                    db.execSQL(query);
                    Toast.makeText(this, "Record Saved", Toast.LENGTH_SHORT).show();
                    edname.setText("");
                    edaddress.setText("");
                }catch(Exception ex){
                    Toast.makeText(this, "except: "+ex.getMessage(), Toast.LENGTH_SHORT).show();


                }
            }
        }
        if(v == btnview){
            Intent i = new Intent( this, Db_Record_Example.class);
            startActivity(i);
        }
    }
}
