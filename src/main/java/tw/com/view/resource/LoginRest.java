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
import tw.com.model.vo.Member;
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
  public ReturnMessage login(Member member, @Context HttpServletRequest request,
      @Context HttpServletResponse response) throws Exception {

    Member entity = new Member();
    entity.setUserName(member.getUserName());
    entity.setPwd(member.getPwd());

    List<Member> list = (List<Member>) service.queryByEntity(entity, false);

    if (list == null || list.size() == 0) {
      return new ReturnMessage(ValidCode.VALID_FAIL.getCode(), "帳號或密碼錯誤！");
    }
    
    User user = new User();
    user.setMember(list.get(0));
    
    request.getSession().setAttribute(User.USER_SESSION, user);

    return new ReturnMessage(ValidCode.SUCCESS.getCode(), request.getContextPath() + "/index");
  }

}
