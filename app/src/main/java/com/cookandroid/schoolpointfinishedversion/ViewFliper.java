package com.cookandroid.schoolpointfinishedversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewFliper extends AppCompatActivity {

    EditText etfindid, etfindemail;
    EditText emaailjoin;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    Button button, emailcertification;
    Button findid, findpw;
    private ViewFlipper viewFlipper;
    private String baseUrl = "http://120.142.105.189:12321";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fliper);



        etfindid = findViewById(R.id.ed_name);
        etfindemail = findViewById(R.id.ed_email);
        emailcertification = findViewById(R.id.btn_emailcertification);
        emaailjoin = findViewById(R.id.ed_certification);

        checkBox2 = findViewById(R.id.viewfliper_checkbox2);
        checkBox3 = findViewById(R.id.viewfliper_checkbox3);
        checkBox4 = findViewById(R.id.viewfliper_checkbox4);
        checkBox5 = findViewById(R.id.viewfliper_checkbox5);

        button = findViewById(R.id.viewfliper_next);
        findid = findViewById(R.id.btn_findid);
        findpw = findViewById(R.id.btn_findpw);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

        findid.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                findid.setBackground(getDrawable(R.drawable.findid));
                findpw.setBackground(getDrawable(R.drawable.findidnull));
                viewFlipper.showPrevious();

            }
        });

        emailcertification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = etfindemail.getText().toString();
                Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
                Emailanuta API = retrofit.create(Emailanuta.class);
                Call<ResponseBody> call = API.getEmail(Email);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            try {
                                Log.d("CallSuce", response.body().string());
                                String result = response.body().string();

                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "통신실패", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

                 button.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent intent = new Intent(ViewFliper.this, ViewFliper2.class);
                         intent.putExtra("userid", "q");
                         startActivity(intent);
                     }
                 });




        findpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findpw.setBackground(getDrawable(R.drawable.findid));
                findid.setBackground(getDrawable(R.drawable.findidnull));
                viewFlipper.showNext();
            }
        });



    }


}