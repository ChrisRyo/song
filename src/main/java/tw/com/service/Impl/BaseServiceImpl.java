package tw.com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

/**
 * CommonService
 * 
 * @author chrisryo
 *
 */
@Singleton
public class BaseServiceImpl {

  protected final int MAX_COUNT = 10000;

  public Map<String, Object> getMap (List<Object[]> resultList) {
    // create empty map to store results in. If we don't find results, an empty hashmap will be
    // returned
    Map<String, Object> results = new HashMap<String, Object>();

    // Place results in map
    for (Object[] borderTypes : resultList) {
      results.put((String) borderTypes[0], borderTypes[1]);
    }

    return results;
  }

}
