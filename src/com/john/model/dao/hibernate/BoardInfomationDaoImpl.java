package com.john.model.dao.hibernate;

import java.util.List;

import com.john.model.bo.BoardInfomation;
import com.john.model.dao.BoardInfomationDao;
import com.john.service.hibernate.BaseServiceImpl;

public class BoardInfomationDaoImpl extends BaseServiceImpl implements BoardInfomationDao{
  public BoardInfomation getBoardInfomation(int boardID) {
    List<?> list = 
        getHibernateTemplate().find(" from BoardInfomation where id=? ",boardID);
    
    if (list.isEmpty())
      throw new IllegalStateException();
    
    return (BoardInfomation)list.get(0);
  }
}
