package com.john.util;

import java.util.List;

public class OptionsUtil {
  
  public static String getOptionKeyValue(List listData, String tarObjIds, String defaultValue , boolean defaultOption) {
    StringBuilder sb = new StringBuilder();
    if (!"".equals(Common.get(tarObjIds))) {
      StringBuilder sbjs = new StringBuilder();

      sbjs.append(setOption(listData , defaultOption));
      sbjs.append(";");
      String js = sbjs.toString();

      String[] tarObjId = tarObjIds.split(",");
      for (int i = 0; i < tarObjId.length; i++) {
        sb.append("$(\'" + tarObjId[i] + "\').children().remove().end()");
        sb.append(js);
        sb.append(getDefaultOption(tarObjIds, defaultValue));
      }
    }
    return sb.toString();
  }
  
  public static String setOption(List listData , boolean defalOption) {
    StringBuilder sb = new StringBuilder();
    if(defalOption) {
      sb.append(appendOption("","請選擇"));
    }
    if (listData != null && listData.size() > 0) {
      for (Object obj : listData) {
        String value = String.valueOf(obj);
        String key = value;
        if (value.indexOf(",") > 0) {
          String str[] = value.split(",");
          key = str[0];
          value = str[1];
        }
        sb.append(appendOption(key, value));
      }
    }
    return sb.toString();
  }

  public static String appendOption(String value, String text) {
    StringBuilder sb = new StringBuilder();
    sb.append(".append('");
    sb.append("<option value=\"");
    sb.append(value);
    sb.append("\"");
    sb.append(">");
    sb.append(text);
    sb.append("</option>");
    sb.append("')");
    return sb.toString();
  }
  
  public static String getDefaultOption(String tarObjId, String defaultValue) {
    StringBuilder sb = new StringBuilder();
    String[] default_value = defaultValue.split(",");
    for (int i = 0; i < default_value.length; i++) {
      sb.append("$(\'" + tarObjId + "\')");
      sb.append(".children('[value=\"" + default_value[i] + "\"]').prop('selected',true);");
    }
    return sb.toString();
  }
}
