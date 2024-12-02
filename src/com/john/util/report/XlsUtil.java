package com.john.util.report;

import java.util.List;
import java.util.Map;

public class XlsUtil {
  String sourthName;
  String patternName;
  String sheetName;
  boolean firsHhead;
  boolean isAutoWidth;
  List<CellHeader> headList;
  List<Object[]> dataList;
  
  public XlsUtil() {}
  
  public XlsUtil(String sourthName) {
    this.sourthName = sourthName;
    
  }
  
  public XlsUtil(String sourthName, String sheetName, boolean firsHhead) {
    this.sourthName = sourthName;
    this.sheetName = sheetName;
    this.firsHhead = firsHhead;
  }
  
  public XlsUtil(List<CellHeader> headList, List<Object[]> dataList) {
    this.headList = headList;
    this.dataList = dataList;
  }

  public String getSourthName() {
    return sourthName;
  }

  public void setSourthName(String sourthName) {
    this.sourthName = sourthName;
  }

  public String getPatternName() {
    return patternName;
  }

  public void setPatternName(String patternName) {
    this.patternName = patternName;
  }

  public String getSheetName() {
    return sheetName;
  }

  public void setSheetName(String sheetName) {
    this.sheetName = sheetName;
  }

  public boolean isFirsHhead() {
    return firsHhead;
  }

  public void setFirsHhead(boolean firsHhead) {
    this.firsHhead = firsHhead;
  }

  public boolean isAutoWidth() {
    return isAutoWidth;
  }

  public void setAutoWidth(boolean isAutoWidth) {
    this.isAutoWidth = isAutoWidth;
  }

  public List<CellHeader> getHeadList() {
    return headList;
  }

  public void setHeadList(List<CellHeader> headList) {
    this.headList = headList;
  }

  public List<Object[]> getDataList() {
    return dataList;
  }

  public void setDataList(List<Object[]> dataList) {
    this.dataList = dataList;
  }
}
