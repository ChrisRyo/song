package tw.com.jersey.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.servlet.ServletContainer;

@Provider
public class LoginFilter extends ServletContainer {  
  private static final long serialVersionUID = -766501864493188353L;  

  @Override  
  public void doFilter(HttpServletRequest request,  
          HttpServletResponse response, FilterChain chain)  
          throws IOException, ServletException {  
      HttpServletRequest httpRequest = (HttpServletRequest) request;  
      
  }  
}  
