package com.example.myapplication;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Set;

public class Bluetooth_Example2 extends AppCompatActivity {
    TextView tx_view;
    BluetoothAdapter ba;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_example2);

        tx_view = findViewById(R.id.txt_blu2_view);

        ba = BluetoothAdapter.getDefaultAdapter();
        tx_view.setText("Paired Dev ices List");
        checkbluetoothstate();
    }

    private void checkbluetoothstate() {
        if (ba == null) {
            Toast.makeText(this, "Bluetooth Not Supported For This Device", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (ba.isEnabled()) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_DENIED) {
                    return;
                }
                Set<BluetoothDevice> devices = ba.getBondedDevices();
                for (BluetoothDevice device : devices) {
                    tx_view.append("\n Device: " + device.getName() + "," + device);
                }
            } else {
                Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(i, 1);

            }

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, Main_menu.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            checkbluetoothstate();
    }

}
}
