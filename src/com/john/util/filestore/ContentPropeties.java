package com.john.util.filestore;

import java.util.Locale;
import java.util.ResourceBundle;

import com.john.util.Common;

public class ContentPropeties {
  static ResourceBundle resource = null;
  
  static {
    try {
      resource = ResourceBundle.getBundle("com.john.util.filestore.htmltype",Locale.getDefault());
    }catch (Exception e) {
      throw new NullPointerException("can't load properties");
    }
  }
  
  public static String getContentType(String fileName) {
    int index = fileName.lastIndexOf(".");
    if(index == -1) 
      throw new IllegalStateException();
    return Common.get(resource.getString(fileName.substring(index+1)));
  }
}
