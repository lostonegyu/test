package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Submit = findViewById(R.id.Submit_btn);
        Submit.setOnClickListener(this);

        String kind = "";
        String name = "";

        Bundle extras = getIntent().getExtras();

        kind = extras.getString("kind");
        name = extras.getString("name");


        TextView tv_kind = findViewById(R.id.text_Type);
        TextView tv_name = findViewById(R.id.text_Acquisition_Name);


        String str_k = kind;
        String str_n = name;

        tv_kind.setText(kind);
        tv_name.setText(name);


    }

    @Override
    public void onClick(View v) {
        Intent intent01 = new Intent(ResultActivity.this, Lost_and_found_form.class);
        startActivity(intent01);
    }
}