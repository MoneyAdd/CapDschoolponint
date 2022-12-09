package com.cookandroid.schoolpointfinishedversion;

import static com.android.volley.VolleyLog.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.cookandroid.schoolpointfinishedversion.api.RoginAPI;
import com.cookandroid.schoolpointfinishedversion.kakao.KakaoRegister;
import com.cookandroid.schoolpointfinishedversion.register.SignUp;
import com.google.gson.Gson;
import com.kakao.sdk.user.UserApiClient;


import java.util.regex.Pattern;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    Gson gson;

    private long time = 0;

    private RetrofitClient retrofitClient;
    private RoginAPI loginAPI;

    EditText userid, userpw;
    TextView idpwfind, mainregister;
    Button login;
    ImageView kakaologin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         idpwfind = findViewById(R.id.tv_idpw_find);
         mainregister = findViewById(R.id.tv_main_register);

        userid = findViewById(R.id.edit_id);
        userpw = findViewById(R.id.edit_pw);
        login = findViewById(R.id.rogin_btn);
        kakaologin = findViewById(R.id.kakao_btn);

        userid.setFilters(new InputFilter[]{filterAlphaNum});
        userpw.setFilters(new InputFilter[]{filterAlphaNum});

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userid.getText().toString();
                String pw = userpw.getText().toString();
                //로그인 정보 미 입력시
                if(id.trim().length() == 0 || pw.trim().length() == 0 || id == null || pw == null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("알림").setMessage("로그인 정보를 확인 해주세요").setPositiveButton("확인", null).create().show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    //로그인 통신
                    LoginResponse();
                }
            }
        });

        mainregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        kakaologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String Url = "http://120.142.105.189:12321/";
//               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://120.142.105.189:12321/auth/kakao"));
//               startActivity(intent);
            if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(MainActivity.this)){
                sucesslogin();

            }else {
                accountlogin();

            }

            }
        });


        onBackPressed();

    }
    private void sucesslogin(){
        UserApiClient.getInstance().loginWithKakaoTalk(MainActivity.this,(oAuthToken, error) -> {
            if (error != null) {
                Log.e("SUC", "로그인 실패", error);
            } else if (oAuthToken != null) {

                Log.i("SUC1", "로그인 성공(토큰) : " + oAuthToken.getAccessToken());
                userprofil();
            }
            return null;
        });
    }

    private void accountlogin(){
        UserApiClient.getInstance().logout(error -> {
            if (error != null) {
                Log.e(TAG, "로그아웃 실패, SDK에서 토큰 삭제됨", error);
            }else{
                Log.e(TAG, "로그아웃 성공, SDK에서 토큰 삭제됨");
            }
            return null;
        });
    }

    private void userprofil(){
        UserApiClient.getInstance().me((user, meError) -> {
            if (meError != null) {
                Log.e("errr", "사용자 정보 요청 실패", meError);
            } else {
                Log.i("tag", "사용자 정보 요청 성공" +
                        "\n회원번호: "+user.getId() +
                        "\n이메일: "+user.getKakaoAccount().getEmail());
                Intent intent = new Intent(MainActivity.this, KakaoRegister.class);
                intent.putExtra("user", user.getId());
                intent.putExtra("email", user.getKakaoAccount().getEmail());
                startActivity(intent);
            }
            return null;
        });
    }

      public void LoginResponse(){
        String ID = userid.getText().toString().trim();
        String PW = userpw.getText().toString().trim();

//       Intent intents = getIntent();
//       String userID, userPW, userNickname;
//       userID = intents.getExtras().getString("userid").toString();
//          userPW = intents.getExtras().getString("userpw").toString();

        //loginRequeset에 사용자가 입력한 id와 pw를 저장
          LoginRequest loginRequest = new LoginRequest(ID, PW);
          //retrofit 설정
          retrofitClient = RetrofitClient.getInstance();
          loginAPI = RetrofitClient.getLoginInterface();
          //loginRequest에 저장된 데이터와 함께 loginapi에서 정의한 getLoginResponse 함수를 실행한 후 응답을 받음
          loginAPI.getLoginResponse(loginRequest).enqueue(new Callback<LoginResponse>() {
              @Override
              public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                  Log.d("retrofit", String.valueOf(response));
                  //통신 성공
                  if(response.isSuccessful()  && response.body() != null ){
                      //response.body()를 result에 저장
                      LoginResponse result = response.body();
                      //받은 코드 저장
                      Boolean resultcode = result.getSuc();


                      String userID =userid.getText().toString();
                      Toast.makeText(getApplicationContext(), userID + "님 환영합니다", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(MainActivity.this, MainPage.class);
                      startActivity(intent);
                      MainActivity.this.finish();



                  }else {
                      Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_SHORT).show();
                  }
              }
              //통신 실패
              @Override
              public void onFailure(Call<LoginResponse> call, Throwable t) {

                  Log.d("tttt", String.valueOf(t));

                 userid.addTextChangedListener(new TextWatcher() {
                     @Override
                     public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                     }

                     @Override
                     public void onTextChanged(CharSequence s, int start, int before, int count) {

                     }

                     @Override
                     public void afterTextChanged(Editable s) {
                              Toast.makeText(getApplicationContext(), "아이디와 비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();

                     }
                 });

              }
          });
      }
    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-time>=2000){
            time = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "뒤로 버튼을 2번눌르면 종료가 됩니다.", Toast.LENGTH_SHORT).show();
        }else if(System.currentTimeMillis()-time<2000){
            finish();
            return;
        }
    }


    protected InputFilter filterAlphaNum = new InputFilter() {
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern ps = Pattern.compile("^[a-zA-Z0-9]+$");

            if (!ps.matcher(source).matches()) {
                return "";
            }
            return null;
        }
    };

}