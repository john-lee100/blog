package com.john.model.bo;

import java.io.Serializable;
/**
 * 鄉鎮市區
 */
public class CommonArea implements Serializable{
  private Integer id;
  private String zipCode;
  private String areaName;
  private CommonCity commonCity;
  
  public Integer getId() {return id;}
  public void setId(Integer id) {this.id = id;}
  public String getZipCode() {return zipCode;}
  public void setZipCode(String zipCode) {this.zipCode = zipCode;}
  public String getAreaName() {return areaName;}
  public void setAreaName(String areaName) {this.areaName = areaName;}
  public CommonCity getCommonCity() {return commonCity;}
  public void setCommonCity(CommonCity commonCity) {this.commonCity = commonCity;}
}
