package com.john.service.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.john.service.hibernate.util.HibernateUtils;


public class QueryParams extends HibernateUtils{
  
  public List loadParam(String hql, int start, int end, Map<String, Object> param) {
    List list = ((List) getHibernateTemplate().execute(new HibernateCallback() {
      public Object doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        for(String key : query.getNamedParameters()) {
          if (param != null && param.get(key) != null) {
            query.setParameter(key, param.get(key));
          }
        }
        return query.list();
      }
    }));
    return list;
  }
}
