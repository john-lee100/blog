package com.john.util.report;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;

import com.john.util.Common;

public class XlsUtilWrite extends XlsUtil{
  protected String templatePath;
  protected HSSFWorkbook wb;
  protected FileOutputStream output;
  protected int[] cellRepeatIndex;
  protected int[] autoWidth;
  protected boolean cellCommentVisible = false;
  protected Map<String , String> paramsMap;
  protected Map<String, List<Object[]>> dataMap;
  protected Map<String , String> cellCommentMap;//key(y,x)
  protected Map<String , Map<String , Object>> styleMap;//key(y,x)
  
  public XlsUtilWrite(String templatePath , Map<String , String> paramsMap, Map<String, List<Object[]>> dataMap){
    this.templatePath = templatePath;
    this.paramsMap = paramsMap;
    this.dataMap = dataMap;
  }
  
  
  public void writePOI() throws Exception{
    for(String sheetName : dataMap.keySet()) {
      HSSFSheet sheet = wb.getSheet(sheetName);
      List<Object[]> dataList = dataMap.get(sheetName);
      headPoi(sheet, paramsMap);
      stylePOI(sheet,styleMap);
    } 
  }
  
  public void drawComment(HSSFSheet sheet , HSSFRow row , HSSFCell cell) {
    if(cellCommentMap == null || cellCommentMap.size() == 0)
      return ;
    
    int rowIdx = row.getRowNum();
    int cellIdx = cell.getColumnIndex();
    String commStr = cellCommentMap.get(rowIdx+","+cellIdx);
    
    if(commStr == null || "".equals(commStr))
      return ;
    
    CreationHelper factory = wb.getCreationHelper();
    Drawing drawing = sheet.createDrawingPatriarch();
    ClientAnchor anchor = factory.createClientAnchor();
    anchor.setRow1(rowIdx+1);
    anchor.setRow2(rowIdx+3);
    anchor.setCol1(cellIdx+1);
    anchor.setCol2(cellIdx+3);
    Comment comment = drawing.createCellComment(anchor);
    RichTextString str = factory.createRichTextString(commStr);
    comment.setString(str);
    comment.setAuthor("System");
    comment.setVisible(cellCommentVisible);
    cell.setCellComment(comment);
  }
  
  public void bodyPoi(HSSFSheet sheet , List<Object[]> dataList) {
    for(int r = 0 ; r < dataList.size() ; r++) {
      Object[] column_Value = dataList.get(r);
      HSSFRow row = sheet.createRow(r);
      
      for(int c = 0 ; c < column_Value.length ; c++) {
        HSSFCell cell = row.createCell(c);
        drawComment(sheet , row , cell);
        
        if(column_Value[c] instanceof String) {
          cell.setCellValue(new HSSFRichTextString(Common.get(column_Value[c])));
        }else if(column_Value[c] instanceof Number) {
          cell.setCellValue(Common.getDouble(column_Value[c]));
        }else if(column_Value[c] instanceof Boolean) {
          cell.setCellValue((Boolean)column_Value[c]);
        }else if(column_Value[c] instanceof Date) {
          cell.setCellValue((Date)column_Value[c]);
        }else {
          cell.setCellValue(new HSSFRichTextString(Common.get(column_Value[c])));
        }
      }
    }
    
    if (autoWidth != null && autoWidth.length > 0) {
      for (int i = 0; i < autoWidth.length; i++) {
        sheet.autoSizeColumn(autoWidth[i]);
      }
    }
  }
  
  public void headPoi(HSSFSheet sheet , Map<String , String> replaceMap) {
    if(replaceMap == null || replaceMap.size() == 0) 
      return;
    
    HSSFHeader header = sheet.getHeader();
    
    String replaceStrValue;
    replaceStrValue = replaceHeadOrFoot(header.getLeft() , replaceMap);
    if(!"".equals(replaceStrValue)) 
      header.setLeft(replaceStrValue);
    
    replaceStrValue = replaceHeadOrFoot(header.getCenter() , replaceMap);
    if(!"".equals(replaceStrValue)) 
      header.setCenter(replaceStrValue);
    
    replaceStrValue = replaceHeadOrFoot(header.getRight() , replaceMap);
    if(!"".equals(replaceStrValue)) 
      header.setRight(replaceStrValue);
    
    HSSFFooter footer = sheet.getFooter();
    
    replaceStrValue = replaceHeadOrFoot(footer.getLeft() , replaceMap);
    if(!"".equals(replaceStrValue)) 
      footer.setLeft(replaceStrValue);
    
    replaceStrValue = replaceHeadOrFoot(footer.getCenter() , replaceMap);
    if(!"".equals(replaceStrValue)) 
      footer.setCenter(replaceStrValue);
    
    replaceStrValue = replaceHeadOrFoot(footer.getRight() , replaceMap);
    if(!"".equals(replaceStrValue)) 
      footer.setRight(replaceStrValue);
  }
  
  public void stylePOI(HSSFSheet sheet, Map styleMap) throws Exception{
    if(styleMap == null || styleMap.size() == 0)
      return;
    
    for(Object key : styleMap.keySet()) {
      String row_col = Common.get(key);
      String[] xy = row_col.split(",");
      Map fontMap = (Map)styleMap.get(key);
      
      HSSFRow row = sheet.getRow(Common.getInteger(xy[0]));
      if (null == row)
        continue;
      
      HSSFCell cell = row.getCell(Common.getInteger(xy[1]));
      if (cell == null)
        continue;
      
      if(fontMap == null || fontMap.size() == 0)
        return;
      
      for(Object fontName : fontMap.keySet()) {
        fontName = Common.get(fontName);
        String fontValue = Common.get(fontMap.get(fontName));
        
        if ("FONT".equals(fontName)) {
          HSSFFont font = sheet.getWorkbook().createFont();
          font.setFontName(fontValue);
          CellUtil.setFont(cell, sheet.getWorkbook(), font);
        }else if("DRAWLINE".equals(fontName)) {
          short propertyValue = (short)Common.getInteger(fontValue);
          CellUtil.setCellStyleProperty(cell, sheet.getWorkbook(), CellUtil.BORDER_TOP, propertyValue);
          CellUtil.setCellStyleProperty(cell, sheet.getWorkbook(), CellUtil.BORDER_BOTTOM, propertyValue);
          CellUtil.setCellStyleProperty(cell, sheet.getWorkbook(), CellUtil.BORDER_LEFT, propertyValue);
          CellUtil.setCellStyleProperty(cell, sheet.getWorkbook(), CellUtil.BORDER_RIGHT, propertyValue);
        }
      }
    }
  }
  
  public String replaceHeadOrFoot(String byReplaceStr , Map<String , String> replaceMap) {
    if("".equals(Common.get(byReplaceStr)))
      return "";
    
    for(String toReplaceStrKey : replaceMap.keySet()) {
      String replaceStrValue = replaceMap.get(toReplaceStrKey);
      byReplaceStr = byReplaceStr.replaceAll(toReplaceStrKey, replaceStrValue);
    }
    
    return byReplaceStr;
  }
  
  public void processExcel() throws Exception{
    initPOI();
    writePOI();
    outPutExcel();
  }
  
  public void initPOI() throws Exception{
    File file = new File(this.templatePath);
    wb = new HSSFWorkbook(new FileInputStream(file));
    if(wb != null && dataMap.size() > 1) {
      int sheetAt = 0;
      for(String sheetName :dataMap.keySet()) {
        cloneSheet(sheetAt);
        wb.setSheetName(sheetAt, sheetName);
        setRepeatingRowsAndColumns(sheetAt);
        sheetAt++;
      }
    }else if(wb != null && dataMap.size() == 1){
      String sheetName = dataMap.keySet().iterator().next().toString();
      wb.setSheetName(0, sheetName);
      setRepeatingRowsAndColumns(0);
    }
  }
  
  public void setRepeatingRowsAndColumns(int sheetAt) {
    if(cellRepeatIndex!=null && cellRepeatIndex.length == 4) {
      wb.setRepeatingRowsAndColumns(sheetAt, 
          cellRepeatIndex[0], 
          cellRepeatIndex[1], 
          cellRepeatIndex[2], 
          cellRepeatIndex[3]);  
    }
  }
  
  public void cloneSheet(int sheetAt) throws Exception{
    try {
      wb.getSheetAt(sheetAt);
    }catch (Exception e) {
      wb.cloneSheet(0);
    }
  }
  
  public void outPutExcel() throws Exception{
    output = new FileOutputStream(new File("D:\\writeTemp.xls"));
    wb.write(output);
    output.close();
  }
  
  public int[] getCellRepeatIndex() {return cellRepeatIndex;}
  public void setCellRepeatIndex(int[] cellRepeatIndex) {this.cellRepeatIndex = cellRepeatIndex;}
  public Map<String, String> getCellCommentMap() {  return cellCommentMap;}
  public void setCellCommentMap(Map<String, String> cellCommentMap) {this.cellCommentMap = cellCommentMap;}
  public boolean isCellCommentVisible() {return cellCommentVisible;}
  public void setCellCommentVisible(boolean cellCommentVisible) {this.cellCommentVisible = cellCommentVisible;}
  public int[] getAutoWidth() {return autoWidth;}
  public void setAutoWidth(int[] autoWidth) {this.autoWidth = autoWidth;}
  public Map<String, Map<String, Object>> getStyleMap() {return styleMap;}
  public void setStyleMap(Map<String, Map<String, Object>> styleMap) {this.styleMap = styleMap;}
}
