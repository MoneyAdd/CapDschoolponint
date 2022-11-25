package com.cookandroid.schoolpointfinishedversion.kakao;

import com.google.gson.annotations.SerializedName;

public class KakaoResponse {

    @SerializedName("suc")
    public Boolean suc;
    public Boolean getSuc(){
        return suc;
    }
    public void setSuc(Boolean suc){
        this.suc =suc;
    }
}
