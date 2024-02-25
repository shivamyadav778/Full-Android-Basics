package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Db_Record_Example extends AppCompatActivity implements View.OnClickListener {
    EditText e_id,e_name,e_add;
    Button b_pre,b_update,b_next,b_del;
    SQLiteDatabase db;
    String name,id,add;
    Cursor c;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i =new Intent(this, Db_Example.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de_record_example);

        e_id = findViewById(R.id.ed_id);
        e_name = findViewById(R.id.ed_name);
        e_add = findViewById(R.id.ed_add);

        b_pre = findViewById(R.id.btn_pre);
        b_update = findViewById(R.id.btn_update);
        b_next = findViewById(R.id.btn_next);
        b_del = findViewById(R.id.btn_del);

        opendatabase();




       b_pre.setOnClickListener(this);
       b_update.setOnClickListener(this);
       b_next.setOnClickListener(this);
       b_del.setOnClickListener(this);

        c = db.rawQuery("select * from persons",null);
        if(c.getCount() != 0){
            c.moveToFirst();
            ShowRecord();
        }
    }

    private void ShowRecord() {

        id = c.getString(0);
        name = c.getString(1);
        add = c.getString(2);

        e_id.setText(id);
        e_name.setText(name);
        e_add.setText(add);
    }

    private void opendatabase() {
        db = openOrCreateDatabase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/PersonDB", Context.MODE_PRIVATE,null);
    }

    @Override
    public void onClick(View v) {
        if(v == b_pre){
            if(!c.isFirst()){
                c.moveToPrevious();
            }
            ShowRecord();
        }
        if(v == b_update){
            id = e_id.getText().toString();
            name = e_name.getText().toString();
            add = e_add.getText().toString();
            if(id.equals("") || name.equals("") || add.equals(""))
            {
                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();
            }else{
                String query = "update persons set pname = '"+name+"',address = '"+add+"' where id = "+id;
                try{
                    db.execSQL(query);
                    Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                }catch(Exception ex){
                    Toast.makeText(this, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                c = db.rawQuery("select * from persons",null);
                if(c.getCount() != 0){
                    c.moveToFirst();
                    ShowRecord();
                }
            }
        }
        if(v == b_next){
            if(!c.isLast()){
                c.moveToNext();
            }
            ShowRecord();
        }
        if(v == b_del){
            id = e_id.getText().toString();
            if(id.equals("")){
                Toast.makeText(this, "Please Select the id", Toast.LENGTH_SHORT).show();
            }else{
                String query = "delete from persons where id="+id;
                try{
                    db.execSQL(query);
                    Toast.makeText(this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Toast.makeText(this, ""+ ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                c = db.rawQuery("select * from persons",null);
                if(c.getCount() != 0){
                    c.moveToNext();
                    ShowRecord();
                }else{
                    e_id.setText("");
                    e_name.setText("");
                    e_add.setText("");
                }
            }
        }
    }
}
