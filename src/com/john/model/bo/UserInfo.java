package com.john.model.bo;
/**
 *使用者
 */
public class UserInfo {
  private Integer id;
  private String account;
  private String password;
  private String userName;
  private String email;
  private String lastLoginDate;
  private String lastLoginTime;
  private String address;
  private CommonArea commonArea;
  
  public Integer getId() {return id;}
  public void setId(Integer id) {this.id = id;}
  public String getAccount() {return account;}
  public void setAccount(String account) {this.account = account;}
  public String getPassword() {return password;}
  public void setPassword(String password) {this.password = password;}
  public String getUserName() {return userName;}
  public void setUserName(String userName) {this.userName = userName;}
  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}
  public CommonArea getCommonArea() {return commonArea;}
  public void setCommonArea(CommonArea commonArea) {this.commonArea = commonArea;}
  public String getLastLoginDate() {return lastLoginDate;}
  public void setLastLoginDate(String lastLoginDate) {this.lastLoginDate = lastLoginDate;}
  public String getLastLoginTime() {return lastLoginTime;}
  public void setLastLoginTime(String lastLoginTime) {this.lastLoginTime = lastLoginTime;}
  public String getAddress() {return address;}
  public void setAddress(String address) {this.address = address;}
}
