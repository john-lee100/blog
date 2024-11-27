package com.john.model.dao;

import com.john.model.bo.BoardInfomation;
import com.john.service.IBaseService;

public interface BoardInfomationDao extends IBaseService{
  public BoardInfomation getBoardInfomation(int boardID);
}
