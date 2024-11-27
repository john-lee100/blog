package com.john.persistence;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.john.service.IBaseService;

public class PersistenceService implements InitializingBean{
  
  private static PersistenceService instance;
  private HibernateTemplate hibernateTemplate;
  private IBaseService iBaseService;
  
  @Override
  public void afterPropertiesSet() throws Exception {
    if(instance != null) 
      throw new Exception(this.getClass().getCanonicalName() + " Instance Error");
    instance = this;
  }
  
  public static PersistenceService getInstance() {
    return instance;
  }

  public IBaseService getIBaseService() {return iBaseService;}
  public HibernateTemplate getHibernateTemplate() {return hibernateTemplate;}
  public void setIBaseService(IBaseService iBaseService) {this.iBaseService = iBaseService;}
  public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {this.hibernateTemplate = hibernateTemplate;}
}