package com.john.web.service;


import com.john.model.bo.UserInfo;

public interface WebContextService{
  
  public static final String WEB_INF = "WEB-INF";
  public static final String CURRENT_USERID = "CURRENT_USERID";
  public static final String CURRENT_USERBEAN = "CURRENT_USERBEAN";
  public static final String SUCCESS_MESSAGE = "SUCCESS_MESSAGE";
  public static final String ERROR_MESSAGE = "ERROR_MESSAGE";
  public static final String LOGIN_COUNT = "LOGIN_COUNT";

  public UserInfo getUserInfo();
  
  public void setUserInfo(UserInfo user);
}
