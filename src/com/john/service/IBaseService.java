package com.john.service;

import java.util.List;

public interface IBaseService extends ISumService , IParamService{
  
  public void save(Object obj);

  public void update(Object obj);

  public void delete(Object obj);

  public Object get(Class obj, int id);

  public List list(String sql);

  public void bulkUpdate(String query);

}
