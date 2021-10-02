package com.example.capstone_design;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Terms_of_service extends AppCompatActivity {

    Button btn_Cancellation,btn_Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_service);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btn_Cancellation  =findViewById(R.id.tos_btn_cancellation);
        btn_Cancellation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_cancellation = new Intent(Terms_of_service.this,LoginActivity.class);
                intent_cancellation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_cancellation);
            }
        });

        btn_Check = findViewById(R.id.tos_btn_check);
        btn_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_ckeck = new Intent(Terms_of_service.this,SMS_authentication.class);
                startActivity(intent_ckeck);
            }
        });
    }
}