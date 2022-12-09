package com.cookandroid.schoolpointfinishedversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class BoardPage extends AppCompatActivity {

    private BoardAdapter adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_page);


        init();
//        getdata();

        floatingActionButton = findViewById(R.id.floating_boardpage);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent = new Intent(BoardPage.this, BoardWriting.class);
              startActivity(intent);

            }
        });


    }



    private void init(){

        recyclerView = findViewById(R.id.ryc_boardpage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new BoardAdapter();
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();

        BoarditemModel boarditemModel = new BoarditemModel("ㅋㅋ 오늘 학식..", "너무 맛없음;;", "자유게시판", "tom789");
        adapter.additem(boarditemModel);
        boarditemModel = new BoarditemModel(intent.getStringExtra("title"), intent.getStringExtra("content"), intent.getStringExtra("type"), intent.getStringExtra("userid"));
        adapter.additem(boarditemModel);



    }

//    private void getdata(){
//        Intent intent = getIntent();
//
////        BoardReq data = new BoarditemModel("테스트 게시판", "테스트", "자유게시판", "조성준");
////        adapter.additem(data);
//        data = new BoarditemModel(intent.getStringExtra("title"), intent.getStringExtra("content"), intent.getStringExtra("type"), intent.getStringExtra("userid"));
//       adapter.additem(data);
//
//    }


}