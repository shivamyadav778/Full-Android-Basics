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

public class For_Loop_Example extends AppCompatActivity implements View.OnClickListener {
    EditText fortxt;

    Button btnfor, btnfor1,btnfor2,btnfor3,btnfor4,btnfor5,btnfor6;
    TextView txtfor;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(For_Loop_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_loop_example);
        fortxt = (EditText) findViewById(R.id.editText_for);
        btnfor2 = (Button) findViewById(R.id.btn_odd);
        btnfor = (Button) findViewById(R.id.btn_for);
        btnfor1 = (Button) findViewById(R.id.btnfor1);
        btnfor3 = (Button) findViewById(R.id.btn_even);
        btnfor4 = (Button) findViewById(R.id.btn_sum);
        btnfor5 = (Button) findViewById(R.id.btn_fact);
        btnfor6 = (Button) findViewById(R.id.btn_multi);
        txtfor = (TextView) findViewById(R.id.txtview_for);


        btnfor.setOnClickListener(this);
        btnfor1.setOnClickListener(this);
        btnfor2.setOnClickListener(this);
        btnfor3.setOnClickListener(this);
        btnfor4.setOnClickListener(this);
        btnfor5.setOnClickListener(this);
        btnfor6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if( v == btnfor)
        {
            int i,a;
            a = Integer.parseInt(fortxt.getText().toString());
            txtfor.setText("");
            for (i=1;i<=a;i++)
            {
                txtfor.append("Itech Classes \n");
            }
        }
        if( v == btnfor1)
        {
            int i,j;
            j = Integer.parseInt(fortxt.getText().toString());
            txtfor.setText("");
            for(i=1;i<=j;i++)
            {
                txtfor.append(i+"\n");
            }
        }
        if ( v == btnfor2)
        {
            int i,j;
            j = Integer.parseInt(fortxt.getText().toString());
            txtfor.setText("");
            for(i=1;i<=j;i+=2)
            {
                txtfor.append(i+"\n");
            }
        }
        if( v== btnfor3)
        {
            int i,j;
            j = Integer.parseInt(fortxt.getText().toString());
            txtfor.setText("");
            for (i=2;i<=j;i+=2)
            {
             txtfor.append(i+ "\n");
            }
        }
        if(v == btnfor4)
        {
            int i,j,s=0;
            j = Integer.parseInt(fortxt.getText().toString());
            txtfor.setText("");
            for(i=1;i<=j;i++)
            {
                s = s + i;
            }
            txtfor.append(s+"\n");

        }

        if(v == btnfor5)
        {
            int i,j,f=1;
            j = Integer.parseInt(fortxt.getText().toString());
            txtfor.setText("");
            for(i=1;i<=j;i++)
            {
                f = f * i;
            }

            txtfor.append(f+"\n");
        }
        if(v == btnfor6)
        {
            int i,j,k=0;
            j = Integer.parseInt(fortxt.getText().toString());
            txtfor.setText("");
            for (i=1;i<=10;i++)
            {

                txtfor.append(j+ " x " + i + " = "+j*i+"\n");
            }
        }
    }
}
