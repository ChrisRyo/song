package tw.com.jersey.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;

/**
 * 
 * @author chrisryo
 *
 */
@Provider
public class BaseResponseFilter implements ContainerResponseFilter {
  
  @Context
  HttpServletResponse response;

  public void filter(ContainerRequestContext arg0, ContainerResponseContext arg1)
      throws IOException {
    
    if (arg1.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
      response.sendRedirect("login");
      return;
    }

//    // Google Json
//    if (arg1.getMediaType() != null
//        && MediaType.APPLICATION_JSON.equals(arg1.getMediaType().toString())) {
//      arg1.setEntity(new Gson().toJson(arg1.getEntity()));
//    }
  }
}
