package com.example.capstone_design;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;


public class Password_Reset extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; // 파이어베이스 인증

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password__reset);

        mFirebaseAuth = FirebaseAuth.getInstance();


        findViewById(R.id.check_btn).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.check_btn:
                    check();
                    break;
            }
        }
    };

    private void check() {
        String email = ((EditText) findViewById(R.id.input_email)).getText().toString();
        if (email.length() >0) {
            mFirebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            startToast("이메일을 보냈습니다.");
                        }
                    });
        }else{
            startToast("이메일을 입력해 주세요");
        }
    }
    private void startToast(String msg) {Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();}
}