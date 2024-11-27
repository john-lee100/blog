package com.john.web.online;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class CurrentUser {
  private static ConcurrentMap<Integer, UserBean> container = new ConcurrentHashMap<>();
  private static CurrentUser instance = new CurrentUser();
  
  public static CurrentUser getInstance() {
    return instance;
  }
  
  public void put(UserBean user) {
    container.put(user.getId(), user);
  }
  
  public void remove(int userId) {
    container.remove(userId);
  }
  
  public int size() {
    return container.size();
  }
}
