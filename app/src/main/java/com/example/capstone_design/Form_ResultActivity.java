package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Form_ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form__result);

        String name = "";
        String place = "";
        String content = "";

        Bundle extras = getIntent().getExtras();

        name = extras.getString("name");
        place = extras.getString("place");
        content = extras.getString("content");


        TextView tv_name = findViewById(R.id.ft_name);
        TextView tv_place = findViewById(R.id.ft_place);
        TextView tv_content = findViewById(R.id.ft_content);


        String str_n = name;
        String str_p = place;
        String str_c = content;

        tv_name.setText(name);
        tv_place.setText(place);
        tv_content.setText(content);



    }
}