package com.cookandroid.schoolpointfinishedversion.register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.cookandroid.schoolpointfinishedversion.R;

public class Termspage2 extends AppCompatActivity {


    private Button next;
    private CheckBox checkBox;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termspage2);

        next = findViewById(R.id.btn_next);
        checkBox = findViewById(R.id.check);
        textView = findViewById(R.id.tv_next);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Termspage2.this, Dirrhksehddml2.class);
                startActivity(intent);
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked() == true){
                    next.setBackgroundColor(Color.parseColor("#F5BD60"));
                }else {
                    next.setBackgroundColor(Color.parseColor("#F3F3F3"));
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked() == true){
                    Intent intent = new Intent(Termspage2.this, Studentjoin.class);
                    startActivity(intent);
                    Termspage2.this.finish();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Termspage2.this);
                    builder.setTitle("알림").setMessage("약관동의 확인해주세요").setPositiveButton("확인", null).create().show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
            }
        });
    }
}