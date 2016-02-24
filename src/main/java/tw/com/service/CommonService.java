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
	 * 取得所有資料
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public List<?> queryAll(Class<?> entity) throws Exception;

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
