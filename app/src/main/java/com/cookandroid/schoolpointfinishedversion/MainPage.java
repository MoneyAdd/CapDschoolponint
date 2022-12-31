package com.cookandroid.schoolpointfinishedversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPage extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    MainpageFragment mainpageFragment;
    ChatFragemt chatFragemt;
    ScheduleFragment scheduleFragment;
    Lunchtable lunchtable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        bottomNavigationView = findViewById(R.id.bottomnavi);
        mainpageFragment = new MainpageFragment();
        chatFragemt = new ChatFragemt();
        scheduleFragment = new ScheduleFragment();
        lunchtable = new Lunchtable();


        //처음화면
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe, mainpageFragment).commitAllowingStateLoss();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe, mainpageFragment).commitAllowingStateLoss();
                        return true;
                    case R.id.board:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe, chatFragemt).commitAllowingStateLoss();
                        return true;
                    case R.id.schedul:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe, scheduleFragment).commitAllowingStateLoss();
                        return true;
                    case R.id.lunch:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe, lunchtable).commitAllowingStateLoss();
                        return true;

                }
                return true;
            }
        });

    }

}