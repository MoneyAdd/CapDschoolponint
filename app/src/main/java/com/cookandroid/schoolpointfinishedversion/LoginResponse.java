package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("suc")
    public Boolean suc;

    public Boolean getSuc(){
        return suc;
    }
    public void setSuc(Boolean suc){
        this.suc = suc;
    }
}
