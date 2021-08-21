package com.example.capstone_design;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mEtEmail, mEtPwd, mEtCPwd,mEtName,mEtPhone; // 회원가입 입력필드
    private Button mBtnRegister; // 회원가입 버튼
    private static  final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$"); //비밀번호 정규식


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Lost and Found Center");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);
        mEtCPwd = findViewById(R.id.et_confirm_pwd);
        mEtName = findViewById(R.id.et_name);
        mEtPhone = findViewById(R.id.et_phone);

        mBtnRegister = findViewById(R.id.btn_check);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mEtEmail.getText().toString().equals("") && !mEtPwd.getText().toString().equals("") && !mEtCPwd.getText().toString().equals("") && !mEtName.getText().toString().equals("") & !mEtPhone.getText().toString().equals("")) {
                    // 회원가입 처리 시작
                    String strEmail =mEtEmail.getText().toString();
                    //이메일 형식 불일치
                    if(!Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()) {
                        Toast.makeText(RegisterActivity.this, "이메일을 올바르게 입력하시오.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String strPwd = mEtPwd.getText().toString();
                    //비밀번호 형식 불일치
                    if(!PASSWORD_PATTERN.matcher(strPwd).matches()) {
                        Toast.makeText(RegisterActivity.this, "비밀번호를 올바르게 입력하시오.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String strCPwd = mEtCPwd.getText().toString();
                    //비밀번호 형식 불일치
                    if(!PASSWORD_PATTERN.matcher(strCPwd).matches()) {
                        Toast.makeText(RegisterActivity.this, "비밀번호를 올바르게 입력하시오.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //비밀번호 2차비밀번호 일치 하지 않는 경우
                    if(!mEtPwd.getText().toString().equals(mEtCPwd.getText().toString())) {
                        Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String strName = mEtName.getText().toString();
                    String strPhone = mEtPhone.getText().toString();

                    //Firebase Auth 진행
                    mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                                UserAccount account = new UserAccount();
                                account.setIdToken(firebaseUser.getUid());
                                account.setEmailId(firebaseUser.getEmail());
                                account.setPassword(strPwd);
                                account.setName(strName);
                                account.setPhone(strPhone);

                                //setValue : databas에 insert (삽입) 행위
                                mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                                Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent_Register = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent_Register);
                            } else {
                                Toast.makeText(RegisterActivity.this, "이미 사용중인 계정입니다.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    if(mEtEmail.getText().toString().equals("")) {
                        //이메일 공백인 경우
                        Toast.makeText(RegisterActivity.this, "이메일을 입력하세요.",Toast.LENGTH_SHORT).show();
                    }  else if(mEtPwd.getText().toString().equals("")) {
                        //비밀번호 공백인 경우
                        Toast.makeText(RegisterActivity.this,"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show();
                    }
                    else if(mEtCPwd.getText().toString().equals("")) {
                        //비밀번호 확인 공백인 경우
                        Toast.makeText(RegisterActivity.this,"비밀번호 확인을 입력하세요",Toast.LENGTH_SHORT).show();
                    } else if(mEtName.getText().toString().equals("")) {
                        //이름 공백인 경우
                        Toast.makeText(RegisterActivity.this,"이름을 입력하세요",Toast.LENGTH_SHORT).show();
                    } else if(mEtPhone.getText().toString().equals("")) {
                        //휴대전화 공백인 경우
                        Toast.makeText(RegisterActivity.this,"휴대전화를 입력하세요",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}