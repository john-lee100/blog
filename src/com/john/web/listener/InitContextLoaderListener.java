package com.john.web.listener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.john.util.Common;
import com.john.util.jndi.Datasources;
import com.john.util.jndi.em.EnumDataBase;
import com.john.web.service.WebContextService;

public class InitContextLoaderListener extends ContextLoaderListener{
  
  public void contextInitialized(ServletContextEvent event) {
    super.contextInitialized(event); 
    
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      
      conn = Datasources.setDataProcess(EnumDataBase.Pool_SQLSERVER_CONN);
      
      if(conn == null)
        throw new NullPointerException();
      
      
      insertStringQuery(conn,st , rs , queryFilePath(event));
      
    }catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        if(rs != null) rs.close();
        if(st != null) st.close();
        if(conn != null) conn.close();
      }catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  private void insertStringQuery(Connection conn , Statement st , ResultSet rs , String queryFilePath)throws Exception {
    st = conn.createStatement();
    rs = st.executeQuery("select count(*) as count from blog.commoncity");

    while(rs.next())
      if(rs.getInt("count") > 0) 
        return;
    
    InputStream inputStream = new FileInputStream(new File(queryFilePath));
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
    String query = "";
    while (br.ready()) {
      query = Common.get(br.readLine());
      if (!"".equals(query)) 
        st.execute(query);
    }
    br.close();
    inputStream.close();
  }
  
  private String queryFilePath(ServletContextEvent event) {
    return  
      event.getServletContext().getRealPath(WebContextService.WEB_INF) + 
        File.separator + 
          event.getServletContext().getInitParameter("initCreateQuery");    
  }
}
