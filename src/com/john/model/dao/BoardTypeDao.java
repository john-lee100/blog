package com.john.model.dao;

import java.util.List;

import com.john.model.bo.BoardType;
import com.john.service.IBaseService;

public interface BoardTypeDao extends IBaseService{
  public List<BoardType> getTypeList();
}
