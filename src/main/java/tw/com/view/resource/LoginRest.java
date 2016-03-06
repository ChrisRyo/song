package tw.com.view.resource;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.model.dto.User;
import tw.com.model.vo.Account;
import tw.com.service.CommonService;
import tw.com.view.message.ReturnMessage;
import tw.com.view.message.code.ValidCode;


/**
 * 
 * @author chrisryo
 * 
 *         註 : @Consumes接受類型, @Produces返回類型
 *
 */
@Path("/login")
public class LoginRest {

  @Inject
  private CommonService service;

  @GET
  public Viewable init() throws Exception {
    return new Viewable("/login");
  }

  /**
   * login
   * 
   * @return
   * @throws Exception
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @SuppressWarnings({"unchecked"})
  public ReturnMessage login(User user, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws Exception {

    Account acc = new Account();
    acc.setUserName(user.getAccount());
    acc.setPwd(user.getPassword());

    List<Account> list = (List<Account>) service.queryByEntity(acc, false);

    if (list == null || list.size() == 0) {
      return new ReturnMessage(false, ValidCode.VALID_FAIL.getCode(), "帳號或密碼錯誤！");
    }

    request.getSession().setAttribute(User.USER_SESSION, user);

    return new ReturnMessage(true, ValidCode.SUCCESS.getCode(), request.getContextPath()
        + "/expenses");
  }

}
