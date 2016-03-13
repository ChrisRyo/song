package tw.com.jersey.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.ws.rs.NameBinding;

/**
 * 
 * @author chrisryo
 *
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface GridDataToDto {

}