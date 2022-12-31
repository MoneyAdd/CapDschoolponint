package com.cookandroid.schoolpointfinishedversion;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class BulletinboardinRes {

    @SerializedName("suc")
    public boolean suc;


    @SerializedName("board_id")
    public String boardid;

    @SerializedName("board_title")
    public String boardtitle;

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getBoardtitle() {
        return boardtitle;
    }

    public void setBoardtitle(String boardtitle) {
        this.boardtitle = boardtitle;
    }

    @SerializedName("viewBoard")
    public ArrayList<Object> viewBoard;


    @Override
  public String toString(){
 return "{ , 게시글 : " +  " " + boardtitle + "}" + "\n";
  }

}
