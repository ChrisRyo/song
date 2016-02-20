package tw.com.service;

import java.util.List;

import tw.com.model.vo.Expenses;

public interface ExpensesService {

	/**
	 * 新增
	 * 
	 * @param Expenses Expenses
	 * 
	 * @throws Exception
	 */
	public void addExpenses(Expenses entity) throws Exception;

	/**
	 * 取得所有會員資料
	 * 
	 * @return List<Expenses>
	 * @throws Exception
	 */
	public List<Expenses> getExpenses() throws Exception;

}
