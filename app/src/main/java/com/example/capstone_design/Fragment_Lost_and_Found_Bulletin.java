package com.example.capstone_design;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment_Lost_and_Found_Bulletin extends Fragment {
    Button Create_Posts_btn;

    private View view;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Member> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    public  static Fragment_Lost_and_Found_Bulletin newInstance() {
        Fragment_Lost_and_Found_Bulletin fragment_lost_and_found_bulletin = new Fragment_Lost_and_Found_Bulletin();
        return  fragment_lost_and_found_bulletin;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_lost_and_found_bulletin, container, false);

        //로그인 게시물 작성하기 버튼 구현
        Create_Posts_btn = view.findViewById(R.id.Create_Posts_btn);
        Create_Posts_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_Create_Posts = new Intent(getActivity(),board.class);
                startActivity(intent_Create_Posts);
            }
        });

        recyclerView = view.findViewById(R.id.main_recyclerview); // 아디 연결
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // User 객체를 담을 어레이 리스트 (어댑터쪽으로)

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("Member"); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    Member member = snapshot.getValue(Member.class); // 만들어뒀던 User 객체에 데이터를 담는다.
                    arrayList.add(member); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        adapter = new CustomAdapter(arrayList, getActivity());
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결

        recyclerView.addOnItemTouchListener(new Fragment_Lost_and_Found_Bulletin.RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new Fragment_Lost_and_Found_Bulletin.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Member member = arrayList.get(position);


                Intent intent = new Intent(getActivity().getBaseContext(), ResultActivity.class);

                intent.putExtra("kind",member.getBst());
                intent.putExtra("name",member.getBln());
                intent.putExtra("acquisition",member.getBmt());
                intent.putExtra("time",member.getBdt());
                intent.putExtra("content",member.getBci());
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        return  view;

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private Fragment_Lost_and_Found_Bulletin.ClickListener clickListener;

        public RecyclerTouchListener(Context applicationContext, RecyclerView recyclerView, Fragment_Lost_and_Found_Bulletin.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector( new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
