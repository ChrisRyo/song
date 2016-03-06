package tw.com.view.resource;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import tw.com.logic.enums.DateStyle;
import tw.com.logic.utils.DateUtils;
import tw.com.model.vo.Expenses;
import tw.com.model.vo.ExpensesMain;
import tw.com.service.CommonService;
import tw.com.view.message.ReturnMessage;
import tw.com.view.message.code.ValidCode;


/**
 * 
 * @author chrisryo
 * 
 *         註 : @Consumes接受類型, @Produces返回類型
 *
 */
@Path("/expenses")
public class ExpensesRest extends BaseRest {

  @Inject
  private CommonService service;

  @GET
  public Viewable init() {
    return new Viewable("/expenses/expenses_init", super.getModelAndView());
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
  public ReturnMessage getMainExpenses(ExpensesMain entity) throws Exception {
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
  public ReturnMessage getAllExpenses(Expenses expenses) throws Exception {
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
  public ReturnMessage addMain(ExpensesMain expensesMain) throws Exception {
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
  public ReturnMessage add(Expenses expenses) throws Exception {
    expenses.setSeq(null);
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
  public ReturnMessage updateMain(ExpensesMain expensesMain) throws Exception {
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
  public ReturnMessage updateDetail(Expenses expenses) throws Exception {
    service.updateByEntity(expenses);
    return this.getDetailData(expenses);
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
  public ReturnMessage remove(Expenses expenses) throws Exception {
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
  private ReturnMessage getMainData(ExpensesMain entity) throws Exception {

    List<ExpensesMain> list = (List<ExpensesMain>) service.queryByEntity(entity, true);
    return new ReturnMessage(true, ValidCode.SUCCESS.getCode(), list, list.size());
  }

  /**
   * 
   * @param expenses
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  private ReturnMessage getDetailData(Expenses entity) throws Exception {

    if (entity.getBillDate() == null || entity.getBillStore() == null || entity.getSource() == null) {
      throw new Exception("缺少查詢條件");
    }

    Expenses queryDto = new Expenses();
    queryDto.setBillDate(entity.getBillDate());
    queryDto.setBillStore(entity.getBillStore());
    queryDto.setSource(entity.getSource());

    List<Expenses> list = (List<Expenses>) service.queryByEntity(queryDto, false);

    // tottalAmt
    String date = DateUtils.dateFormat(entity.getBillDate(), DateStyle.YYYY_MM_DD);
    String billDate = "STR_TO_DATE('" + date + "','" + DateStyle.YYYY_MM_DD.getSql() + "')";

    Object obj =
        service.queryBySql(this.getSql(billDate, entity.getBillStore(), entity.getSource()));

    return new ReturnMessage(true, ValidCode.SUCCESS.getCode(), list, list.size(), obj);
  }

  /**
   * 
   * @param val
   * @return
   */
  private String getSql(Object... val) {
    String sql =
        "SELECT sum(e.amt) as totalAmt FROM Expenses e where e.billDate = {0} AND e.billStore = {1} AND e.source = {2}";

    return MessageFormat.format(sql, val);
  }

}
