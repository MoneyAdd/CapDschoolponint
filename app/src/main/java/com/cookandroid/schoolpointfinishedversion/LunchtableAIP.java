package com.cookandroid.schoolpointfinishedversion;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LunchtableAIP {

    @GET("user/viewMealtable")
    Call<ResponseBody> getLunchtable(@Query("school_id") Integer schoolid);
}
