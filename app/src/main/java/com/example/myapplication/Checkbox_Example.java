package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.LruCacheKt;

public class Checkbox_Example extends AppCompatActivity implements View.OnClickListener {
    CheckBox Check_pizza,Check_burger,Check_coffee;
    Button btn_bill;
    TextView Text_bill;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Checkbox_Example.this, Main_menu.class);
        startActivity(i);
        finish();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_example);

        Check_pizza = (CheckBox) findViewById(R.id.checkBox_Pizza);
        Check_burger = (CheckBox) findViewById(R.id.checkBox_Burger);
        Check_coffee = (CheckBox) findViewById(R.id.checkBox_coffee);

        btn_bill = (Button) findViewById(R.id.button_bill);

        Text_bill = (TextView) findViewById(R.id.textview_bill);

        btn_bill.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
         if(v == btn_bill)
         {
             StringBuilder sp = new StringBuilder();
             int total=0;
             sp.append("\t\t\t\t\t\t\t\tBill");
             sp.append("\n---------------------------------------");
             if(Check_pizza.isChecked())
             {
                 sp.append("\nPizza : Rs.150/-");
                 total = total  + 150;
             }
             if(Check_burger.isChecked())
             {
                 sp.append("\nBurger : Rs.100/-");
                 total = total + 100;
             }
             if(Check_coffee.isChecked())
             {
                 sp.append("\nCoffee : Rs.50/- ");
                 total = total + 50;
             }
             sp.append("\n---------------------------------------");
             sp.append("\nYour total bill is Rs." + total);
             sp.append("\n---------------------------------------");
             Text_bill.setText(sp.toString());
         }

    }
}
