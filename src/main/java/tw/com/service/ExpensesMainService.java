package tw.com.service;

import java.util.List;

import tw.com.model.vo.Expenses;

/**
 * Session Bean implementation class MemberBean
 */
public interface ExpensesMainService {

  /**
   * 新增
   * 
   * @param Expenses Id
   * @throws Exception
   */
  public void addExpenses(Expenses entity) throws Exception;

  /**
   * 取得所有資料
   * 
   * @return
   * @throws Exception
   */
  public List<Expenses> getExpenses() throws Exception;
}
