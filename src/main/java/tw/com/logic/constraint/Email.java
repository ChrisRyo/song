package tw.com.logic.constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = Email.EmailValidator.class)
public @interface Email {

  String message() default "{com.ingenious.night.validator.constraints.Email.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  public class EmailValidator implements ConstraintValidator<Email, String> {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
        "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void initialize(Email arg0) {
      // TODO Auto-generated method stub

    }

    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
      // TODO Auto-generated method stub
      System.out.println(email);
      if (null == email) {
        return false;
      }
      Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
      return matcher.find();
    }
  }
}
