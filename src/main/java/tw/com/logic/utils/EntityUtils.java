package tw.com.logic.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import tw.com.logic.enums.DateStyle;

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
    return getSql(entity);
  }

  /**
   * 所有欄位都使用模糊查詢
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  private static String getSql(Object entity) throws Exception {

    // getValue (select c : jpa select all 語法)
    StringBuffer sb =
        new StringBuffer("SELECT c FROM " + entity.getClass().getSimpleName() + " c ");


    StringBuffer whereSb = new StringBuffer();
    setSqlWhere(entity, whereSb);

    if (whereSb.length() > 0) {
      sb.append(" WHERE ");

      int i = whereSb.lastIndexOf("AND");
      whereSb.delete(i, i + 3);

      sb.append(whereSb);

    }

    return sb.toString();
  }

  private static StringBuffer setSqlWhere(Object entity, StringBuffer whereSb) throws Exception {

    Method[] Methods = entity.getClass().getMethods();

    for (Method m : Methods) {
      String name = m.getName();

      // id 判斷
      // if ("getId".equals(name)) {
      // Object entityPk = m.invoke(entity, new Object[] {});
      // setSqlWhere(entityPk, whereSb);
      // } else {
      if (name.indexOf("get") == 0) {

        Object obj = m.invoke(entity, new Object[] {});
        String val = ObjectUtils.toString(obj);

        // getColumn
        if (StringUtils.isNotEmpty(val)) {
          name = name.replace("get", "");

          Field[] fields = entity.getClass().getDeclaredFields();

          for (Field f : fields) {
            if (name.toUpperCase().equals(f.getName().toUpperCase())) {

              String column = f.getName();
              Column columnT = f.getAnnotation(Column.class);

              if (columnT != null) {
                column = columnT.name();
              }

              // date format
              if (f.getType().isAssignableFrom(Date.class)) {

                String date = DateUtils.dateFormat((Date) obj, DateStyle.YYYY_MM_DD);

                whereSb.append(column + " = STR_TO_DATE('" + date + "','"
                    + DateStyle.YYYY_MM_DD.getSql() + "') AND ");
              } else {
                whereSb.append(column + " LIKE '%" + val + "%' AND ");
              }
            }
          }
        }
        // }
      }
    }

    return whereSb;
  }
}
