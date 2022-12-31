package com.cookandroid.schoolpointfinishedversion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainpageFragment extends Fragment {

    View view;
    String baseurl = "http://120.142.105.189:12321";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.mainpage, container, false);
        TextView time = view.findViewById(R.id.tv_mainpage_time);
        TextView plus = view.findViewById(R.id.tv_mainpage_Viewmore);
        TextView board = view.findViewById(R.id.tv_mainpage_boardtitle1);
        TextView boardview = view.findViewById(R.id.tv_mainpage_Viewmore1);


        boardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), Popularpostsoftheday.class);
               startActivity(intent);
            }
        });

            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
            MainpageBoard API = retrofit.create(MainpageBoard.class);
            Call<ResponseBody> call = API.getboard(1);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try {
                            String result = response.body().string();
                            Log.d("LOGG", response.body().string());
                            board.setText(result);
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(getContext(), "통신실패", Toast.LENGTH_LONG).show();
                }
            });


       plus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), BoardView.class);
               startActivity(intent);
           }
       });


        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                time.setText(DateFormat.getDateTimeInstance().format(new Date()));
            }
        };
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){ }
                    handler.sendEmptyMessage(1);
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();


        return view;
    }




    }


