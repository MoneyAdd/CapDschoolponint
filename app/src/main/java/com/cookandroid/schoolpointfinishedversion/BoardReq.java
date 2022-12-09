package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

public class BoardReq {

    @SerializedName("board_title")
    public String boardtitle;

    @SerializedName("board_writing")
    public String boardwriting;

    @SerializedName("board_type")
    public String boardtype;



    @SerializedName("user_id")
    public String userid;



    public String getBoardtype() {
        return boardtype;
    }

    public void setBoardtype(String boardtype) {
        this.boardtype = boardtype;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }




    public String getBoardtitle() {
        return boardtitle;
    }

    public void setBoardtitle(String boardtitle) {
        this.boardtitle = boardtitle;
    }

    public String getBoardwriting() {
        return boardwriting;
    }

    public void setBoardwriting(String boardwriting) {
        this.boardwriting = boardwriting;
    }

    public BoardReq(String boardtitle, String boardwriting, String boardtype, String userid) {
        this.boardtitle = boardtitle;
        this.boardwriting = boardwriting;
        this.boardtype = boardtype;
        this.userid = userid;

    }
}
