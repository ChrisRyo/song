package tw.com.jersey.interceptors;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

import tw.com.jersey.annotation.GridDataToDto;

/**
 * 
 * @author chris
 * @version 1.0 2016-02-26 add volidGroup
 *
 */
@Provider
@GridDataToDto
public class GridDataReadInterceptor implements ReaderInterceptor {

  @Context
  HttpServletRequest request;

  @Override
  public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException,
      WebApplicationException {

    Object bean = context.proceed();

    try {
      bean = context.getType().newInstance();

      this.transMapToBean(request.getParameterMap(), bean);
    } catch (Exception e) {
//      Response.status(405).entity(e.getMessage()).build();
    }

    return bean;
  }

  private void transMapToBean(@SuppressWarnings("rawtypes") Map map, Object obj)
      throws IntrospectionException {


    BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

    for (PropertyDescriptor property : propertyDescriptors) {
      String key = property.getName();

      if (map.containsKey(key)) {
        Object value = map.get(key);
        // 得到property对应的setter方法
        Method setter = property.getWriteMethod();
        try {
          if (Date.class.equals(property.getPropertyType())) {
//            value = new Date(
          }
          setter.invoke(obj, value);
        } catch (Exception e) {
          System.out.print(e.getMessage());
        }
      }
    }
  }
}
