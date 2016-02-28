package tw.com.view.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tw.com.logic.enums.temp.PayeeUnitEnum;
import tw.com.logic.enums.temp.StoreEnum;
import tw.com.model.dto.Menu;

@Path("/menu")
public class MenuRest {

  /**
   * @return
   * @throws Exception
   */
  @GET
  @Path("queryStroe")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Menu> queryStroe() throws Exception {
    return StoreEnum.getMenu();
  }

  /**
   * @return
   * @throws Exception
   */
  @GET
  @Path("queryPayeeUnit")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Menu> queryPayeeUnit() throws Exception {
    return PayeeUnitEnum.getMenu();
  }

  /**
   * @return
   * @throws Exception
   */
  @GET
  @Path("queryPayee")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Menu> queryPayee(@QueryParam("unit") int unit, @QueryParam("name") String name)
      throws Exception {

    if (unit != 1 && unit != 2 && unit != 3) {
      return new ArrayList<Menu>();
    }
    return PayeeUnitEnum.getDetailMenu(unit, name);
  }
}
