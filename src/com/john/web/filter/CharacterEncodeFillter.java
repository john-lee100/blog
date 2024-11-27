package com.john.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CharacterEncodeFillter implements Filter{
  private Logger log = Logger.getLogger(this.getClass());
  
  private static String encode;
  
  public void init(FilterConfig filterConfig) throws ServletException {
    encode = filterConfig.getInitParameter("encode");
  }
  
  public void doFilter(ServletRequest re, ServletResponse rs, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest)re;
    HttpServletResponse response = (HttpServletResponse)rs;
    response.setCharacterEncoding(encode);
    request.setCharacterEncoding(encode);
    
    log.info(getRequestServletName(request));
    chain.doFilter(request, response);
  }
  
  /**作業路徑*/
  private String getRequestServletName(HttpServletRequest request) {
    StringBuilder sb = new StringBuilder();
    sb.append("/").append(request.getLocalAddr());
    sb.append("/").append(request.getLocalName());
    sb.append("/").append(request.getServletPath());
    return sb.toString();
  }
  
  public void destroy() {}
}
