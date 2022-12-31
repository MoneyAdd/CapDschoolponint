package com.cookandroid.schoolpointfinishedversion;

import android.util.Log;

public class ChatDTO {
    private String userName;
    private String message;

    public ChatDTO() {}
    public ChatDTO(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        Log.d("username", userName == null ? "null" : "!null");
        return userName;
    }

    public String getMessage() {
        return message;
    }
}
