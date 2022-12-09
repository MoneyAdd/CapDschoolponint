package com.cookandroid.schoolpointfinishedversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class BoardView extends AppCompatActivity {

    private TextView tv_view;
    private FloatingActionButton floatingActionButton;
    private RetrofitClient retrofitClient;
    private BulletinboardAPI bulletinboardAPI;
   private String baseUrl = "http://120.142.105.189:12321";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_view);

        tv_view = findViewById(R.id.tv_boardview_view);
        floatingActionButton = findViewById(R.id.floating_boardpage_view);


        //레트로핏 생성
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        BulletinboardAPI API = retrofit.create(BulletinboardAPI.class);
        Call<ResponseBody> call = API.getBullet(null, 1,1);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){


                    try {
                        String result = response.body().string();
                        Log.e("BBB", response.body().string());
                        tv_view.setText(result);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardView.this, BoardWriting.class);
                startActivity(intent);
            }
        });




    }
}