package com.john.util.filestore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import com.john.util.Common;

public class FileDownload{
  private static File FILE;
  private static int FILE_LENGTH;
  private static String FILE_NAME;
  private static String FILE_TYPE;
  
  public static void setParamValue(File file) {
    FILE = file;
    FILE_NAME = Common.get(FILE.getName());
    FILE_LENGTH = Common.getInteger(FILE.length());
    FILE_TYPE = ContentPropeties.getContentType(FILE_NAME);
  }
  
  public static void getHttpResponseFile(File file, HttpServletResponse response)throws Exception{
    if(file == null)
      throw new NullPointerException();
    
    setParamValue(file);

    response.setContentLength(FILE_LENGTH);
    response.setContentType(FILE_TYPE);
    response.setHeader("Cache-control", "");
    response.setHeader("Content-Disposition", "attachment; filename=\"" + Common.encodeUTF8(FILE_NAME)  + "\"");
    
    FileInputStream is = null;
    OutputStream os = null;
    try {
      byte b[] = new byte[FILE_LENGTH];
      if (FILE.isFile()) {
        response.flushBuffer();
        is = new FileInputStream(FILE);
        os = response.getOutputStream();
        int read = 0;
        while ((read = is.read(b)) != -1) {
          os.write(b, 0, read);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (os!=null) os.close();
      if (is!=null) is.close();
    }
  }
}
