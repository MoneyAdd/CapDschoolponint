package com.cookandroid.schoolpointfinishedversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cookandroid.schoolpointfinishedversion.register.SignUp;

public class StratView extends AppCompatActivity {

    Button roginbtn, siupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strat_view);

        roginbtn = findViewById(R.id.start_rogin_btn);
        siupbtn = findViewById(R.id.start_signup_btn);

        roginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StratView.this, MainActivity.class);
                Log.e("why?", String.valueOf(intent));
                startActivity(intent);
                StratView.this.finish();

            }
        });

        siupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StratView.this, SignUp.class);
                startActivity(intent);
                StratView.this.finish();
            }
        });


    }
}