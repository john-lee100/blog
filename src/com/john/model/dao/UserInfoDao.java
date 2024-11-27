package com.john.model.dao;

import java.util.Map;

import com.john.model.bo.UserInfo;
import com.john.service.IBaseService;

public interface UserInfoDao extends IBaseService {
  public UserInfo getUserInfoData(String account , String password);
  public void updateLastLoginDate(UserInfo user);
  public int countUserInfo(Map<String , Object> pramaMap);
}
