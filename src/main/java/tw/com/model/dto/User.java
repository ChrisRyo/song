package tw.com.model.dto;

import lombok.Data;

/**
 * 
 * @author chrisryo
 *
 */
@Data
public class User {

  public final static String USER_SESSION = "userInfo";

  private String account;

  private String password;

  private boolean isLogin;
}
