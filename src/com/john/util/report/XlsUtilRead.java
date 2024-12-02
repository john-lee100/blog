package com.john.util.report;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.john.util.Common;

public class XlsUtilRead extends XlsUtil{
  
  public XlsUtilRead() {}
  
  public XlsUtilRead(String sourthName) {
    super(sourthName);
  }
  
  public XlsUtilRead(String sourthName, String sheetName, boolean firsHhead) {
    super(sourthName, sheetName, firsHhead);
  }
  
  public Map<String, List<List<String>>> readXLS() throws Exception {
    FileInputStream inputStream = new FileInputStream(sourthName);
    Map<String, List<List<String>>> sheetMap = new TreeMap<>();

    POIFSFileSystem fs = new POIFSFileSystem(inputStream);
    HSSFWorkbook wb = new HSSFWorkbook(fs);
    int sheetSize = wb.getNumberOfSheets();

    for (int i = 0; i < sheetSize; i++) {
      List<List<String>> rowList = new ArrayList<>();
      
      HSSFSheet sheet = wb.getSheetAt(i);
      int headers = sheet.getRow(sheet.getFirstRowNum()).getFirstCellNum();// 第一列
      int headere = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
      int rows = sheet.getFirstRowNum() + (firsHhead ? 1 : 0);//最上位置
      int rowe = sheet.getLastRowNum();//最後(求算到有資料的位置)
      
      //⬇
      for (int setRow = rows; setRow <= rowe; setRow++) {
        ArrayList<String> columnList = new ArrayList<String>();
        HSSFRow row = sheet.getRow(setRow);
        
        int columns = firsHhead ? headers : 0;//左
        int columne = firsHhead ? headere : (row == null ? 0 : row.getLastCellNum());//右
        if (row != null) {
          //➝
          for (int col = columns; col < columne; col++) {
            HSSFCell cell = row.getCell(col);

            if (cell != null) {
              if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                columnList.add(cell.getStringCellValue());
              } else if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                BigDecimal bd = new BigDecimal(Common.get(cell.getNumericCellValue()));
                columnList.add(bd.toPlainString());
              } else if (HSSFCell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
                columnList.add(String.valueOf(cell.getBooleanCellValue()));
              } else if (HSSFCell.CELL_TYPE_BLANK == cell.getCellType()) {
                columnList.add("");
              } else if (HSSFCell.CELL_TYPE_FORMULA == cell.getCellType()) {
                if (HSSFCell.CELL_TYPE_STRING == cell.getCachedFormulaResultType())
                  columnList.add(cell.getStringCellValue());
                if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCachedFormulaResultType())
                  columnList.add(String.valueOf(cell.getNumericCellValue()));
              }else columnList.add("");
            } else {
              columnList.add("");
            }
          }

        } else {
          if (firsHhead) {
            for (int col = columns; col < columne; col++) {
              columnList.add("");
            }
          }
        }
        rowList.add(columnList);
      }

      sheetMap.put(sheet.getSheetName(), rowList);
    }
    return sheetMap;
  }
  
  public static void main (String[] args) throws Exception{
    String path = "C:\\Users\\200\\Documents\\NetBeansProjects\\Excel_Demo\\src\\excel_demo\\demo1.xls";
    XlsUtilRead model = new XlsUtilRead(path);
    model.setFirsHhead(false);
    
    Map<String, List<List<String>>> readExcelMap = model.readXLS();
    
    for (String sheetName : readExcelMap.keySet()) {
      
      List<List<String>> rowList = readExcelMap.get(sheetName);
      System.out.println(sheetName);
      for (List<String> columnList : rowList) {
        if(columnList.isEmpty())
          System.out.println("空白");
        for (String data : columnList) 
          System.out.println("data:" + data);
        System.out.println("next");
      }
    }
  }
}
