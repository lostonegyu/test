package com.example.capstone_design;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class SMS_authentication extends AppCompatActivity {

    EditText phone, Auth_number;
    Button Shipment_btn, Auth_btn;

    static final int SMS_SEND_PERMISSON = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s_authentication);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        phone = findViewById(R.id.phone);
        Shipment_btn = findViewById(R.id.Shipment_btn);

        /***
         * 문자 보내기 권한 설정
         */
        int permissonCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissonCheck != PackageManager.PERMISSION_GRANTED) {

            //문자 보내기 권한 거부
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

                Toast.makeText(getApplicationContext(), "SMS 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
            }
            // 문자 보내기 권한 허용
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SMS_SEND_PERMISSON);
        }

        // 클릭 이벤트 기능
        Shipment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭시 발생하는 이벤트
                sendSMS(phone.getText().toString(), "메시지 전송 테스트");
            }
        });
    }

    /***
     * SMS 발송 기능
     *
     * @param phoneNumber
     * @param message
     *
     */
    private void sendSMS (String phoneNumber, String message){
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, SMS_authentication.class), 0);
        SmsManager sms = SmsManager.getDefault();

        sms.sendTextMessage(phoneNumber, null, message, pi, null);

        Toast.makeText(getBaseContext(), "메시지가 전송 되었습니다.", Toast.LENGTH_SHORT).show();
    }
}