package tw.com.logic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import tw.com.logic.enums.DateStyle;

/**
 * 
 * @author chrisryo
 *
 */
public class DateUtils {

  /**
   * dateFormat
   * 
   * @param date
   * @param style
   * @return
   * @throws Exception
   */
  public static String dateFormat(Date date, DateStyle style) {
    if (date == null) {
      return "";
    }
    return new SimpleDateFormat(style.getFormat()).format(date);
  }

}
