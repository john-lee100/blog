package com.john.service;

import java.util.Map;

public interface ISumService {
  
  public int loadCount(String hql, Map<String, Object> param);
  
}
