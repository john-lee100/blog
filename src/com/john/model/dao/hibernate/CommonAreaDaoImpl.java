package com.john.model.dao.hibernate;

import java.util.List;

import com.john.model.bo.CommonArea;
import com.john.model.dao.CommonAreaDao;
import com.john.service.hibernate.BaseServiceImpl;

public class CommonAreaDaoImpl extends BaseServiceImpl implements CommonAreaDao{
  @SuppressWarnings("unchecked")
  public List<CommonArea> getAreaList(int parentCityID){
    try {
      List<?> list = this.getHibernateTemplate().find(" from CommonArea where commonCity.id = ? ", parentCityID);
      return (List<CommonArea>) list;
    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
