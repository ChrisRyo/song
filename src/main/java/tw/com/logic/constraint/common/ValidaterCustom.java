package tw.com.logic.constraint.common;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;

import tw.com.logic.exception.code.ResultCode;
import tw.com.view.message.ValidMessage;


/**
 * 
 */
public class ValidaterCustom {

  /**
   * 自定驗證
   * 
   * <p>
   * validClass放入implements ValidCustom的自定義檢查方法
   * <p>
   * 任何一筆遇到錯誤立刻中斷
   * <p>
   * 若不想中斷, 自行catch處理, message 欄加入 ValidCustom.ELEMENT_TYPE
   * 
   * @param validClass
   * @param dto
   * @throws IllegalAccessException
   * @throws InstantiationException
   * @throws Exception
   */
  public static void validate(Object dto, Class<?>... validClasses) {

    for (Class<?> validClass : validClasses) {
      ValidCustom validCustom = null;
      ValidMessage msg = null;

      try {

        validCustom = (ValidCustom) validClass.newInstance();
        msg = validCustom.isValid(dto);

      } catch (Exception e) {
        Set<ConstraintViolation<? extends Object>> validators = getViolations(dto,
            new ValidMessage(validClass.getSimpleName(), dto, ResultCode.ERR_DEFIND.getCode(),
                validClass.getSimpleName() + " 程式錯誤, 請洽工程師 : " + e));
        throw new ConstraintViolationException(ValidCustom.ELEMENT_TYPE, validators);
      }

      // 驗證錯誤
      if (msg != null) {
        Set<ConstraintViolation<? extends Object>> validators = getViolations(dto, msg);
        throw new ConstraintViolationException(ValidCustom.ELEMENT_TYPE, validators);
      }

    }
  }

  /**
   * 
   * @param dto
   * @param msg
   * @return
   */
  private static Set<ConstraintViolation<? extends Object>> getViolations(Object dto,
      ValidMessage msg) {
    Set<ConstraintViolation<? extends Object>> validators =
        new HashSet<ConstraintViolation<? extends Object>>();

    ConstraintViolation<? extends Object> violation =
        ConstraintViolationImpl.forReturnValueValidation(msg.getMsg(), msg.getField(), null, null,
            dto, msg.getValue(), null, null, null, msg.getErrorCode());

    validators.add(violation);

    return validators;
  }

}
