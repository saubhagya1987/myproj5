/**
 * 
 */
package com.happyTouristPersistence.dao;

import java.util.List;
import java.util.Map;







import com.happyTouristPersistence.criteria.CriteriaObject;
import com.happyTouristPersistence.enums.Junction;





public interface GenericDao<T> {

	/**
	 * @param t
	 * @return
	 */
	T save(T t);

	/**
	 * @param id
	 */
	void delete(T id);

	/**
	 * @param id
	 * @return
	 */
	T find(Long id);

	/**
	 * @param t
	 * @return
	 */
	T merge(T t);

	/**
	 * @param queryName
	 * @param fieldValue
	 * @return intsance of entity or null if no result found in database
	 */
	T findSingleResultByNameQuery(String queryName, Map<String, Object> fieldValue);

	/**
	 * 
	 * @param queryName
	 * @param fieldValue
	 * @return list of entity object or empty list if no result found in database
	 */
	List<T> findResultsByNameQuery(String queryName, Map<String, Object> fieldValue);

	/**
	 * @param criteriaObjects
	 * @param startIndex
	 * @param maxResult
	 * @return
	 */
	List<T> getPageResultByCriteria(
			Map<Junction, List<CriteriaObject>> criteriaObjects,
			Integer startIndex, Integer maxResult);

	/**
	 * @param criteriaObjects
	 * @return
	 */
	List<T> getResultByCriteria(
			Map<Junction, List<CriteriaObject>> criteriaObjects);

	/**
	 * 
	 * @param id
	 * @return proxy object
	 */
	T load(Long id);

	/**
	 * 
	 */
	void flush();

	/**
	 * @param queryName
	 * @param fieldValue
	 * @return
	 */
	List<T> findPageByNameQuery(String queryName, Map<String, Object> fieldValue, Integer startOffset, Integer maxResult);

	void detach(T t);

	T find(String id);

}
