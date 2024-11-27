package com.john.model.bo;

import java.io.Serializable;
/**
 * 回復
 */
public class BoardReply implements Serializable{
    private int id;
    private String message;
    private int userID;
    private String userName;
    private String createDate;
    private String createTime;
    private BoardInfomation boardInfomation;
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public int getUserID() {return userID;}
    public void setUserID(int userID) {this.userID = userID;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getCreateDate() {return createDate;}
    public void setCreateDate(String createDate) {this.createDate = createDate;}
    public String getCreateTime() {return createTime;}
    public void setCreateTime(String createTime) {this.createTime = createTime;}
    public BoardInfomation getBoardInfomation() {return boardInfomation;}
    public void setBoardInfomation(BoardInfomation boardInfomation) {this.boardInfomation = boardInfomation;}
}