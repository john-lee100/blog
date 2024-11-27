package com.john.util.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.john.util.DateTime;

public class DateTag extends SimpleTagSupport{
  
  /** 是否唯獨 */
  private boolean dateReadOnly;
  public void setDateReadOnly(boolean dateReadOnly) {this.dateReadOnly = dateReadOnly;}

  @Override
  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
    out.print(setDateTime(dateReadOnly));
  }
  
  private String setDateTime(boolean isReadOnlyDate) {
    StringBuilder sb = new StringBuilder();
    sb.append("<input "
        + "type='text' "
        + "class='dtime' "
        + "id='createDate' "
        + "name='createDate' "
        + "size='5' "
        + "value='").append(DateTime.getYYYMMDD()).append("' ").append(
           isReadOnlyDate?"readOnly":"").append("/> ");

    return sb.toString();
  }
}