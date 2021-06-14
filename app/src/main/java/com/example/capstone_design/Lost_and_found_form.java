package com.example.capstone_design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Lost_and_found_form extends AppCompatActivity {

    EditText t_name,t_place,t_date,t_content;
    Button t_complete;
    DatabaseReference reff;
    Form form;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_and_found_form);

        t_name=findViewById(R.id.t_name);
        t_place=findViewById(R.id.t_place);
        t_date=findViewById(R.id.t_date);
        t_content=findViewById(R.id.t_content);
        t_complete = findViewById(R.id.t_complete);

        form=new Form();
        reff= FirebaseDatabase.getInstance().getReference().child("Form");
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

        t_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                form.setName(t_name.getText().toString().trim());
                form.setPlace(t_place.getText().toString().trim());
                form.setDate(t_date.getText().toString().trim());
                form.setContent(t_content.getText().toString().trim());
                reff.child(String.valueOf(maxid+1)).setValue(form);
                Toast.makeText(Lost_and_found_form.this,"데이터 입력 완료",Toast.LENGTH_LONG).show();
            }
        });

    }
}