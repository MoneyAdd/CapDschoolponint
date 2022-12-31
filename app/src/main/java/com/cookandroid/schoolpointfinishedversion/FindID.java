package com.cookandroid.schoolpointfinishedversion;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FindID {

    @GET("user/findId")
    Call<ResponseBody> getfindid(@Query("email") String email);
}
