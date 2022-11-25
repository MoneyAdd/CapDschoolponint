package com.cookandroid.schoolpointfinishedversion.kakao;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface KakaoApi {

    @POST("user/kakaoSignUp")
    Call<KakaoResponse> getKakaoResponse (@Body KakaoRequest kakaoRequest);
}
