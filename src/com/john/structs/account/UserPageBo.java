package com.john.structs.account;

import java.util.Map;

import com.john.model.bo.CommonArea;
import com.john.model.bo.UserInfo;
import com.john.model.service.ServiceDao;
import com.john.util.Common;

public class UserPageBo {
  
  public static UserInfo saveUserInfoData(Map<String , Object> pramaMap) {
    CommonArea commonArea = (CommonArea)
        ServiceDao.getInstance().getCommonAreaDao().get(CommonArea.class, Common.getInteger(pramaMap.get("area")));
    UserInfo userInfo = new UserInfo();
    userInfo.setAccount(Common.get(pramaMap.get("account")));
    userInfo.setPassword(Common.get(pramaMap.get("password")));
    userInfo.setUserName(Common.get(pramaMap.get("userName")));
    userInfo.setEmail(Common.get(pramaMap.get("email")));
    userInfo.setAddress(Common.get(pramaMap.get("address")));
    userInfo.setCommonArea(commonArea);
    ServiceDao.getInstance().getUserInfoDao().save(userInfo);
    return userInfo;
  }
  
  public static void updateLastLoginDate(UserInfo user) {
    ServiceDao.getInstance().getUserInfoDao().updateLastLoginDate(user);
  }
}
