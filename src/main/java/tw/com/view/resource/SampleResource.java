package tw.com.view.resource;

import java.util.HashMap;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/sample")
public class SampleResource {
	@GET
	public Viewable sayHello(@QueryParam("name") @DefaultValue("World") String name) {
		HashMap<String, String> model = new HashMap<String, String>();
		model.put("name", name);
		return new Viewable("/sample", model);
	}
}