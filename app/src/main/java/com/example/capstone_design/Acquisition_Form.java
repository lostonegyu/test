package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acquisition_Form extends AppCompatActivity implements View.OnClickListener {

    Button lost_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acquisition__form);

        lost_button = findViewById(R.id.Lost_Btn);
        lost_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_lost = new Intent(Acquisition_Form.this,Lost_Form.class);
        startActivity(intent_lost);
    }
}