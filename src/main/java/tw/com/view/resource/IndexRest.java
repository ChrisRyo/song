package tw.com.view.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.logic.utils.PropertiesUtils;
import tw.com.logic.utils.UserUtils;
import tw.com.model.vo.PagePermission;
import tw.com.service.CommonService;

@Path("/index")
public class IndexRest extends BaseRest {

  @Inject
  private CommonService service;


  @GET
  @SuppressWarnings("unchecked")
  public Viewable init() throws Exception {

    List<PagePermission> list =
        (List<PagePermission>) service.queryBySql(
        PropertiesUtils.getSql("Login.pagePermission", UserUtils.getUser().getUid()));

        for (PagePermission p : list) {
          p.getUrlId();
        }

    return new Viewable("/index/index_init", super.getModelAndView());
  }
}
