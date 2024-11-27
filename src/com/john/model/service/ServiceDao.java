package com.john.model.service;

import org.springframework.beans.factory.InitializingBean;

import com.john.model.dao.BoardInfomationDao;
import com.john.model.dao.BoardTypeDao;
import com.john.model.dao.CommonAreaDao;
import com.john.model.dao.CommonCityDao;
import com.john.model.dao.UserInfoDao;
import com.john.web.service.WebContextService;

public class ServiceDao implements InitializingBean{
  
  private static ServiceDao instance;
  private CommonCityDao commonCityDao;
  private CommonAreaDao commonAreaDao;
  private UserInfoDao userInfoDao;
  private BoardTypeDao boardTypeDao;
  private BoardInfomationDao boardInfomationDao;
  private WebContextService webContextService;
  
  @Override
  public void afterPropertiesSet() throws Exception {
    if(instance != null) 
      throw new Exception(this.getClass().getCanonicalName() + " Instance Error");
    instance = this;
  }
  
  public static ServiceDao getInstance() {
    return instance;
  }
  
  //Getter
  public CommonCityDao getCommonCityDao() {return commonCityDao;}
  public CommonAreaDao getCommonAreaDao() {return commonAreaDao;}
  public UserInfoDao getUserInfoDao() {return userInfoDao;}
  public BoardTypeDao getBoardTypeDao() {return boardTypeDao;}
  public BoardInfomationDao getBoardInfomationDao() {return boardInfomationDao;}
  public WebContextService getWebContextService() {return webContextService;}
  
  //Setter
  public void setCommonCityDao(CommonCityDao commonCityDao) {this.commonCityDao = commonCityDao;}
  public void setCommonAreaDao(CommonAreaDao commonAreaDao) {this.commonAreaDao = commonAreaDao;}
  public void setUserInfoDao(UserInfoDao userInfoDao) {this.userInfoDao = userInfoDao;}
  public void setBoardTypeDao(BoardTypeDao boardTypeDao) {this.boardTypeDao = boardTypeDao;}
  public void setBoardInfomationDao(BoardInfomationDao boardInfomationDao) {this.boardInfomationDao = boardInfomationDao;}
  public void setWebContextService(WebContextService webContextService) {this.webContextService = webContextService;}
}
