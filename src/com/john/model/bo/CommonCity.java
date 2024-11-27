package com.john.model.bo;

import java.io.Serializable;
/**
 *縣市  
 */
public class CommonCity implements Serializable{
    private Integer id;
    private String cityCode;
    private String cityName;
    
    public CommonCity() {}
    public CommonCity(Integer id) {this.id = id;}
    public CommonCity(Integer id, String cityCode, String cityName) {
      this.id = id;
      this.cityCode = cityCode;
      this.cityName = cityName;
    }
    
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getCityCode() {return cityCode;}
    public void setCityCode(String cityCode) {this.cityCode = cityCode;}
    public String getCityName() {return cityName;}
    public void setCityName(String cityName) {this.cityName = cityName;}
}
