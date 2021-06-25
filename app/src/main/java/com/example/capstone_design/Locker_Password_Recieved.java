package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Locker_Password_Recieved extends AppCompatActivity {

    Button buttonVertify,buttonDenied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locker__password__recieved);

        buttonVertify = findViewById(R.id.buttonVertify);
        buttonVertify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vertify = new Intent(Locker_Password_Recieved.this,MainActivity.class);
                startActivity(intent_vertify);
            }
        });

        buttonDenied = findViewById(R.id.buttonDenied);
        buttonDenied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_denied = new Intent(Locker_Password_Recieved.this,Locker_Password.class);
                startActivity(intent_denied);
            }
        });


    }
}