package com.john.structs.util;

import com.john.model.bo.BoardType;
import com.john.model.bo.CommonArea;
import com.john.model.bo.CommonCity;
import com.john.model.service.ServiceDao;
import com.john.util.Common;
import com.john.util.OptionsUtil;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import java.util.*;

public class OptionsAction extends DispatchAction {
  /** 縣市下拉選單*/
  public ActionForward getCityOptions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      String tarObjIds = Common.get(request.getParameter("tarObjIds"));
      String defaultValue = Common.get(request.getParameter("defaultValue"));
      List<CommonCity> cityList = ServiceDao.getInstance().getCommonCityDao().getCityList();
      List<String> beanPropertyList = Common.getBeansProperty(cityList, city -> city.getId()+","+ city.getCityName());
      String options = OptionsUtil.getOptionKeyValue(beanPropertyList, tarObjIds, defaultValue , true);
      PrintWriter out = response.getWriter();
      out.println(options);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  /** 鄉鎮下拉選單*/
  public ActionForward getAreaOptions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      String tarObjIds = Common.get(request.getParameter("tarObjIds"));
      String defaultValue = Common.get(request.getParameter("defaultValue"));
      String parentValue = Common.get(request.getParameter("parentValue"));
      List<CommonArea> areaList = ServiceDao.getInstance().getCommonAreaDao().getAreaList(Common.getInteger(parentValue));
      List<String> beanPropertyList = Common.getBeansProperty(areaList, area -> area.getId()+","+ area.getAreaName());
      String options = OptionsUtil.getOptionKeyValue(beanPropertyList, tarObjIds, defaultValue , false);
      PrintWriter out = response.getWriter();
      out.println(options);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  /** board類別下拉選單*/
  public ActionForward getTypeOptions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      String tarObjIds = Common.get(request.getParameter("tarObjIds"));
      String defaultValue = Common.get(request.getParameter("defaultValue"));
      List<BoardType> typeList = ServiceDao.getInstance().getBoardTypeDao().getTypeList();
      List<String> beanPropertyList = Common.getBeansProperty(typeList, type -> type.getId()+","+ type.getTypeName());
      String options = OptionsUtil.getOptionKeyValue(beanPropertyList, tarObjIds, defaultValue , true);
      PrintWriter out = response.getWriter();
      out.println(options);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
