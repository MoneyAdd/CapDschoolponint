package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("user_id")
    public String userid;

    @SerializedName("password")
    public String password;

    public String getUserid(){
        return userid;
    }

    public String getPassword(){
        return password;
    }

    public void setUserid(String userid){
        this.userid = userid;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public LoginRequest(String userid, String password){
        this.userid = userid;
        this.password = password;
    }
}
