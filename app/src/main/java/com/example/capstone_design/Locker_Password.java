package com.example.capstone_design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Locker_Password extends AppCompatActivity {
    EditText PasswordNumber;
    Button buttonVertify;
    DatabaseReference reff;
    Password password;
    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locker__password);

        PasswordNumber = findViewById(R.id.PasswordNumber);
        buttonVertify = findViewById(R.id.buttonVertify);

        password = new Password();
        reff = FirebaseDatabase.getInstance().getReference().child("Password");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists())
                    maxid = (datasnapshot.getChildrenCount());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        buttonVertify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setPwd(PasswordNumber.getText().toString().trim());
                reff.child(String.valueOf(maxid+1)).setValue(password);
                Toast.makeText(Locker_Password.this,"비밀번호 저장완료",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Locker_Password.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}