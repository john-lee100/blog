package com.john.model.dao;

import java.util.List;

import com.john.model.bo.CommonArea;
import com.john.service.IBaseService;

public interface CommonAreaDao extends IBaseService{
  public List<CommonArea> getAreaList(int parentCityID);
}
