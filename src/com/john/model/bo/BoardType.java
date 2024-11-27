package com.john.model.bo;

import java.io.Serializable;
import java.util.Set;
/**
 * 項目:景點、旅遊
 */
public class BoardType implements Serializable{
    private int id;
    private String typeName;
    private String description;
    private Set<BoardInfomation> boardInfomation;
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getTypeName() {return typeName;}
    public void setTypeName(String typeName) {this.typeName = typeName;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Set<BoardInfomation> getBoardInfomation() {return boardInfomation;}
    public void setBoardInfomation(Set<BoardInfomation> boardInfomation) {this.boardInfomation = boardInfomation;}
}
