package com.cookandroid.schoolpointfinishedversion;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BoardAPI {

    @POST("board/uploadPost")
    Call<BoardRes> getBoardRes(@Body BoardReq boardReq);
}
