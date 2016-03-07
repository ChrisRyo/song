package tw.com.logic.constraint.common;

import tw.com.view.message.ValidMessage;

public interface ValidCustom {
  
  // interpolatedMessage returnMessage判斷使用
  public static String ELEMENT_TYPE = "customValidators";

  // 欄位名稱 field; 輸入值 value; 錯誤代碼 errorCode; 錯誤訊息 msg;
  public ValidMessage isValid(Object dto) throws Exception;

}
