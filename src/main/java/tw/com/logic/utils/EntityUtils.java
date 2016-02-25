package tw.com.logic.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.Column;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * EntityUtils
 * 
 * @author chrisryo
 *
 */
public class EntityUtils {

  /**
   * 所有欄位都使用模糊查詢
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  public static String getQueryEntitySql(Object entity) throws Exception {
    return getSql(entity, 0, 10000);
  }

  /**
   * 所有欄位都使用模糊查詢
   * 
   * @param entity
   * @param start
   * @param length
   * @return
   * @throws Exception
   */
  public static String getQueryEntitySql(Object entity, int start, int length) throws Exception {
    return getSql(entity, start, length);
  }

  /**
   * 所有欄位都使用模糊查詢
   * 
   * @param entity
   * @param start
   * @param length
   * @return
   * @throws Exception
   */
  private static String getSql(Object entity, Integer start, Integer length) throws Exception {

    boolean isHave = false;

    Method[] Methods = entity.getClass().getMethods();

    // getValue (select c : jpa select all 語法)
    StringBuffer sb =
        new StringBuffer("SELECT c FROM " + entity.getClass().getSimpleName() + " c WHERE ");
    for (Method m : Methods) {
      String name = m.getName();
      if (name.indexOf("get") == 0) {
        String val = ObjectUtils.toString(m.invoke(entity, new Object[] {}));

        // getColumn
        if (StringUtils.isNotEmpty(val)) {
          name = name.replace("get", "");

          Field[] fields = entity.getClass().getDeclaredFields();

          for (Field f : fields) {
            if (name.toUpperCase().equals(f.getName().toUpperCase())) {
              String str = f.getName();
              Column column = f.getAnnotation(Column.class);

              if (column != null) {
                str = column.name();
              }

              sb.append(str + " LIKE '%" + val + "%' AND ");
            }
          }
          isHave = true;
        }
      }
    }

    if (isHave) {
      int i = sb.lastIndexOf("AND");
      sb.delete(i, i + 3);
    }

    sb.append(" LIMIT " + start + ", " + length + " ");

    return sb.toString();
  }
}
