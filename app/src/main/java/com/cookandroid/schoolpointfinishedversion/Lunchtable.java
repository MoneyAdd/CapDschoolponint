package com.cookandroid.schoolpointfinishedversion;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lunchtable extends Fragment {

    DatePickerDialog datePickerDialog;
    View view;
    private String baseUrl = "http://120.142.105.189:12321";
    private TextView tv_lunch;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lunchtable, container, false);
        TextView tv_calender = view.findViewById(R.id.tv_calender);
        tv_lunch = view.findViewById(R.id.tv_lunch);
        ImageView img_calender = view.findViewById(R.id.img_calender);


        //레트로핏 생성
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        LunchtableAIP API = retrofit.create(LunchtableAIP.class);
        Call<ResponseBody> call = API.getLunchtable(1);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful() && response.body()!=null){


                    try {
                        String result = response.body().string();
                        Log.e("LUNCHTABLE", response.body().string());
                        tv_lunch.setText(result);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.d("LUNCHTABLEFAIURE", t.getMessage());
            }
        });

        img_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //오늘날짜 (년,월,일)변수에 담기
                Calendar calendar = Calendar.getInstance();
                int pYear = calendar.get(Calendar.YEAR); //년
                int pMonth = calendar.get(Calendar.MONTH); //월
                int pDay = calendar.get(Calendar.DAY_OF_MONTH);//일
                int pWeek = calendar.get(Calendar.DAY_OF_WEEK);

          datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
              @Override
              public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                  //1월은 0부터 시작하기 때문에 +1을 해준다.
                  month = month +1;
                  String date = year + "년" +  month + "월" + dayOfMonth + "일";
                  tv_calender.setText(date);
              }
          },pYear, pMonth, pDay);
          datePickerDialog.show();
            } // onClick
        });










        return view;
    }
}
