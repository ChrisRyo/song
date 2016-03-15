package tw.com.view.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/index")
public class IndexRest extends BaseRest {
  
  @GET
  public Viewable init() {
    return new Viewable("/index", super.getModelAndView());
  }
}
