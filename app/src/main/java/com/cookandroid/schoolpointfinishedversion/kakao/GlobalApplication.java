package com.cookandroid.schoolpointfinishedversion;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class GlobalApplication extends Application {

    private static GlobalApplication instance;
    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

        //네이티브 앱 키로 초기화
      KakaoSdk.init(this, "821d23ad7db1b748fd5a42fbd44a2c6d");

    }
}
