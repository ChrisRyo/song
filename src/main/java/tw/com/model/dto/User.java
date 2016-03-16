package tw.com.model.dto;

import lombok.Data;
import lombok.experimental.Delegate;
import tw.com.model.vo.Member;

/**
 * 
 * @author chrisryo
 *
 */
@Data
public class User {

  public final static String USER_SESSION = "userInfo";

  @Delegate
  private Member member;
  
  public User () {
    this.member = new Member();
  }
}
