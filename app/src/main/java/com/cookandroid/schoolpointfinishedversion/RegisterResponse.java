package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("suc")
    public Boolean suc;

    public Boolean getSuc(){
        return suc;
    }
    public void setSuc(Boolean suc){
        this.suc = suc;
    }
}
