package com.cookandroid.schoolpointfinishedversion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainpageFragment extends Fragment {

    View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        view = inflater.inflate(R.layout.mainpage, container, false);
        TextView time = view.findViewById(R.id.tv_mainpage_time);
        TextView plus = view.findViewById(R.id.tv_mainpage_Viewmore);
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


