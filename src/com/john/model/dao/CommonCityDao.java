package com.john.model.dao;

import java.util.List;

import com.john.model.bo.CommonCity;
import com.john.service.IBaseService;

public interface CommonCityDao extends IBaseService{
  public List<CommonCity> getCityList();
}
