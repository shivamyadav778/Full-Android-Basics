package com.example.myapplication;

import static com.example.myapplication.R.*;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Main_menu extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_ADMIN,
                Manifest.permission.BLUETOOTH_CONNECT,
                Manifest.permission.BLUETOOTH,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA},1);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int d = item.getItemId();
        if (d == R.id.actv_example) {
            Intent i = new Intent(Main_menu.this, Actv_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == R.id.area_of_square) {
            Intent i = new Intent(Main_menu.this, Area_Square_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == R.id.arithmetics_example) {
            Intent i = new Intent(Main_menu.this, Arithmetic_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.progress_bar_example) {
            Intent i = new Intent(Main_menu.this, Progress_Bar_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.rating_bar_example) {
            Intent i = new Intent(Main_menu.this, Rating_Bar_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.seek_bar_example) {
            Intent i = new Intent(Main_menu.this, SeekBar_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.checkbox_example) {
            Intent i = new Intent(Main_menu.this, Checkbox_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.contextmenu) {
            Intent i = new Intent(Main_menu.this,Context_Menu_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.datepicker_example1) {
            Intent i = new Intent(Main_menu.this, DatePicker_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.datepicker_example2) {
            Intent i = new Intent(Main_menu.this, Date_Picker_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.implicit_intent_example) {
            Intent i = new Intent(Main_menu.this, Implicit_Intent_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.explicit_example) {
            Intent i = new Intent(Main_menu.this, First_Activity_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.if_condition_example) {
            Intent i = new Intent(Main_menu.this, If_Condition_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.internalstorageexample) {
            Intent i = new Intent(Main_menu.this, Internal_Storage_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.for_loop_example) {
            Intent i = new Intent(Main_menu.this,For_Loop_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.while_loop_example) {
            Intent i = new Intent(Main_menu.this,While_Loop_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.switch_layout) {
            Intent i = new Intent(Main_menu.this, Switch_Layout_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.toggle_layout) {
            Intent i = new Intent(Main_menu.this, Toggle_Layout_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.activity_main) {
            Intent i = new Intent(Main_menu.this, MainActivity.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.externalstorage) {
            Intent i = new Intent(this, External_Storage_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.screen_orientation_example) {
            Intent i = new Intent(Main_menu.this, Screen_Orentation_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.spinner_example) {
            Intent i = new Intent(Main_menu.this, Spinner_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d ==id.startactivity_for_result) {
            Intent i = new Intent(Main_menu.this, First_Activity1_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.time_picker_example) {
            Intent i = new Intent(Main_menu.this,Time_Picker_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.popmenu) {
            Intent i = new Intent( this, Popup_Menu_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.dbexample) {
            Intent i = new Intent(this, Db_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.service) {
            Intent i = new Intent(this, Service_Example.class);
            startActivity(i);
            finish();
            return true;
        }else if(d == id.mediaplayer){
            Intent i = new Intent(this, Mediaplayer_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.mediaplayer2) {
            Intent i = new Intent(this,Mediaplayer_Example2.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.videoview) {
            Intent i = new Intent(this, Videoview_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.recorder) {
            Intent i = new Intent(this, Audiorecorder_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.tts) {
            Intent i = new Intent(this, TTS_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.tts2) {
            Intent i = new Intent(this,TTS_Example2.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.call) {
            Intent i = new Intent(this, Phone_Call_Example.class);
            startActivity(i);
            finish();
            return true;

        } else if (d == id.sms) {

            Intent i = new Intent(this, Sms_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.email) {

            Intent i = new Intent(this, Email_Example.class);
            startActivity(i);
            finish();
            return true;
        }else if (d == id.blue1){

            Intent i = new Intent(this, Bluetooth_Example.class);
            startActivity(i);
            finish();
            return true;
        }else if(d == id.wifi){

            Intent i = new Intent(this, Wifi_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.cam) {
            Intent i = new Intent(this, Camera_Example.class);
            startActivity(i);
            finish();
            return true;
        } else if (d == id.blue2) {
            Intent i = new Intent(this,Bluetooth_Example2.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        AlertDialog.Builder ad = new AlertDialog.Builder(Main_menu.this);
        ad.setMessage("Do you want to exit?");
        ad.setTitle("Alert!!!");
        ad.setCancelable(false);
        ad.setPositiveButton("Yes",(DialogInterface.OnClickListener) (dialog, which) -> finish());
        ad.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog,which)-> dialog.cancel());
        AlertDialog alertDialog = ad.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.main_menu,menu);
        return true;
    }
}

