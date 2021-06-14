package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        String acquisition = "";
        String time = "";
        String content ="";

        Bundle extras = getIntent().getExtras();

        kind = extras.getString("kind");
        name = extras.getString("name");
        acquisition = extras.getString("acquisition");
        time = extras.getString("time");
        content = extras.getString("content");


        TextView tv_kind = findViewById(R.id.text_kind);
        TextView tv_name = findViewById(R.id.text_acquisition_item__name);
        TextView tv_acquisition = findViewById(R.id.text_place);
        TextView tv_time = findViewById(R.id.text_time);
        TextView tv_content = findViewById(R.id.text_content);


        String str_k = kind;
        String str_n = name;
        String str_a = acquisition;
        String str_t = time;
        String str_c = content;

        tv_kind.setText(kind);
        tv_name.setText(name);
        tv_acquisition.setText(acquisition);
        tv_time.setText(time);
        tv_content.setText(content);

    }

    @Override
    public void onClick(View v) {
        Intent intent01 = new Intent(ResultActivity.this, Lost_and_found_form.class);
        startActivity(intent01);
    }
}