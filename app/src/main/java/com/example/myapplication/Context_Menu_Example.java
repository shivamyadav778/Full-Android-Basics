package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Context_Menu_Example extends AppCompatActivity {
    String name[] = {"Option1","Option2","Option3","Option4","Option5"};
    ListView lstview1;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu_example);
        lstview1 = findViewById(R.id.lst1);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1,name);
        lstview1.setAdapter(aa);

        registerForContextMenu(lstview1);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Menu");
        menu.add(0,v.getId(),0,"1");
        menu.add(0,v.getId(),0,"2");
        menu.add(0,v.getId(),0,"3");
        menu.add(0,v.getId(),0,"4");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().equals("1"))
        {
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle().equals("2"))
        {
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle().equals("3"))
        {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle().equals("4"))
        {
            Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
        }
        else
        {
            return false;
        }
        return true;
    }
}
