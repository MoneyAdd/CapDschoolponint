package com.cookandroid.schoolpointfinishedversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewFliper2 extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fliper2);
        textView = findViewById(R.id.tvid);
        button = findViewById(R.id.btngogogo);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("userid"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ViewFliper2.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}