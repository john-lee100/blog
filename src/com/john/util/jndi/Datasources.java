package com.john.util.jndi;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.john.util.jndi.em.EnumDataBase;

public class Datasources {
  private static Context context = null;
  private static DataSource dataSource = null;
  
  public static Connection setDataProcess(EnumDataBase enumDataBase)throws Exception {
    context = getContextInit();
    dataSource = getDataSource(context , enumDataBase.getName());

    return getConnection(dataSource);
  }
  
  private static Context getContextInit() throws NamingException{
    return new InitialContext();
  }
  
  private static DataSource getDataSource(Context ctx , String DBName)throws NamingException{
    return (DataSource) ctx.lookup(DBName);
  }
  
  private static Connection getConnection(DataSource ds) throws SQLException{
    if(ds == null) 
      throw new NullPointerException();
    
    return ds.getConnection();
  }
}