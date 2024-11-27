package com.john.structs.account;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.john.model.bo.UserInfo;
import com.john.model.service.ServiceDao;
import com.john.util.Common;
import com.john.web.service.WebContextService;

public class UserPageAction extends DispatchAction {
  /**使用者登錄*/
  public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    String account = request.getParameter("account");
    String password = request.getParameter("password");

    UserInfo user = ServiceDao.getInstance().getUserInfoDao().getUserInfoData(account, password);
    
    if(user == null) {
      request.setAttribute(WebContextService.ERROR_MESSAGE, "帳密輸入錯誤。請重新登入");
      return mapping.findForward("index");
    }
    
    UserPageBo.updateLastLoginDate(user);
    
    ServiceDao.getInstance().getWebContextService().setUserInfo(user);
    
    return mapping.findForward("initBoardPage");
  }
  
  /**使用者註冊*/
  public ActionForward signUp(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map<String , Object> pramaMap = Common.jspParameters(request);
    
    int userCount = 
        ServiceDao.getInstance().getUserInfoDao().countUserInfo(pramaMap);
    
    if(userCount > 0) {
      request.setAttribute(WebContextService.ERROR_MESSAGE, "此帳號已註冊");
      return mapping.findForward("signUp");
    }
    
    UserPageBo.saveUserInfoData(pramaMap);
    
    request.setAttribute(WebContextService.SUCCESS_MESSAGE, "帳號註冊成功!");
    return mapping.findForward("index");
  }
  
  /**登出*/
  public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().removeAttribute(WebContextService.CURRENT_USERID);
    request.setAttribute(WebContextService.SUCCESS_MESSAGE, "登出成功!");
    return mapping.findForward("index");
  }
  
}
