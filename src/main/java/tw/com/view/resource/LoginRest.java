package tw.com.view.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.model.dto.User;


/**
 * 
 * @author chrisryo
 * 
 *         註 : @Consumes接受類型, @Produces返回類型
 *
 */
@Path("/login")
public class LoginRest {

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
  @Path("check")
  public void login(User user, @Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception {
    if (!user.getAccount().equals("lin") || !user.getPassword().equals("qwer8888")) {
      throw new Exception("帳號或密碼錯誤！");
    }
    
    request.setAttribute(User.USER_SESSION, user);
    response.sendRedirect("expenses");
  }

}
