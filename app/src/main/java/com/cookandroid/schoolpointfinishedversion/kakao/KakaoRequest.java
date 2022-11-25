package com.cookandroid.schoolpointfinishedversion.kakao;

import com.google.gson.annotations.SerializedName;

public class KakaoRequest {

    @SerializedName("kakao_id")
    public String kakaoid;
    public String getKakaoid(){
        return kakaoid;
    }
    public void setKakaoid(String kakaoid){
        this.kakaoid = kakaoid;
    }
    @SerializedName("name")
    public String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @SerializedName("nickname")
    public String nickname;
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

//    @SerializedName("email")
//    public String email;
//
//    public String getEmail(){
//        return email;
//    }
//    public void setEmail(String email){
//        this.email =email;
//    }

    public KakaoRequest (String kakaoid, String name, String nickname){
        this.kakaoid =kakaoid;
        this.name =name;
        this.nickname = nickname;
//        this.email = email;
    }
}
