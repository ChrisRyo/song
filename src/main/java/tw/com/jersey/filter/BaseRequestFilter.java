package tw.com.jersey.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import tw.com.model.dto.User;

/**
 * 
 * @author chrisryo
 *
 */
@Provider
public class BaseRequestFilter implements ContainerRequestFilter {

  @Context
  HttpServletRequest request;
  
  public void filter(ContainerRequestContext requestCtx) throws IOException {

    String path = requestCtx.getUriInfo().getPath();

    if (!path.startsWith("login")) {

      User user = (User) request.getSession().getAttribute(User.USER_SESSION);

      if (user == null) {
        requestCtx.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        return;
      }

    }
  }

}
