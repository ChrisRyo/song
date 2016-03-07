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
 * 帳號限以數字與英文組成，最小長度為6位，最大長度為16位。
 */
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = Account.AccountValidator.class)
public @interface Account {
 
    String message() default "{com.ingenious.night.validator.constraints.Account.message}";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    public class AccountValidator implements ConstraintValidator<Account, String> {
    	
    	private final long minLength = 6;
    	private final long maxLength = 16;
    	
    	private final Pattern VALID_ACCOUNT_REGEX = Pattern.compile(
    			"^([A-Za-z0-9]){"+minLength+","+maxLength+"}$",
    			Pattern.CASE_INSENSITIVE);

    	public void initialize(Account arg0) {

    	}

    	public boolean isValid(String account, ConstraintValidatorContext constraintValidatorContext) {
    		if (account == null) {
    			return true;
    		}
    		
    		Matcher matcher = VALID_ACCOUNT_REGEX.matcher(account);
    		return matcher.find();
    	}
    }
}