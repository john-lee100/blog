package com.john.model.dao.hibernate;

import java.util.List;

import com.john.model.bo.CommonCity;
import com.john.model.dao.CommonCityDao;
import com.john.service.hibernate.BaseServiceImpl;

public class CommonCityDaoImpl extends BaseServiceImpl implements CommonCityDao{
  public List<CommonCity> getCityList(){
    return getHibernateTemplate().loadAll(CommonCity.class);
  }
}
