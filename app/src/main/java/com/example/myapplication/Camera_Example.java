package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Camera_Example extends AppCompatActivity implements View.OnClickListener {
    Button btncap;
    ImageView Imgview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_example);

        btncap = findViewById(R.id.btn_cam_capture);
        Imgview = findViewById(R.id.imageView1);

        btncap.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == btncap) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, 5);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 5){
            try{

                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Imgview.setImageBitmap(photo);
            }catch(NullPointerException ex){
                Toast.makeText(this, "Please Capture a Image!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
        finish();
    }
}
