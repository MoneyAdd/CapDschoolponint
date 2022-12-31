package com.cookandroid.schoolpointfinishedversion;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Emailanuta {

    @GET("/sendMail")
    Call<ResponseBody> getEmail(@Query("email") String email);
}
