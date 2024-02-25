package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Arithmetic_Example extends AppCompatActivity {
    EditText num1,num2;
    Button but1,but2,but3,but4,but5;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Arithmetic_Example.this, Main_menu.class);
            startActivity(i);
            finish();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arithmetic_example);
        num1 = (EditText) findViewById(R.id.editText_1);
        num2 = (EditText) findViewById(R.id.editText_2);
        but1 = (Button) findViewById(R.id.add);
        but2 = (Button) findViewById(R.id.sub);
        but3 = (Button) findViewById(R.id.div);
        but4 = (Button) findViewById(R.id.mul);
        but5 = (Button) findViewById(R.id.button6);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a,b,c;
                a = Integer.parseInt(num1.getText().toString().trim());
                b = Integer.parseInt(num2.getText().toString().trim());
                c = a + b ;
                Toast.makeText(Arithmetic_Example.this, "Your Addition is "+ c, Toast.LENGTH_SHORT).show();


            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a,b,c;
                a = Integer.parseInt(num1.getText().toString().trim());
                b = Integer.parseInt(num2.getText().toString().trim());
                c = a - b;
                Toast.makeText(Arithmetic_Example.this, "Your Subtraction is "+ c, Toast.LENGTH_SHORT).show();
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a,b,c;
                a = Integer.parseInt(num1.getText().toString().trim());
                b = Integer.parseInt(num2.getText().toString().trim());
                c = a / b;
                Toast.makeText(Arithmetic_Example.this, "Your Division is "+ c, Toast.LENGTH_SHORT).show();
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a,b,c;
                a = Integer.parseInt(num1.getText().toString().trim());
                b = Integer.parseInt(num2.getText().toString().trim());
                c = a * b;
                Toast.makeText(Arithmetic_Example.this, "Your Multiplication is " + c, Toast.LENGTH_SHORT).show();


            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Arithmetic_Example.this,Screen_Orentation_Example.class);
                startActivity(i);
            }
        });
    }
}
