package com.cookandroid.schoolpointfinishedversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPage extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    MainpageFragment mainpageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        bottomNavigationView = findViewById(R.id.bottomnavi);
        mainpageFragment = new MainpageFragment();

        //처음화면
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe, mainpageFragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe, mainpageFragment).commitAllowingStateLoss();
                        return true;
                }
                return true;
            }
        });



    }


}