package tw.com.service;

import java.util.List;

/**
 * CommonService interface
 * 
 * @author chrisryo
 *
 */
public interface CommonService {

  /**
   * 
   * @param sql
   * @return
   * @throws Exception
   */
  public Object queryBySql(String sql) throws Exception;

  /**
   * 取得所有資料
   * 
   * @param entity
   * @return
   * @throws Exception
   */
  public List<?> queryAll(Class<?> entity) throws Exception;

  /**
   * 查詢 by entity
   * 
   * @param entity
   * @param isLike
   * @return
   * @throws Exception
   */
  public List<?> queryByEntity(Object entity, boolean isLike) throws Exception;

  /**
   * 查詢總筆數 by entity
   * 
   * @param entity
   * @param isLike
   * @return count
   * @throws Exception
   */
  public int queryCountBySql(Object entity, boolean isLike) throws Exception;

  /**
   * 查詢 by entity where begin and end
   * 
   * @param entity
   * @param isLike
   * @param begin
   * @param length
   * @return
   * @throws Exception
   */
  public List<?> queryByEntity(Object entity, boolean isLike, int begin, int length)
      throws Exception;

  /**
   * 新增 by entity
   * 
   * @param entity
   * @throws Exception
   */
  public void insertByEntity(Object entity) throws Exception;

  /**
   * 修改 by entity
   * 
   * @param entity
   * @throws Exception
   */
  public void updateByEntity(Object entity) throws Exception;

  /**
   * 修改 by entity
   * 
   * @param entity
   * @throws Exception
   */
  public void deleteByEntity(Object entity) throws Exception;
}
