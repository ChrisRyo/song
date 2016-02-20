package tw.com.view.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tw.com.model.vo.Expenses;
import tw.com.service.Impl.ExpensesServiceImpl;


/**
 * 
 * @author chrisryo
 * 
 * 註 : @Consumes接受類型, @Produces返回類型
 *
 */ 
@Path("/expenses")
public class ExpensesRest {
	
	private ExpensesServiceImpl service = new ExpensesServiceImpl();
	
	
	/**
	 * 取所有資料
	 * 
	 * @return
	 * @throws Exception 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Expenses> getAllMember() throws Exception {
		return service.getExpenses();
	}
	
	/**
	 *  寫入資料
	 *  
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expenses> getTodos(Expenses entity) throws Exception {
		service.addExpenses(entity);
		return service.getExpenses();
    }
	
}