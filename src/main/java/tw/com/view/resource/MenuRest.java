package tw.com.view.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tw.com.logic.enums.temp.CompanyEnum;
import tw.com.logic.enums.temp.GovernmentEnum;
import tw.com.logic.enums.temp.PayeeUnitEnum;
import tw.com.logic.enums.temp.PlayerEnum;
import tw.com.logic.enums.temp.SourceEnum;
import tw.com.logic.enums.temp.StoreEnum;
import tw.com.model.dto.Menu;

@Path("/menu")
public class MenuRest {

  /**
   * @return
   * @throws Exception
   */
  @GET
  @Path("getEmenu/{type}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Menu> queryStroe(@PathParam("type") String type) throws Exception {

    if ("queryStroe".equals(type)) {
      return StoreEnum.getMenu();
    }

    if ("querySource".equals(type)) {
      return SourceEnum.getMenu();
    }

    if ("queryPayeeUnit".equals(type)) {
      return PayeeUnitEnum.getMenu();
    }

    if ("queryPlayer".equals(type)) {
      return PlayerEnum.getMenu();
    }

    if ("queryCompany".equals(type)) {
      return CompanyEnum.getMenu();
    }

    if ("queryGovernment".equals(type)) {
      return GovernmentEnum.getMenu();
    }

    return null;
  }


//  /**
//   * @return
//   * @throws Exception
//   */
//  @GET
//  @Path("queryPayee")
//  @Produces(MediaType.APPLICATION_JSON)
//  public List<Menu> queryPayee(@QueryParam("unit") int unit, @QueryParam("name") String name)
//      throws Exception {
//
//    switch (unit) {
//      case 1:
//        return PlayerEnum.getMenu(name);
//      case 2:
//        return CompanyEnum.getMenu(name);
//      case 3:
//        return GovernmentEnum.getMenu(name);
//      default:
//        return new ArrayList<Menu>();
//    }
//  }
}
