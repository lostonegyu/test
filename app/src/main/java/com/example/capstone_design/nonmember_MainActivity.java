package com.example.capstone_design;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;


public class nonmember_MainActivity extends AppCompatActivity {
    ImageButton login_btn;

    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonmember_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //비로그인 로그인 버튼 구현
        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_login = new Intent(nonmember_MainActivity.this,LoginActivity.class);
                startActivity(intent_login);
            }
        });

        // 뷰페이저 세팅
        ViewPager viewPager = findViewById(R.id.nomember_viewPager);
        fragmentPagerAdapter = new nonmember_ViewPagerAdapter(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.nomember_tab_layout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}