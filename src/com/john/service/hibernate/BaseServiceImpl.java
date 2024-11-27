package com.john.service.hibernate;

import java.util.List;
import java.util.Map;

import com.john.service.IBaseService;
import com.john.service.hibernate.util.HibernateUtils;

public class BaseServiceImpl extends HibernateUtils implements IBaseService{
  private QueryCount queryCount;
  private QueryParams queryParams;
  
  public BaseServiceImpl() {
    try {
      queryCount = (QueryCount)Class.forName(QueryCount.class.getCanonicalName()).newInstance();
      queryParams = (QueryParams)Class.forName(QueryParams.class.getCanonicalName()).newInstance();
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void save(Object obj) {
    getHibernateTemplate().save(obj);
  }

  public void update(Object obj) {
    getHibernateTemplate().update(obj);
  }

  public void delete(Object obj) {
    getHibernateTemplate().delete(obj);
  }

  public Object get(Class obj, int id) {
    return getHibernateTemplate().get(obj, id);
  }

  public List list(String sql) {
    return getHibernateTemplate().find(sql);
  }

  public void bulkUpdate(String query) {
    getHibernateTemplate().bulkUpdate(query);
  }
  
  public int loadCount(String hql, Map<String, Object> param) {
    return queryCount.loadCount(hql, param);
  }
  
  public List loadParam(String hql, int from, int to, Map<String, Object> param) {
    return queryParams.loadParam(hql, from, to, param);
  }
}
