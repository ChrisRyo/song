package tw.com.service.Impl;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
public class CommonServiceImpl extends BaseServiceImpl implements CommonService {
  
  /**
   * 
   * @param sql
   * @return
   * @throws Exception
   */
  public Object queryBySql(String sql) throws Exception {
    EntityManager em = EntityManagerHelper.getEntityManager();

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
    EntityManager em = EntityManagerHelper.getEntityManager();
    List<?> list = null;
    Query query = em.createNamedQuery(entity.getSimpleName() + ".findAll").setMaxResults(MAX_COUNT);
    list = (List<?>) query.getResultList();
    return list;
  }

  /**
   * 查詢 by entity
   * 
   * @param entity
   * @param isLike
   * @return
   * @throws Exception
   */
  public List<?> queryByEntity(Object entity, boolean isLike) throws Exception {
    EntityManager em = EntityManagerHelper.getEntityManager();
    List<?> list = null;
    String sql = EntityUtils.getQueryEntitySql(entity, isLike);

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
   * @param isLike
   * @return count
   * @throws Exception
   */
  public int queryCountBySql(Object entity, boolean isLike) throws Exception {
    EntityManager em = EntityManagerHelper.getEntityManager();

    String sql = EntityUtils.getQueryCountSql(entity, isLike);

    Query query = em.createQuery(sql);

    return ((Long) query.getSingleResult()).intValue();
  }

  /**
   * 查詢 by entity where begin and end
   * 
   * @param entity
   * @param isLike
   * @param index
   * @param size
   * @return
   * @throws Exception
   */
  public List<?> queryByEntity(Object entity, boolean isLike, int index, int size) throws Exception {
    EntityManager em = EntityManagerHelper.getEntityManager();
    List<?> list = null;
    String sql = EntityUtils.getQueryEntitySql(entity, isLike);

    int begin = ((index - 1) * size);
    int length = size;

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
    EntityManager em = EntityManagerHelper.getEntityManager();
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
    EntityManager em = EntityManagerHelper.getEntityManager();
    EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      em.merge(entity);
      transaction.commit();
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
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
    EntityManager em = EntityManagerHelper.getEntityManager();
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
