package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Date_Picker_Example extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    Button btsub;
    TextView txtres;
    DatePickerDialog.OnDateSetListener Date;
    Calendar cal = Calendar.getInstance();

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Date_Picker_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker_example);
        Date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updatedtext();
            }
        };
        ed1 = (EditText) findViewById(R.id.edtDP);
        btsub = (Button) findViewById(R.id.btn_save);
        txtres = (TextView) findViewById(R.id.text_res);

        ed1.setOnClickListener(this);
        btsub.setOnClickListener(this);

    }

    private void updatedtext() {
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        ed1.setText(sdf.format(cal.getTime()));
    }

    @Override
    public void onClick(View v) {
        if(v == ed1)
        {
            new DatePickerDialog(this,Date,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show();
        }

        if(v == btsub)
        {
            txtres.setText(ed1.getText().toString());
        }

    }
}
