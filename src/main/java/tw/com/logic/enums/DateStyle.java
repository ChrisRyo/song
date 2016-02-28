package tw.com.logic.enums;

/**
 * 
 * @author chrisryo
 *
 */
public enum DateStyle {
  // java語法 , mysql語法
  YYYY_MM_DD("yyyy-MM-dd", "%Y-%m-%d");

  private final String format;
  private final String sql;

  private DateStyle(String format, String sql) {
    this.format = format;
    this.sql = sql;
  }

  public String getFormat() {
    return format;
  }

  public String getSql() {
    return sql;
  }

}
