package tw.com.view.resource;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public class BaseRest {
  
  @Context HttpServletRequest request;
  
  protected HashMap<String, Object> getModelAndView() {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("pathTitle", request.getContextPath());
    return model;
  }
}
