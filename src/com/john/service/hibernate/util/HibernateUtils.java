package com.john.service.hibernate.util;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.john.persistence.PersistenceService;

@Transactional
public class HibernateUtils {
  
  public HibernateTemplate getHibernateTemplate() {
    
    if(PersistenceService.getInstance() == null)
      throw new NullPointerException();
    
    return PersistenceService.getInstance().getHibernateTemplate();
    
  }
}
