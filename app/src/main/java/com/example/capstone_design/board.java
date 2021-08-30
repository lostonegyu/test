package com.example.capstone_design;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.EventListener;
import java.util.HashMap;

public class board extends AppCompatActivity {


    EditText board_maptext, board_datetext, board_passinput, board_contInput, board_lostnametext;
    Spinner board_sort;
    Button board_submit;
    TextView board_qrscan;
    DatabaseReference reff;
    Member member;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_main);
        board_sort=(Spinner)findViewById(R.id.board_sort);
        board_lostnametext=(EditText)findViewById(R.id.board_lostnametext);
        board_maptext=(EditText)findViewById(R.id.board_maptext);
        board_datetext=(EditText)findViewById(R.id.board_datetext);
        board_passinput=(EditText)findViewById(R.id.board_passinput);
        board_contInput=(EditText)findViewById(R.id.board_contInput);
        board_submit=(Button)findViewById(R.id.board_submit);
        board_qrscan = findViewById(R.id.board_qrscan);

        member=new Member();
        reff=FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if(datasnapshot.exists())
                    maxid=(datasnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        board_qrscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent222 = new Intent(board.this, QrScanner.class);
                startActivity(intent222);
            }
        });


        board_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setBst(board_sort.getSelectedItem().toString().trim());
                member.setBln(board_lostnametext.getText().toString().trim());
                member.setBmt(board_maptext.getText().toString().trim());
                member.setBdt(board_datetext.getText().toString().trim());
                member.setBpi(board_passinput.getText().toString().trim());
                member.setBci(board_contInput.getText().toString().trim());
                member.setStat("보관중".toString().trim());
                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(board.this,"데이터 입력 완료",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(board.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}