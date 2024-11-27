package com.john.service.hibernate;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.john.service.hibernate.util.HibernateUtils;


public class QueryCount extends HibernateUtils{
  
  public int loadCount(String hql, Map<String, Object> param) {
    Number number = ((Number) getHibernateTemplate().execute(new HibernateCallback() {
      public Object doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery("select count(*) " + hql);
        for(String key : query.getNamedParameters()) {
          if (param != null && param.get(key) != null) {
            query.setParameter(key, param.get(key));
          }
        }
        return query.uniqueResult();
      }
    }));
    
    return number.intValue();
  }
}
