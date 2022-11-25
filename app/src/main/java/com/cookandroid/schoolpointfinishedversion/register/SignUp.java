package com.cookandroid.schoolpointfinishedversion.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cookandroid.schoolpointfinishedversion.R;
import com.cookandroid.schoolpointfinishedversion.StratView;

public class SignUp extends AppCompatActivity {

    private ImageView  back;

    private FrameLayout fram1, fram2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fram1 = findViewById(R.id.fram1);
        fram2 = findViewById(R.id.fram2);


        back = findViewById(R.id.img_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, StratView.class);
                startActivity(intent);
                SignUp.this.finish();
            }
        });


        fram1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ter1", String.valueOf(v));
                Intent intent = new Intent(SignUp.this, Termspage1.class);
                startActivity(intent);
            }
        });


        fram2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ter1", String.valueOf(v));
                Intent intent = new Intent(SignUp.this, Termspage2.class);
                startActivity(intent);
            }
        });






    }
}