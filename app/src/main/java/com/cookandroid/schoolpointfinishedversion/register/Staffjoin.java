package com.cookandroid.schoolpointfinishedversion.register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.schoolpointfinishedversion.MainActivity;
import com.cookandroid.schoolpointfinishedversion.R;
import com.cookandroid.schoolpointfinishedversion.RegisterRequest;
import com.cookandroid.schoolpointfinishedversion.RegisterResponse;
import com.cookandroid.schoolpointfinishedversion.RetrofitClient;
import com.cookandroid.schoolpointfinishedversion.api.RegisterAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Staffjoin extends AppCompatActivity {

    private RetrofitClient retrofitClient;
    private RegisterAPI registerAPI;

    private ImageView back;
    private TextView tv_agre;



    private Button btn_registersave;

    private EditText edt_nickname, edt_userid, edt_password, edt_paswwords, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffjoin);

        edt_nickname = findViewById(R.id.edt_usernickname);
        edt_userid = findViewById(R.id.edt_userid);
        edt_password = findViewById(R.id.edt_userpw);
        edt_paswwords = findViewById(R.id.edt_userpww);
        username = findViewById(R.id.edt_username);

        btn_registersave = findViewById(R.id.registersave);

        back = findViewById(R.id.img_back);
        tv_agre = findViewById(R.id.tv_agree);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Staffjoin.this, SignUp.class);
                startActivity(intent);
            }
        });

        btn_registersave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernickname = edt_nickname.getText().toString();
                String userid = edt_userid.getText().toString();
                String userpassword = edt_password.getText().toString();
                String userpasswords = edt_paswwords.getText().toString();
                String USERname = username.getText().toString();
                if(usernickname.trim().length() == 0 || userid.trim().length() == 0 || userpasswords.trim().length() == 0 || userpassword.trim().length() == 0 ||
                userid == null || usernickname == null || userpassword == null || userpasswords == null || USERname.trim().length() == 0 || USERname == null ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Staffjoin.this);
                    builder.setTitle("알림").setMessage("회원가입 정보를 확인 해주세요").setPositiveButton("확인", null).create().show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    RegisterReponse();


                }

            }
        });

        edt_paswwords.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



            }

            @Override
            public void afterTextChanged(Editable s) {
                btn_registersave.setBackgroundColor(Color.parseColor("#F5BD60"));
            }
        });
    }



    public void RegisterReponse(){
        String ID = edt_userid.getText().toString();
        String PW = edt_password.getText().toString();
        String PWS = edt_paswwords.getText().toString();
        String NAME  = username.getText().toString();
        String NICKNAME = edt_nickname.getText().toString();
        String EMAIL = "tjdwns0158@naver.com";

        RegisterRequest registerRequest = new RegisterRequest(NICKNAME, ID, PW, NAME, EMAIL);
        retrofitClient = RetrofitClient.getInstance();
        registerAPI = RetrofitClient.getRegisterAPI();
        registerAPI.getRegisterResponse(registerRequest).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.d("retrofit11", String.valueOf(response));
                if(response.isSuccessful() || response.body() != null){
                    RegisterResponse result = response.body();
                    //받은 코드 저장
                    Boolean resultcode = result.getSuc();

                    Toast.makeText(getApplicationContext(), "가입완료!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Staffjoin.this, MainActivity.class);
                    startActivity(intent);
                    Staffjoin.this.finish();
                }else {
                    Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d("registererr", String.valueOf(t));
                AlertDialog.Builder builder = new AlertDialog.Builder(Staffjoin.this);
                builder.setTitle("알림").setMessage("통신오류").setPositiveButton("확인", null).create().show();
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        }

    }
