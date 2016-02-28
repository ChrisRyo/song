package tw.com.jersey.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author chrisryo
 *
 */
@Provider
public class BaseRequestFilter implements ContainerRequestFilter {

	public void filter(ContainerRequestContext arg0) throws IOException {
		System.out.println(this.getClass().getSimpleName());
	}

}
