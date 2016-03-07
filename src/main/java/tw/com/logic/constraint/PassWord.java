package tw.com.logic.constraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
/**
 * 密碼原則：最小長度為6位，最大長度為16位，並符合下列原則【使用英文、 使用至少一位數字】
 */
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = PassWord.PassWordValidator.class)
public @interface PassWord {
 
    String message() default "{com.ingenious.night.validator.constraints.PassWord.message}";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    public class PassWordValidator implements ConstraintValidator<PassWord, String> {
    	
    	private final long minLength = 6;
    	private final long maxLength = 16;
    	
    	private final Pattern VALID_PASSWORD_REGEX = Pattern.compile(
    			"^(?!.*[^a-zA-Z0-9])(?=.*\\d)(?=.*[a-zA-Z]).{"+minLength+","+maxLength+"}$",
    			Pattern.CASE_INSENSITIVE);

    	public void initialize(PassWord arg0) {

    	}

    	public boolean isValid(String passWord, ConstraintValidatorContext constraintValidatorContext) {
    		if (passWord == null) {
    			return true;
    		}
    		
    		Matcher matcher = VALID_PASSWORD_REGEX.matcher(passWord);
    		return matcher.find();
    	}
    }
}