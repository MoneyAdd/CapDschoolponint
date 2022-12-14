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

        idpwfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewFliper.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = userid.getText().toString();
                String pw = userpw.getText().toString();
                //????????? ?????? ??? ?????????
                if(id.trim().length() == 0 || pw.trim().length() == 0 || id == null || pw == null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("??????").setMessage("????????? ????????? ?????? ????????????").setPositiveButton("??????", null).create().show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    //????????? ??????
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
                Log.e("SUC", "????????? ??????", error);
            } else if (oAuthToken != null) {

                Log.i("SUC1", "????????? ??????(??????) : " + oAuthToken.getAccessToken());
                userprofil();
            }
            return null;
        });
    }

    private void accountlogin(){
        UserApiClient.getInstance().logout(error -> {
            if (error != null) {
                Log.e(TAG, "???????????? ??????, SDK?????? ?????? ?????????", error);
            }else{
                Log.e(TAG, "???????????? ??????, SDK?????? ?????? ?????????");
            }
            return null;
        });
    }

    private void userprofil(){
        UserApiClient.getInstance().me((user, meError) -> {
            if (meError != null) {
                Log.e("errr", "????????? ?????? ?????? ??????", meError);
            } else {
                Log.i("tag", "????????? ?????? ?????? ??????" +
                        "\n????????????: "+user.getId() +
                        "\n?????????: "+user.getKakaoAccount().getEmail());
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

        //loginRequeset??? ???????????? ????????? id??? pw??? ??????
          LoginRequest loginRequest = new LoginRequest(ID, PW);
          //retrofit ??????
          retrofitClient = RetrofitClient.getInstance();
          loginAPI = RetrofitClient.getLoginInterface();
          //loginRequest??? ????????? ???????????? ?????? loginapi?????? ????????? getLoginResponse ????????? ????????? ??? ????????? ??????
          loginAPI.getLoginResponse(loginRequest).enqueue(new Callback<LoginResponse>() {
              @Override
              public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                  Log.d("retrofit", String.valueOf(response));
                  //?????? ??????
                  if(response.isSuccessful()  && response.body() != null ){
                      //response.body()??? result??? ??????
                      LoginResponse result = response.body();
                      //?????? ?????? ??????
                      Boolean resultcode = result.getSuc();


                      String userID =userid.getText().toString();
                      Toast.makeText(getApplicationContext(), userID + "??? ???????????????", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(MainActivity.this, MainPage.class);
                      startActivity(intent);
                      MainActivity.this.finish();



                  }else {
                      Toast.makeText(getApplicationContext(), "??????", Toast.LENGTH_SHORT).show();
                  }
              }
              //?????? ??????
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
                              Toast.makeText(getApplicationContext(), "???????????? ??????????????? ???????????? ????????????", Toast.LENGTH_SHORT).show();

                     }
                 });

              }
          });
      }
    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-time>=2000){
            time = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "?????? ????????? 2???????????? ????????? ?????????.", Toast.LENGTH_SHORT).show();
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