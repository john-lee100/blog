package com.john.model.bo;

import java.io.Serializable;
/**
 * 紀錄項目資訊
 */
public class BoardInfomation implements Serializable{
    private int id;
    private String boardsname;
    private int readcount;
    private int replycoun;
    private String description;
    private String createDate;
    private String createTime;
    private BoardType boardType;
    private UserInfo userInfo;
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getBoardsname() {return boardsname;}
    public void setBoardsname(String boardsname) {this.boardsname = boardsname;}
    public int getReadcount() {return readcount;}
    public void setReadcount(int readcount) {this.readcount = readcount;}
    public int getReplycoun() {return replycoun;}
    public void setReplycoun(int replycoun) {this.replycoun = replycoun;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getCreateDate() {return createDate;}
    public void setCreateDate(String createDate) {this.createDate = createDate;}
    public String getCreateTime() {return createTime;}
    public void setCreateTime(String createTime) {this.createTime = createTime;}
    public BoardType getBoardType() {return boardType;}
    public void setBoardType(BoardType boardType) {this.boardType = boardType;}
    public UserInfo getUserInfo() {return userInfo;}
    public void setUserInfo(UserInfo userInfo) {this.userInfo = userInfo;}
}
