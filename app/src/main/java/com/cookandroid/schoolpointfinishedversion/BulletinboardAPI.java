package com.cookandroid.schoolpointfinishedversion;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BulletinboardAPI {

    @GET("board/viewBoard/공지사항/1/1")
//    Call<BulletinboardinRes> getBullet(@Query("board_id") Integer board_id, @Query("school_id") Integer school_id, @Query("page") Integer page);
    Call<ResponseBody> getBullet(@Query("board_id") Integer board_id, @Query("school_id") Integer school_id, @Query("page") Integer page);

}
