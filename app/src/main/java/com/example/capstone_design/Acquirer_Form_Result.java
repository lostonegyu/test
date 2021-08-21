package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Acquirer_Form_Result extends AppCompatActivity {


    Button pwd_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acquirer__form__result);

        pwd_btn = findViewById(R.id.pwd_btn);
        pwd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_pwd = new Intent(Acquirer_Form_Result.this,Locker_Password_Recieved.class);
                startActivity(intent_pwd);
            }
        });

        String name = "";
        String place = "";
        String content = "";

        Bundle extras = getIntent().getExtras();

        name = extras.getString("name");
        place = extras.getString("place");
        content = extras.getString("content");


        TextView tv_name = findViewById(R.id.at_name);
        TextView tv_place = findViewById(R.id.at_place);
        TextView tv_content = findViewById(R.id.at_content);


        String str_n = name;
        String str_p = place;
        String str_c = content;

        tv_name.setText(name);
        tv_place.setText(place);
        tv_content.setText(content);

    }
}