package com.john.model.dao.hibernate;

import java.util.List;

import com.john.model.bo.BoardType;
import com.john.model.dao.BoardTypeDao;
import com.john.service.hibernate.BaseServiceImpl;

public class BoardTypeDaoImpl extends BaseServiceImpl implements BoardTypeDao{
  public List<BoardType> getTypeList(){
    return getHibernateTemplate().loadAll(BoardType.class);
  }
}
