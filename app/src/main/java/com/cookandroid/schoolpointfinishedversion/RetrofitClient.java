package com.cookandroid.schoolpointfinishedversion;

import com.cookandroid.schoolpointfinishedversion.api.RegisterAPI;
import com.cookandroid.schoolpointfinishedversion.api.RoginAPI;
import com.cookandroid.schoolpointfinishedversion.kakao.KakaoApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private static RoginAPI roginAPI;
    private static RegisterAPI registerAPI;
    private static KakaoApi kakaoApi;
    //사용하고 있는 서버 베이스 주소
    private static String baseUrl = "http://120.142.105.189:12321/";


    private RetrofitClient(){
        //retrofit 설정
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        roginAPI = retrofit.create(RoginAPI.class);
        registerAPI = retrofit.create(RegisterAPI.class);
        kakaoApi = retrofit.create(KakaoApi.class);

    }
    public static RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RoginAPI getLoginInterface(){
        return roginAPI;
    }
    public static RegisterAPI getRegisterAPI(){
        return registerAPI;
    }
   public static KakaoApi getKakaoApi(){
        return kakaoApi;
   }
}
