package com.john.web.online;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.john.model.bo.UserInfo;
import com.john.web.service.WebContextService;

public class CurrentUserListener implements HttpSessionAttributeListener{

  @Override
  public void attributeAdded(HttpSessionBindingEvent event) {
    HttpSession session = event.getSession();
    if(event.getValue() instanceof UserInfo) {
      UserInfo user = (UserInfo)session.getAttribute(WebContextService.CURRENT_USERID);
      CurrentUser.getInstance().put(new UserBean(user.getId() , user.getUserName()));
    }
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent event) {
    if(event.getValue() instanceof UserInfo) {
      UserInfo user = (UserInfo)event.getValue();
      CurrentUser.getInstance().remove(user.getId());
    }
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent event) {
    HttpSession session = event.getSession();
    if(event.getValue() instanceof UserInfo) {
      UserInfo user = (UserInfo)session.getAttribute(WebContextService.CURRENT_USERID);
      CurrentUser.getInstance().put(new UserBean(user.getId() , user.getUserName()));
    }
  }
}
