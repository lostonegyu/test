package com.example.capstone_design;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
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

    //인증번호를 비교하기위해 쉐어드에 저장해줍시다.
    SharedPreferences pref = getPreferences(MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    String checkNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s_authentication);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        phone = findViewById(R.id.phone);
        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher()); //휴대전화 하이폰
        Shipment_btn = findViewById(R.id.Shipment_btn);

        Auth_number = findViewById(R.id.Auth_number);
        Auth_btn = findViewById(R.id.Auth_btn);

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
                checkNum = numberGen(4,1);

//                editor.putString("checkNum", checkNum);
                sendSMS(phone.getText().toString(), "인증번호 :" +checkNum);
            }
        });

        //인증번호 체크하는 버튼
        Auth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 입력한 인증번호와 저장된 인증번호 체크
//                if(pref.getString("checkNum","").equals(Auth_number.getText().toString())){
//                    Toast.makeText(getApplicationContext(),"인증 완료 되었습니다.", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getApplicationContext(),"인증번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
//                }
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
    /***
     * 인증번호 생성 가능
     * @param len : 생성할 난수의 길이
     * @param dupCd : 중복 허용 여부 (1: 중복허용, 2:중복제거)
     *
     */
    public static String numberGen(int len, int dupCd) {

        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수

        for(int i=0;i<len;i++) {

            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));

            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다.
                if(!numStr.contains(ran)){
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다.
                    i-=1;
                }
            }
        }
        return numStr;
    }
}