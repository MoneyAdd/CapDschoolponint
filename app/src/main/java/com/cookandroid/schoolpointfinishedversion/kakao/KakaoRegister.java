package com.cookandroid.schoolpointfinishedversion.kakao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.schoolpointfinishedversion.MainPage;
import com.cookandroid.schoolpointfinishedversion.R;
import com.cookandroid.schoolpointfinishedversion.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KakaoRegister extends AppCompatActivity {

    private RetrofitClient retrofitClient;

    private KakaoApi kakaoApi;

    private EditText name, nickname;
    private TextView kakaoid, kakaoemail;
    private Button kakaosave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_register);

        name = findViewById(R.id.name);
        nickname = findViewById(R.id.nickname);
        kakaoemail = findViewById(R.id.tv_kakaoemail);
        kakaoid = findViewById(R.id.tv_kakaid);
        kakaosave = findViewById(R.id.registersave);


        Intent intent = getIntent();
//        String kakaoEmail = intent.getExtras().getString("email").toString();
        String kakaoID = intent.getExtras().get("user").toString();
        kakaoid.setText(kakaoID);
//        kakaoemail.setText(kakaoEmail);



        kakaosave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Nickname =nickname.getText().toString();
//                kakaoEmail.toString();
                kakaoID.toString();



                if(Name.trim().length() == 0 || Nickname.trim().length() == 0 || Name == null || Nickname == null || kakaoID == null  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(KakaoRegister.this);
                    builder.setTitle("알림").setMessage("회원가입 정보를 확인 해주세요").setPositiveButton("확인", null).create().show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    KakaoResponse();

                }
            }
        });

    }
    public void KakaoResponse(){
        String names = name.getText().toString();
        String nicknames = nickname.getText().toString();
         String kakaoiD = kakaoid.getText().toString();
//         String kakaoEMAIL = kakaoemail.getText().toString();

        KakaoRequest kakaoRequest = new KakaoRequest(kakaoiD, names, nicknames);
        retrofitClient = RetrofitClient.getInstance();
        kakaoApi = RetrofitClient.getKakaoApi();
        kakaoApi.getKakaoResponse(kakaoRequest).enqueue(new Callback<KakaoResponse>() {
            @Override
            public void onResponse(Call<KakaoResponse> call, Response<KakaoResponse> response) {

                if(response.isSuccessful() && response.body() != null){
                    KakaoResponse result = response.body();
                    //받은 코드 저장
                    Boolean resultcode = result.getSuc();
                    Log.e("kakaotrue", String.valueOf(response));


                    Toast.makeText(getApplicationContext(), "가입완료!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(KakaoRegister.this, MainPage.class);


                    startActivity(intent);
                   KakaoRegister.this.finish();
                }else {

                    Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<KakaoResponse> call, Throwable t) {
                Log.d("kakaofalse", String.valueOf(t));
                Toast.makeText(getApplicationContext(), "통신 오류", Toast.LENGTH_SHORT).show();
            }
        });
    }
}