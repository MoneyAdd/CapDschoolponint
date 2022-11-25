package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("user_id")
    public String userid;

    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;

    }

    @SerializedName("password")
    public String password;
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @SerializedName("nickname")
    public String nickname;

    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public RegisterRequest (String nickname, String userid, String password){
        this.nickname = nickname;
        this.userid = userid;
        this.password = password;
    }
}
