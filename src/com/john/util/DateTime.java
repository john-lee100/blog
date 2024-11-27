package com.john.util;

import java.util.Calendar;

public class DateTime {

  public static String getYYYMMDD() {
    StringBuffer sb = new StringBuffer();
    Calendar cal = Calendar.getInstance();
    int y = cal.get(Calendar.YEAR) - 1911;
    int m = cal.get(Calendar.MONTH) + 1;
    int d = cal.get(Calendar.DATE);
    
    sb.append(Common.formatZero(Common.get(y),3, '0'));
    sb.append(Common.formatZero(Common.get(m),2, '0'));
    sb.append(Common.formatZero(Common.get(d),2, '0'));
    return sb.toString();
  }

  public static String getHHMMSS() {
    Calendar calendar = Calendar.getInstance();
    String hh, mi, ss;

    hh = Common.get(calendar.get(Calendar.HOUR_OF_DAY));
    mi = Common.get(calendar.get(Calendar.MINUTE));
    ss = Common.get(calendar.get(Calendar.SECOND));

    hh = Common.formatZero(hh, 2, '0');
    mi = Common.formatZero(mi, 2, '0');
    ss = Common.formatZero(ss, 2, '0');
    return hh + mi + ss;
  }
}
