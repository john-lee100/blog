package com.john.service;

import java.util.List;
import java.util.Map;

public interface IParamService {

  public List loadParam(String hql, int from, int to, Map<String, Object> param);
  
}
