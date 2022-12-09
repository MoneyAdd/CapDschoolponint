package com.cookandroid.schoolpointfinishedversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardWriting extends AppCompatActivity {


    private RetrofitClient retrofitClient;
    private BoardAPI boardAPI;
    private BulletinboardAPI bulletinboardAPI;


    private EditText title, contnent, type, useid;
    private Button uploading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_writing);

        title = findViewById(R.id.et_board_title);
        contnent = findViewById(R.id.et_board_content);
        type = findViewById(R.id.et_board_type);
        useid = findViewById(R.id.et_board_userid);

        uploading = findViewById(R.id.btn_board_upload);

        uploading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 String Title = title.getText().toString();
                 String Content = contnent.getText().toString();
                 String Type = type.getText().toString();
              String Userid =  useid.getText().toString();

                BoardReq boardReq = new BoardReq(Title, Content, Type, Userid);
                retrofitClient = RetrofitClient.getInstance();
              boardAPI = RetrofitClient.getBoardAPI();
              boardAPI.getBoardRes(boardReq).enqueue(new Callback<BoardRes>() {


                  @Override
                  public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {

                      if(response.isSuccessful() && response.body() != null){



                         Toast.makeText(getApplicationContext(), "통신성공", Toast.LENGTH_LONG).show();
                         Log.d("RESPONSE", response.body().toString());
                          BoardWriting.this.finish();



                      }else {
                          Toast.makeText(getApplicationContext(), "통신 에러", Toast.LENGTH_LONG).show();
                      }



                  }

                  @Override
                  public void onFailure(Call<BoardRes> call, Throwable t) {

                      Toast.makeText(getApplicationContext(), "통신 오류", Toast.LENGTH_LONG).show();

                  }
              });


            }
        });

    }
}