package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Toggle_Layout_Example extends AppCompatActivity implements View.OnClickListener {
    ToggleButton tb1,tb2;
    Button btn1;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
            Intent i = new Intent(Toggle_Layout_Example.this, Main_menu.class);
            startActivity(i);
            finish();
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_layout_example);

        tb1 = (ToggleButton) findViewById(R.id.toggleButton_1);
        tb2 = (ToggleButton) findViewById(R.id.toggleButton_2);
        btn1 = (Button) findViewById(R.id.button2);
        
        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean a) 
            {
                if (a)
                {
                    Toast.makeText(Toggle_Layout_Example.this, "Toggle button 1 is On", Toast.LENGTH_SHORT).show();    
                }
                else
                {
                    Toast.makeText(Toggle_Layout_Example.this, "Toggle Button 1 is Off", Toast.LENGTH_SHORT).show();
                }
            }
            
        });
        
        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
            {
                if(isChecked)
                {
                    Toast.makeText(Toggle_Layout_Example.this, "Toggle Button 2 is On ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Toggle_Layout_Example.this, "Toggle Button 2 is Off", Toast.LENGTH_SHORT).show();    
                }
            }
        });
                
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == btn1)
        {
            StringBuilder st = new StringBuilder();
            st.append("Toggle Button 1 = ").append(tb1.getText());
            st.append("\nToggle Button 2 = ").append(tb2.getText());
            Toast.makeText(this, st.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
