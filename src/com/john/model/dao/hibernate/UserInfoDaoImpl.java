package com.john.model.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.john.model.bo.UserInfo;
import com.john.model.dao.UserInfoDao;
import com.john.service.hibernate.BaseServiceImpl;
import com.john.util.Common;
import com.john.util.DateTime;

public class UserInfoDaoImpl extends BaseServiceImpl implements UserInfoDao {
  
  public UserInfo getUserInfoData(String account, String password) {
    List<?> list = 
        getHibernateTemplate().find(" from UserInfo where account=? and password=? ", Common.get(account), Common.get(password));

    if (list.isEmpty()) 
      return null;
    
    return (UserInfo) list.get(0);
  }
  
  public void updateLastLoginDate(UserInfo user){
    if(user == null) 
      throw new NullPointerException();
    
    user.setLastLoginDate(DateTime.getYYYMMDD());
    user.setLastLoginTime(DateTime.getHHMMSS());
    update(user);
  }
  
  public int countUserInfo(Map<String , Object> pramaMap){
    return loadCount(" from UserInfo where account=:account " , pramaMap);
  }
}
