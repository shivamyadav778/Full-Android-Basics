package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class While_Loop_Example extends AppCompatActivity implements View.OnClickListener
{
    EditText et1;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    TextView txt1;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(While_Loop_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.while_loop_example);

        et1 = (EditText) findViewById(R.id.while_txt);
        btn1 = (Button) findViewById(R.id.btn_while1);
        btn2 = (Button) findViewById(R.id.btn_while2);
        btn3 = (Button) findViewById(R.id.btn_while3);
        btn4 = (Button) findViewById(R.id.btn_while4);
        btn5 = (Button) findViewById(R.id.btn_while5);
        btn6 = (Button) findViewById(R.id.btn_while6);
        btn7 = (Button) findViewById(R.id.btn_while7);
        txt1 = (TextView) findViewById(R.id.textView_while);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == btn1)
        {
            int i,j;
            j = Integer.parseInt(et1.getText().toString());
            txt1.setText("");
            i =  1 ;
            while(i <= j)
            {
                txt1.append("Hello Itech Classes\n" );
                i++;
            }
        }

        if (v == btn2)
        {
            int i,j;
            j = Integer.parseInt(et1.getText().toString());
            txt1.setText("");
            i = 1;
            while(i <= j)
            {
                txt1.append( i + "\n");
                i++;
            }
        }

        if (v == btn3 )
        {
            int i,j;
            j = Integer.parseInt(et1.getText().toString());
            i = 1;
            while( i <= j)
            {
                txt1.append(i + "\n");
                i+=2;
            }
        }
        if (v == btn4)
        {
            int i ,j;
            j = Integer.parseInt(et1.getText().toString());
            txt1.setText("");
            i = 0;
            while(i <= j)
            {
                txt1.append(i + "\n");
                i+=2;
            }
        }
        if (v == btn5)
        {
            int i,j,s=0;
            j = Integer.parseInt(et1.getText().toString());
            txt1.setText("");
            i = 1;
            while(i <= j)
            {
                s = s + i;
                i ++;
            }
            txt1.append(s + "\n");
        }

        if(v == btn6)
        {
            int i,j,f=1;
            j = Integer.parseInt(et1.getText().toString());
            txt1.setText("");
            i = 1;
            while( i <= j)
            {
                f = f * i;
                i++;
            }
            txt1.append( f + "\n");
        }

        if (v == btn7)
        {
            int i,j,t=1;
            j = Integer.parseInt(et1.getText().toString());
            txt1.setText("");
            i = 1;
            while (i <= 10)
            {
                t =  j * i ;
                txt1.append(j + " x " + i + " = " + t +"\n");

                i++;
            }
        }
    }
}
