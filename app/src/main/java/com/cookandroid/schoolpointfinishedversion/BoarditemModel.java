package com.cookandroid.schoolpointfinishedversion;

public class BoarditemModel {

    String title;
    String content;
    String type;
    String userid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BoarditemModel(String title, String content, String type, String userid) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.userid = userid;
    }
}
