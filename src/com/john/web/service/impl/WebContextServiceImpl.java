package com.john.web.service.impl;


import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.john.model.bo.UserInfo;
import com.john.web.service.WebContextService;


public class WebContextServiceImpl implements WebContextService{

  private HttpSession getSession() {
    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    HttpSession session = attr.getRequest().getSession(true);
    return session;
  }
  
  
  public UserInfo getUserInfo() {
    return (UserInfo) getSession().getAttribute(WebContextService.CURRENT_USERID);
  }
  
  public void setUserInfo(UserInfo user) {
    getSession().setAttribute(WebContextService.CURRENT_USERID , user);
  }
}
