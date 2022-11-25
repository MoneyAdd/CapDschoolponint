package com.cookandroid.schoolpointfinishedversion.api;

import com.cookandroid.schoolpointfinishedversion.LoginRequest;
import com.cookandroid.schoolpointfinishedversion.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RoginAPI {

    @POST("user/login")
    Call<LoginResponse> getLoginResponse(@Body LoginRequest loginRequest);



}
