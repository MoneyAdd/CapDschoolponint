package com.cookandroid.schoolpointfinishedversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Popularpostsoftheday extends AppCompatActivity {

    TextView textView;

    private String baseUrl = "http://120.142.105.189:12321";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popularpostsoftheday);

        textView = findViewById(R.id.tv_board);



        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        MainpageBoard API = retrofit.create(MainpageBoard.class);
        Call<ResponseBody> call = API.getboard(1);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        String result = response.body().string();
                        Log.d("LOGG", response.body().string());
                        textView.setText(result);
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
}