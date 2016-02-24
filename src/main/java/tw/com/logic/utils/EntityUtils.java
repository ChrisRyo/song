package tw.com.logic.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.Column;

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
	public static String getQueryEntitySql (Object entity) throws Exception {
		
		Method[] Methods = entity.getClass().getMethods();
		
		// getValue
		StringBuffer sb = new StringBuffer("SELECT * " + entity.getClass().getSimpleName() + " WHERE ");
		for (Method m : Methods) {
			String name = m.getName();
			if (name.indexOf("get") == 0) {
				Object val = (Object) m.invoke(entity, new Object[]{});
				
				// getColumn
				if (val != null) {
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
				}
			}
		}
		
		int i = sb.lastIndexOf("AND");
		sb.delete(i, 3);
		
		return sb.toString();
	}
}
