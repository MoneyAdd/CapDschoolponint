package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

public class BoardRes {
    @SerializedName("suc")
    public boolean suc;

    public boolean getSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }
}
