package com.cookandroid.schoolpointfinishedversion.api;

import com.cookandroid.schoolpointfinishedversion.RegisterRequest;
import com.cookandroid.schoolpointfinishedversion.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterAPI {

    @POST("user/signUp")
    Call<RegisterResponse> getRegisterResponse(@Body RegisterRequest registerRequest);
}
