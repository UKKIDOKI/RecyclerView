package com.doit.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 사용할 변수선언
    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);  // xml의 리사이클러뷰를 가져온다
        linearLayoutManager = new LinearLayoutManager(this);   //리니어레이아웃매니저 객체를 생성후 생성자로 컨텍스트 전달
        recyclerView.setLayoutManager(linearLayoutManager); // 리사이클러뷰에 레이아웃매니저 셋팅

        arrayList = new ArrayList<>();     // 어레이리스트 객체생성

        mainAdapter = new MainAdapter(arrayList); // 메인어댑터 객체생성후 생성자로 어레이리스트 전달
        recyclerView.setAdapter(mainAdapter); // 리사이클러뷰에 어댑터 셋팅

        Button btn_add = findViewById(R.id.btn_add);  // 버튼가져오기

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {          // 버튼클릭시 이벤트 메서드
                MainData mainData = new MainData(R.mipmap.ic_launcher ,"ukki","recycelrView"); // 데이터 클래스타입 객체생성 생성자로 뷰홀더아이템에 들어갈 데이터 전달
                arrayList.add(mainData);         // 만들어진 객체를 어레이리스트에 추가
                mainAdapter.notifyDataSetChanged(); //리아시클러뷰리스트를 새로고침하는 메서드
            }
        });

    }
}