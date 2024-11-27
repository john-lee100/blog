package com.john.util.jndi.em;

/**
 * 資料庫連接
 * */
public enum EnumDataBase {
  Pool_MySQL_CONN("java:comp/env/jdbc/mysqlconn"),
  Pool_SQLSERVER_CONN("java:comp/env/jdbc/sqlserverconn");
  
  private String name;
  
  private EnumDataBase(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  public static EnumDataBase getEnumDataBase(String datasource) {
    for(EnumDataBase dbsource :EnumDataBase.values()) {
      if(dbsource.toString().equals(datasource)) {
        return dbsource;
      }
    }
    return null;
  }
}
