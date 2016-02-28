package tw.com.view.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.model.vo.Expenses;
import tw.com.model.vo.ExpensesMain;
import tw.com.service.CommonService;


/**
 * 
 * @author chrisryo
 * 
 *         註 : @Consumes接受類型, @Produces返回類型
 *
 */
@Path("/expenses")
public class ExpensesRest {

  @Inject
  private CommonService service;

  @GET
  public Viewable init() {
    return new Viewable("/expenses");
  }

  /**
   * 取主檔資料
   * 
   * @return
   * @throws Exception
   */
  @POST
  @Path("queryMain")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<ExpensesMain> getMainExpenses(ExpensesMain entity) throws Exception {
    return this.getMainData(entity);
  }

  /**
   * 取所有資料
   * 
   * @return
   * @throws Exception
   */
  @POST
  @Path("queryDetail")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Expenses> getAllExpenses(Expenses expenses) throws Exception {
    return this.getDetailData(expenses);
  }

  /**
   * 寫入主檔資料
   * 
   * @param ExpensesMain
   * @return
   * @throws Exception
   */
  @POST
  @Path("addMain")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<ExpensesMain> addMain(ExpensesMain expensesMain) throws Exception {
    service.insertByEntity(expensesMain);
    return this.getMainData(expensesMain);
  }

  /**
   * 寫入明細資料
   * 
   * @param expenses
   * @return
   * @throws Exception
   */
  @POST
  @Path("addDetail")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Expenses> add(Expenses expenses) throws Exception {
    service.insertByEntity(expenses);
    return this.getDetailData(expenses);
  }

  /**
   * 更新主檔資料
   * 
   * @param ExpensesMain
   * @return
   * @throws Exception
   */
  @POST
  @Path("updateMain")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<ExpensesMain> updateMain(ExpensesMain expensesMain) throws Exception {
    service.updateByEntity(expensesMain);
    return this.getMainData(expensesMain);
  }

  /**
   * 更新明細資料
   * 
   * @param expenses
   * @return
   * @throws Exception
   */
  @POST
  @Path("updateDetail")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Expenses> updateDetail(Expenses expenses) throws Exception {
    service.updateByEntity(expenses);
    return this.getDetailData(expenses);
  }

  /**
   * 刪除主檔資料
   * 
   * @param expenses
   * @return
   * @throws Exception
   */

  @POST
  @Path("removeMain")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<ExpensesMain> removeMain(ExpensesMain expensesMain) throws Exception {
    service.deleteByEntity(expensesMain);
    return this.getMainData(expensesMain);
  }

  /**
   * 刪除明細資料
   * 
   * @param expenses
   * @return
   * @throws Exception
   */
  @POST
  @Path("removeDetail")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Expenses> remove(Expenses expenses) throws Exception {
    service.deleteByEntity(expenses);
    return this.getDetailData(expenses);
  }

  /**
   * 
   * @param expensesMain
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  private List<ExpensesMain> getMainData(ExpensesMain expensesMain) throws Exception {
    return (List<ExpensesMain>) service.queryByEntity(expensesMain);
  }

  /**
   * 
   * @param expenses
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  private List<Expenses> getDetailData(Expenses expenses) throws Exception {
    
    if (expenses.getBillDate() == null || expenses.getBillStore() == null) {
      throw new Exception("缺少查詢條件");
    }
    
    Expenses queryDto = new Expenses();
    queryDto.setBillDate(expenses.getBillDate());
    queryDto.setBillStore(expenses.getBillStore());
    
    return (List<Expenses>) service.queryByEntity(queryDto);
  }

}
