package com.cookandroid.schoolpointfinishedversion;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainpageBoard {

    @GET("/viewHotPost")
    Call<ResponseBody> getboard(@Query("school_id") Integer schoolid);

}
