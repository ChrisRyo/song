package tw.com.service.Impl;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tw.com.entityManager.EntityManagerHelper;
import tw.com.model.vo.Expenses;
import tw.com.service.ExpensesService;

/**
 * Session Bean implementation class MemberBean
 */
@Singleton
public class ExpensesMainServiceImpl implements ExpensesService {

	@PersistenceContext
	private EntityManager em = EntityManagerHelper.getEntityManager();

	/**
	 * 新增
	 * 
	 * @param Expenses
	 *            Id
	 * @throws Exception
	 */
	public void addExpenses(Expenses entity) throws Exception {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(entity);
			em.flush();
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error Saving Customer: " + e.getMessage());

			transaction.rollback();

			throw new Exception(e);
		}
	}

	/**
	 * 取得所有資料
	 * 
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public List<Expenses> getExpenses() throws Exception {
		List<Expenses> list = null;
		Query query = em.createNamedQuery("Expenses.findAll");
		list = (List<Expenses>) query.getResultList();
		return list;
	}

}
