package com.john.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;

public class Common {
  public static final int READ_SIZE = 1;
  public static final int REPLY_SIZE = 1;

  public static String get(String s) {
    return s == null ? "" : s.trim();
  }

  public static String get(Object s) {
    return s == null ? "" : s.toString().trim();
  }

  /** 
   * <br>將Bean的屬性取出來
   * <br>範例:getBeansProperty(List<Bean> , e -> e.getName());
   * <br>return List<String>
   */
  public static <Bean, R> List<R> getBeansProperty(Collection<Bean> beans, Function<Bean, R> function) {
    return beans
        .stream()
        .map(function)
        .collect(Collectors.toList());
  }
  
  /**
   * 組合  SQL IN List
   * @param data 
   * @param size 1組List放幾個
   * @return map
   */
  public static <T> Map slitList(List<? extends T> data, int size) {
    Map map = new HashMap();
    int key = -1;
    for (int i = 0; i < data.size(); i++) {
      
      if (i % size == 0) {
        key = i;
        map.put(key, new ArrayList());
      }
      
      ((List<T>)map.get(key)).add(data.get(i));
    }
    
    return map;
  }
  
  /**
   * <br>SQL IN
   * <br>return ('n','m')
   */
  public static String sqlChar(List<?> e) {
    return e.stream()
        .map(Object::toString)
        .collect(Collectors.joining("','", "'", "'"));
  }
  
  /**
   * <br>SQL IN
   * <br>return ('n','m')
   */
  public static <E> String sqlChar(E[] e) {
    return Stream.of(e)
        .map(Object::toString)
        .collect(Collectors.joining("','", "'", "'"));
  }
  
  /**
   * 編碼
   * @param text
   */
  public static String encodeUTF8(Object s) throws Exception {
    return URLEncoder.encode(get(s), StandardCharsets.UTF_8.name());
  }

  /**
   * 解碼
   * @param text
   */
  public static String decodeUTF8(Object s) throws Exception {
    return URLDecoder.decode(get(s), StandardCharsets.UTF_8.name());
  }

  /**
   * <br>補零
   * <br>@param s、size、char
   * <br>formatZero(2 ,3 ,'0') return 002
   */
  public static String formatZero(Object s, int size, char ch) {
    StringBuilder sb = new StringBuilder();
    
    int len = size - get(s).length();
    
    for (int i = 0; i < len ; i++) 
      sb.append(ch);
    
    return sb.append(s).toString();
  }
  
  /**
   * 取得前端參數
   * @param request
   */
  public static Map<String, Object> jspParameters(HttpServletRequest request) {
    Map<String, Object> map = new HashMap<String, Object>();
    Enumeration<String> paramEnum = request.getParameterNames();
    
    while (paramEnum.hasMoreElements()) {
      String tagName = get(paramEnum.nextElement());
      String value = get(request.getParameter(tagName));
      String[] arrys = request.getParameterValues(tagName);
      map.put(tagName, (arrys.length > 1) ? arrys : value);
    }
    
    return map;
  }
  
  /**
   * 轉JSON格式
   * @param request
   */
  public static Object getJsonObj(HttpServletRequest request) {
    JSONObject jsonObject = null;
    try {
      StringBuilder sb = new StringBuilder();
      BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
      String line = null;
      while((line = br.readLine()) != null) {
        sb.append(line);
      }
      br.close();
      jsonObject = JSONObject.fromObject(sb.toString());

    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonObject;
  }

  /**
   * 取得Integer
   */
  public static int getInteger(Object s) {
    Double d = getDouble(s);
    return d.intValue();
  }

  /**
   * 取得Double
   */
  public static double getDouble(Object s) {
    if ("".equals(get(s))) return 0;
    try {
      s = get(s).replaceAll(",", "");
      if (Double.isNaN(Double.parseDouble(get(s))) || Double.isInfinite(Double.parseDouble(get(s))))
        return 0;
      else
        return Double.parseDouble(get(s));
    } catch (Exception e) {
      return 0;
    }
  }
  
  public static int setReadSize(int total) {
    return total + READ_SIZE;
  }
  public static int setReplySize(int total) {
    return total + REPLY_SIZE;
  }
}
