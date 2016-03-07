package tw.com.view.message;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;
import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang.ObjectUtils;

import tw.com.logic.constraint.common.ValidCustom;
import tw.com.logic.exception.code.ResultCode;
import tw.com.logic.exception.code.ValidCode;

/**
 * 返回訊息
 * 
 * @author chris
 * @version 1.0 2016-02-23
 * @version 1.1 2016-03-03 增加自定義回傳方式
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ReturnMessage {

  // 結果代碼
  private int resultCode;

  // 資料
  private Object data = new Object();

  // 擴充資料
  private Object other = new Object();

  /**
   * 
   * @param valid
   * @param errorCode
   */
  public ReturnMessage(int resultCode, Object data) {
    this.resultCode = resultCode;
    this.data = data;
  }

  /**
   * 2016-03-03 增加自定義valid訊息
   * 
   * @param ConstraintViolationException
   */
  public ReturnMessage(ConstraintViolationException ex) {

    // 通過畫面驗證後的自定判斷
    if (ValidCustom.ELEMENT_TYPE.equals(ex.getMessage())) {
      setMessageFromCustom(ex);
    } else {
      setMessageFromValid(ex);
    }
  }

  // 自定義檢查
  private void setMessageFromCustom(ConstraintViolationException ex) {

    Iterator<ConstraintViolation<?>> set = ex.getConstraintViolations().iterator();

    while (set.hasNext()) {
      ConstraintViolation<?> violation = set.next();
      this.resultCode = (int) violation.getExecutableReturnValue();
      this.data = violation.getMessageTemplate();
    }
  }

  // 畫面檢查
  private void setMessageFromValid(ConstraintViolationException ex) {
    this.resultCode = ResultCode.FORMAT_FAIL.getCode();

    List<ValidMessage> validList = new ArrayList<ValidMessage>();

    int errCode = 0;
    Iterator<ConstraintViolation<?>> set = ex.getConstraintViolations().iterator();
    while (set.hasNext()) {
      ConstraintViolation<?> violation = set.next();

      // get message code
      if (NotNull.class
          .equals(violation.getConstraintDescriptor().getAnnotation().annotationType())) {
        errCode = ValidCode.NOT_NULL.getCode();
      } else {
        errCode = ValidCode.FORMAT_FAIL.getCode();
      }

      // chk
      String type = this.getElementType(violation);

      // set message
      if ("FIELD".equals(type)) {
        validList.add(this.getBeanValid(violation, errCode));
      } else if ("PARAMETER".equals(type)) {
        validList.add(this.getParameValid(violation, errCode));
      } else { // 其他先用第一種
        validList.add(this.getBeanValid(violation, errCode));
      }

    }

    this.setData(validList);
  }

  /**
   * 找不到api, 硬拆
   * 
   * @param violation
   * @return
   */
  private String getElementType(ConstraintViolation<?> violation) {

    String type = "";
    String str = violation.getConstraintDescriptor().toString();
    String key = "elementType=";

    Pattern pattern = Pattern.compile(key + "[A-Z]+");

    Matcher matcher = pattern.matcher(str);

    if (matcher.find()) {
      type = matcher.group(0).replaceAll(key, "");
    }

    return type;
  }

  /**
   * 
   * @param violation
   * @param errCode
   * @return
   */
  private ValidMessage getBeanValid(ConstraintViolation<?> violation, int errCode) {
    // get bean
    Class<?> bean = violation.getLeafBean().getClass();

    // get fieldName
    String fieldName = null;
    Iterator<Node> it = violation.getPropertyPath().iterator();
    while (it.hasNext()) {
      fieldName = it.next().toString();
    }

    try {
      XmlElement ann = bean.getDeclaredField(fieldName).getAnnotation(XmlElement.class);
      if (ann != null) {
        fieldName = ann.name();
      }
    } catch (NoSuchFieldException | SecurityException e) {

    }

    return new ValidMessage(fieldName, ObjectUtils.toString(violation.getInvalidValue()), errCode,
        violation.getMessage());
  }

  /**
   * 
   * @param violation
   * @param errCode
   * @return
   */
  private ValidMessage getParameValid(ConstraintViolation<?> violation, int errCode) {

    Class<?> bean = violation.getLeafBean().getClass();

    // get methodName
    String methodName = null;
    String parameName = null;
    int parameIndex = 0;

    Iterator<Node> it = violation.getPropertyPath().iterator();

    for (int i = 0; it.hasNext(); i++) {
      Node node = it.next();
      if (i == 0) {
        methodName = node.toString();
      } else if (i == 1) {
        parameIndex = Integer.parseInt(node.toString().replaceAll("arg", ""));
      }
    }

    // get method
    Method[] methods = bean.getDeclaredMethods();

    for (Method method : methods) {
      if (method.getName().equals(methodName)) {
        Parameter p = method.getParameters()[parameIndex];
        parameName = p.getName();

        try {
          Annotation[] anns = method.getParameterAnnotations()[parameIndex];

          for (Annotation ann : anns) {
            if (ann instanceof QueryParam || ann instanceof PathParam) {
              Method m = ann.getClass().getMethod("value", new Class[0]);
              parameName = (String) m.invoke(ann);
            }
          }
        } catch (Exception e) {

        }
      }
    }

    return new ValidMessage(parameName, ObjectUtils.toString(violation.getInvalidValue()), errCode,
        violation.getMessage());

  }
}
