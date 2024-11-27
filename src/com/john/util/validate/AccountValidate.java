package com.john.util.validate;

import java.util.List;

import com.john.persistence.PersistenceService;
import com.john.util.Common;

import net.sf.json.JSONObject;

public class AccountValidate {
  
  public String getAccountRepateInfo(Object[] obj) {
    
    JSONObject jsonObj = (JSONObject)obj[0];
    JSONObject item = new JSONObject();
    item.put("show", false);
    
    String account = Common.get(jsonObj.getString("account"));
    
    List<?> list = 
        PersistenceService.getInstance().getHibernateTemplate().find(" from UserInfo where account=?", account);
    if(list != null && !list.isEmpty()) {
      item.put("show", true);
      item.put("msg", "已重複註冊!");
    }
    
    return item.toString();
  }
}