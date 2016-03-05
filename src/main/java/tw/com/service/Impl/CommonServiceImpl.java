package tw.com.service.Impl;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tw.com.entityManager.EntityManagerHelper;
import tw.com.logic.utils.EntityUtils;
import tw.com.service.CommonService;

/**
 * CommonService
 * 
 * @author chrisryo
 *
 */
@Singleton
public class CommonServiceImpl implements CommonService {

  @PersistenceContext
  private EntityManager em = EntityManagerHelper.getEntityManager();

  private final int MAX_COUNT = 10000;

  /**
   * 
   * @param sql
   * @return
   * @throws Exception
   */
  public Object queryBySql(String sql) throws Exception {
    Query query = em.createQuery(sql).setMaxResults(MAX_COUNT);
    return query.getResultList();
  }

  /**
   * 取得所有資料
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  public List<?> queryAll(Class<?> entity) throws Exception {
    List<?> list = null;
    Query query = em.createNamedQuery(entity.getSimpleName() + ".findAll").setMaxResults(MAX_COUNT);
    list = (List<?>) query.getResultList();
    return list;
  }

  /**
   * 查詢 by entity
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  public List<?> queryByEntity(Object entity) throws Exception {
    List<?> list = null;
    String sql = EntityUtils.getQueryEntitySql(entity);

    if (sql == null) {
      return queryAll(entity.getClass());
    }

    Query query = em.createQuery(sql).setMaxResults(MAX_COUNT);
    list = (List<?>) query.getResultList();
    return list;
  }

  /**
   * 查詢總筆數 by entity
   * 
   * @param entity
   * @return count
   * @throws Exception
   */
  public int queryCountBySql(Object entity) throws Exception {

    String sql = EntityUtils.getQueryCountSql(entity);

    Query query = em.createQuery(sql);

    return ((Long) query.getSingleResult()).intValue();
  }

  /**
   * 查詢 by entity where begin and end
   * 
   * @param entity
   * @param begin
   * @param length
   * @return
   * @throws Exception
   */
  public List<?> queryByEntity(Object entity, int begin, int length) throws Exception {
    List<?> list = null;
    String sql = EntityUtils.getQueryEntitySql(entity);

    Query query =
        em.createQuery(sql).setMaxResults(MAX_COUNT).setFirstResult(begin).setMaxResults(length);
    list = (List<?>) query.getResultList();
    return list;
  }

  /**
   * 新增
   * 
   * @param entity
   * @throws Exception
   */
  public void insertByEntity(Object entity) throws Exception {
    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      em.persist(entity);
      em.flush();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw new Exception(e);
    }
  }

  /**
   * 修改
   * 
   * @param entity
   * @throws Exception
   */
  public void updateByEntity(Object entity) throws Exception {
    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      em.merge(entity);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw new Exception(e);
    }
  }

  /**
   * 刪除
   * 
   * @param entity
   * @throws Exception
   */
  public void deleteByEntity(Object entity) throws Exception {
    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      Object newEntity = em.merge(entity);
      em.remove(newEntity);
      em.flush();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      throw new Exception(e);
    }
  }
}
