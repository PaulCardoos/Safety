package com.example.recyclergridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class SendMessage extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private String phoneNumber;
    private String name;
    private String message;
    private Button sendSMS;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
       if (ContextCompat.checkSelfPermission(this,
               Manifest.permission.SEND_SMS)
               != PackageManager.PERMISSION_GRANTED) {
           if (ActivityCompat.shouldShowRequestPermissionRationale(SendMessage.this,
                   Manifest.permission.SEND_SMS)) {
           } else {
               ActivityCompat.requestPermissions(SendMessage.this,
                       new String[]{Manifest.permission.SEND_SMS},
                       MY_PERMISSIONS_REQUEST_SEND_SMS);
           }
       }

       sendSMS = findViewById(R.id.button2);
       sendSMS.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (ContextCompat.checkSelfPermission(SendMessage.this,
                       Manifest.permission.SEND_SMS)
                       != PackageManager.PERMISSION_GRANTED) {
                   if (ActivityCompat.shouldShowRequestPermissionRationale(SendMessage.this,
                           Manifest.permission.SEND_SMS)) {
                   } else {
                       ActivityCompat.requestPermissions(SendMessage.this,
                               new String[]{Manifest.permission.SEND_SMS},
                               MY_PERMISSIONS_REQUEST_SEND_SMS);
                   }
               }
           }
       });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("7813630169", null, "HELLLPPP", null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }
}