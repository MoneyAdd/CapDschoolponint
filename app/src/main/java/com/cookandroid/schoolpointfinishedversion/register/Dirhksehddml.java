package com.cookandroid.schoolpointfinishedversion.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookandroid.schoolpointfinishedversion.R;

public class Dirhksehddml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dirhksehddml);

        Button button = findViewById(R.id.close);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dirhksehddml.this, Termspage1.class);
                startActivity(intent);
                Dirhksehddml.this.finish();
            }
        });
    }
}