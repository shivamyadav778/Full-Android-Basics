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

public class If_Condition_Example extends AppCompatActivity implements View.OnClickListener {

    EditText iftxt1,minmaxtxt,maxlogical;
    Button ifbtn1, ifbtn2, minmaxbtn,minmaxeqbtn,pnebtn,maxlogicbtn,maxnestif;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i =new Intent(If_Condition_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.if_condition_example);

        iftxt1 = (EditText) findViewById(R.id.if1);
        minmaxtxt = (EditText) findViewById(R.id.minmaxtxt);
        maxlogical = (EditText) findViewById(R.id.txtbox1);
        ifbtn1 = (Button) findViewById(R.id.if1btn);
        ifbtn2 = (Button) findViewById(R.id.button_oddeven);
        minmaxbtn = (Button) findViewById(R.id.button_minmax);
        minmaxeqbtn = (Button)  findViewById(R.id.button_minmax_eq);
        pnebtn = (Button) findViewById(R.id.Pos_neg_zero);
        maxlogicbtn = (Button) findViewById(R.id.max_log);
        maxnestif = (Button) findViewById(R.id.nestedifbtn);

        ifbtn1.setOnClickListener(this);
        ifbtn2.setOnClickListener(this);
        minmaxbtn.setOnClickListener(this);
        minmaxeqbtn.setOnClickListener(this);
        pnebtn.setOnClickListener(this);
        maxlogicbtn.setOnClickListener(this);
        maxnestif.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == ifbtn1) {
            int i;
            i = Integer.parseInt(iftxt1.getText().toString().trim());
            if (i > 10) {
                Toast.makeText(this, "Your number is greater than 10", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "End of If Statement", Toast.LENGTH_SHORT).show();
        }

        if (v == ifbtn2)
        {
            int i;
            i = Integer.parseInt(iftxt1.getText().toString().trim());
            if (i % 2 == 0) {
                Toast.makeText(this, "Your Number is Even", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Your Number is Odd", Toast.LENGTH_SHORT).show();
            }
        }

        if (v == minmaxbtn)
        {
            int i, j;
            i = Integer.parseInt(iftxt1.getText().toString().trim());
            j = Integer.parseInt(minmaxtxt.getText().toString().trim());
            if (i > j) {
                Toast.makeText(this, " Maximum number is " + i, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Maximum number is " + j, Toast.LENGTH_SHORT).show();
            }
        }

        if (v == minmaxeqbtn)
        {
            int i,j;
            i = Integer.parseInt(iftxt1.getText().toString().trim());
            j = Integer.parseInt(minmaxtxt.getText().toString().trim());
            if(i>j)
            {
                Toast.makeText(this, "Maximum number is " + i, Toast.LENGTH_SHORT).show();
            } else if (i<j)
            {
                Toast.makeText(this, "Maximum number is " + j, Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Both numbers are Equal", Toast.LENGTH_SHORT).show();
            }

        }

        if (v == pnebtn) {
            int i;
            i = Integer.parseInt(iftxt1.getText().toString().trim());
            if (i > 0) {
                Toast.makeText(this, "Your number is Positive", Toast.LENGTH_SHORT).show();
            } else if (i < 0) {
                Toast.makeText(this, "Your number is Negative", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Your is number is equal to Zero", Toast.LENGTH_SHORT).show();
            }
        }

        if (v == maxlogicbtn)
        {
            int i,j,k;
            i = Integer.parseInt(iftxt1.getText().toString().trim());
            j = Integer.parseInt(minmaxtxt.getText().toString().trim());
            k = Integer.parseInt(maxlogical.getText().toString().trim());
            if(i>j && i>k)
            {
                Toast.makeText(this, "Maximum number is " + i, Toast.LENGTH_SHORT).show();
            }
            else if (j>i && j>k)
            {
                Toast.makeText(this, "Maximum number is " + j, Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Maximum number is " + k, Toast.LENGTH_SHORT).show();
            }

        }


        if(v == maxnestif)
        {
            int i , j, k;
            i = Integer.parseInt(iftxt1.getText().toString().trim());
            j = Integer.parseInt(minmaxtxt.getText().toString().trim());
            k = Integer.parseInt(maxlogical.getText().toString().trim());
            if(i>j)
            {
                if(i>k)
                {
                    Toast.makeText(this, "Maxmium number is " + i, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Maxmium number is " + k, Toast.LENGTH_SHORT).show();
                }
            }
            if(j>i)
            {
                if(j>k)
                {
                    Toast.makeText(this, "Maxmium number is " + j, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Maximum number is " + k, Toast.LENGTH_SHORT).show();
                }
            }
            if(k > i)
            {
                if(k>j)
                {
                    Toast.makeText(this, "Maximum number is " + k, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this , "Maximum numbe is " + j, Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}