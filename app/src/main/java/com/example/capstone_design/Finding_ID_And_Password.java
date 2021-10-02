package com.example.capstone_design;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Finding_ID_And_Password extends AppCompatActivity {

    private Button Find_ID, Find_Pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding__i_d__and__password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Find_ID = findViewById(R.id.Finding_the_ID);
        Find_Pwd =findViewById(R.id.Finding_a_password);
        Find_Pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_Find_Pwd = new Intent(Finding_ID_And_Password.this, Password_Reset.class);
                startActivity(intent_Find_Pwd);
            }
        });
    }
}