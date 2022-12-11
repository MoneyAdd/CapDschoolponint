package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("name")
    public String name;
    public String getName(){
        return name;
    }
    public void setName(String name ){
        this.name = name;
    }


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

    @SerializedName("email")
    public String email;
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public RegisterRequest (String nickname, String userid, String password, String name, String email){
        this.nickname = nickname;
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
