package com.example.capstone_design;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private ISessionCallback mSessionCallback;

    private FirebaseAuth mFirebaseAuth; // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mEtEmail, mEtPwd; // 로그인 입력필드
    private static  final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$"); //비밀번호 정규식

    TextView join_membership;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(mSessionCallback);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSessionCallback = new ISessionCallback() {
            @Override
            public void onSessionOpened() {
                //로그인 요청
                UserManagement.getInstance().me(new MeV2ResponseCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        // 로그인 실패
                        Toast.makeText(LoginActivity.this, "로그인 도중에 오류가 발생 했습니다.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        // 세션이 닫힘..
                        Toast.makeText(LoginActivity.this, "세션이 닫혔습니다.. 다시 시도해주세요", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(MeV2Response result) {
                        //로그인 성공
                        Intent intent_kakao = new Intent(LoginActivity.this, MainActivity.class);
                        intent_kakao.putExtra("name", result.getKakaoAccount().getProfile().getNickname());
                        intent_kakao.putExtra("profileImg", result.getKakaoAccount().getProfile().getProfileImageUrl());
                        intent_kakao.putExtra("email", result.getKakaoAccount().getEmail());
                        startActivity(intent_kakao);
                        //Toast.makeText(LoginActivity.this, "환영 합니다 !", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onSessionOpenFailed(KakaoException exception) {

            }
        };
        Session.getCurrentSession().addCallback(mSessionCallback);
        Session.getCurrentSession().checkAndImplicitOpen();



        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Lost and Found Center");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);


        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mEtPwd.getText().toString().equals("") && !mEtPwd.getText().toString().equals("")) {
                    //로그인 요청
                    //이메일 형식 불일치
                    String strEmail =mEtEmail.getText().toString();
                    if(!Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()) {
                        Toast.makeText(LoginActivity.this, "이메일을 올바르게 입력하시오.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String strPwd = mEtPwd.getText().toString();
                    //비밀번호 형식 불일치
                    if(!PASSWORD_PATTERN.matcher(strPwd).matches()) {
                        Toast.makeText(LoginActivity.this, "비밀번호를 올바르게 입력하시오.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                // 로그인 성공 !!!
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish(); // 현재 액티비티 파괴
                            } else {
                                Toast.makeText(LoginActivity.this, "이메일 또는 비밀번호를 다시 확인하세요.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    if(mEtEmail.getText().toString().equals("")) {
                        Toast.makeText(LoginActivity.this, "이메일을 입력하세요.",Toast.LENGTH_SHORT).show();
                    } else if(mEtPwd.getText().toString().equals("")) {
                        Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        join_membership = findViewById(R.id.tv_jm);
        join_membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이용 약관 화면 -> 회원가입 화면
                Intent intent= new Intent(LoginActivity.this,Terms_of_service.class);
                startActivity(intent);
            }
        });
    }
}