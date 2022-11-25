package com.cookandroid.schoolpointfinishedversion.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookandroid.schoolpointfinishedversion.R;

public class Dirrhksehddml2 extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dirrhksehddml2);

        button = findViewById(R.id.close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dirrhksehddml2.this, Termspage2.class);
                startActivity(intent);
                Dirrhksehddml2.this.finish();
            }
        });
    }
}