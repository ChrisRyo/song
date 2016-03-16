package tw.com.view.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.logic.utils.PropertiesUtils;
import tw.com.logic.utils.UserUtils;
import tw.com.service.CommonService;

@Path("/index")
public class IndexRest extends BaseRest {

  @Inject
  private CommonService service;

  @GET
  public Viewable init() throws Exception {

    Object obj =
        service.queryBySql(PropertiesUtils.getSql("Login.queryPagePermission", UserUtils.getUser()
            .getUserName()));

    return new Viewable("/index/index_init", super.getModelAndView());
  }
}
