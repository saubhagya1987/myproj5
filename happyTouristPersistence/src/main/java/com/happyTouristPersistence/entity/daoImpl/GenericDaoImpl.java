/**
 * 
 */
package com.happyTouristPersistence.entity.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.happyTouristPersistence.criteria.CriteriaObject;
import com.happyTouristPersistence.dao.GenericDao;
import com.happyTouristPersistence.enums.Junction;
import com.happyTouristPersistence.exception.SystemException;



public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext(unitName = "happyTouristPersistence" , type = PersistenceContextType.TRANSACTION)
	
	protected EntityManager em;
	
	private Class<T> entityClass;
	private Logger LOGGER = LoggerFactory.getLogger(GenericDaoImpl.class);

	public GenericDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityClass = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T save(final T t) {
		this.em.persist(t);
		return t;
	}

	@Override
	public void flush() {
		this.em.flush();
	}

	@Override
	public void delete(T id) {
		// this.em.getReference(entityClass, id.toString());
		this.em.remove(merge(id));
	}

	@Override
	public T find(final Long id) {
		return (T) this.em.find(entityClass, id);
	}
	
	@Override
	public T find(final String id) {
		return (T) this.em.find(entityClass, id);
	}

	@Override
	public T load(final Long id) {
		return (T) this.em.getReference(entityClass, id);
	}

	@Override
	public T merge(final T t) {
		return this.em.merge(t);
	}

	@Override
	public void detach(final T t) {
		org.hibernate.Session session = (Session) em.getDelegate();
		session.evict(t);
	}

	@Override
	public List<T> findResultsByNameQuery(String queryName, Map<String, Object> fieldValue) {

		try {
			TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, entityClass);
			Set<Entry<String, Object>> entrySet = fieldValue.entrySet();

			for (Entry<String, Object> entry : entrySet)
				query.setParameter(entry.getKey(), entry.getValue());

			return query.getResultList();
		} catch (NoResultException ex) {
			LOGGER.debug("EXCEPTION ENTITY CLASS " + entityClass + " " + ExceptionUtils.getStackTrace(ex));
			return Collections.emptyList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemException(ex);
		}
	}

	@Override
	public T findSingleResultByNameQuery(String queryName, Map<String, Object> fieldValue) {
		try {
			TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, entityClass);
			Set<Entry<String, Object>> entrySet = fieldValue.entrySet();

			for (Entry<String, Object> entry : entrySet)
				query.setParameter(entry.getKey(), entry.getValue());

			return query.getSingleResult();
		} catch (NoResultException ex) {
			LOGGER.debug("EXCEPTION ENTITY CLASS " + entityClass + " " + ExceptionUtils.getStackTrace(ex));
			return null;
		} catch (Exception ex) {
			throw new SystemException(ex);
		}
	}

	/**
	 * 
	 * @param criteriaObjects
	 * @return
	 */
	@Override
	public List<T> getPageResultByCriteria(Map<Junction, List<CriteriaObject>> criteriaObjects, Integer startIndex,
			Integer maxResult) {

		TypedQuery<T> query = em.createQuery(getCriteriaQueryByCriteria(criteriaObjects));
		if (startIndex != null && maxResult != null) {
			query.setFirstResult(startIndex);
			query.setMaxResults(maxResult);
		}
		return query.getResultList();
	}

	@Override
	public List<T> getResultByCriteria(Map<Junction, List<CriteriaObject>> criteriaObjects) {

		TypedQuery<T> query = em.createQuery(getCriteriaQueryByCriteria(criteriaObjects));

		return query.getResultList();
	}

	@Override
	public List<T> findPageByNameQuery(String queryName, Map<String, Object> fieldValue, Integer startOffset,
			Integer maxResult) {

		try {
			TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, entityClass);
			Set<Entry<String, Object>> entrySet = fieldValue.entrySet();

			for (Entry<String, Object> entry : entrySet)
				query.setParameter(entry.getKey(), entry.getValue());

			query.setFirstResult(startOffset);
			query.setMaxResults(maxResult);

			return query.getResultList();
		} catch (NoResultException ex) {
			return Collections.emptyList();
		} catch (Exception ex) {
			throw new SystemException(ex);
		}
	}

	/**********************************************
	 * private Method
	 ********************************/
	private CriteriaQuery<T> getCriteriaQueryByCriteria(Map<Junction, List<CriteriaObject>> criteriaObjects) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);
		criteriaQuery.select(root);
		Predicate resultPredicate = null;

		Set<Entry<Junction, List<CriteriaObject>>> entrySet = criteriaObjects.entrySet();
		for (Entry<Junction, List<CriteriaObject>> entry : entrySet) {
			if (Junction.AND.equals(entry.getKey()))
				resultPredicate = getConjunctionPredicate(entry.getValue(), root, criteriaBuilder, resultPredicate);
			else {
				resultPredicate = getDisjunctionPredicate(entry.getValue(), root, criteriaBuilder, resultPredicate);
			}

		}

		if (resultPredicate != null)
			criteriaQuery.where(resultPredicate);

		return criteriaQuery;
	}

	/**
	 * @param value
	 * @param root
	 * @param criteriaBuilder
	 * @return
	 */
	private Predicate getDisjunctionPredicate(List<CriteriaObject> value, Root<T> root, CriteriaBuilder criteriaBuilder,
			Predicate resultPredicate) {
		Predicate predicate = null;

		for (CriteriaObject criteriaObject : value) {
			predicate = getPredicate(criteriaObject, criteriaBuilder, root);

			if (resultPredicate != null) {
				resultPredicate = criteriaBuilder.or(resultPredicate, predicate);
			} else {
				resultPredicate = predicate;
			}

		}
		return resultPredicate;
	}

	/**
	 * @param value
	 * @return
	 */
	private Predicate getConjunctionPredicate(List<CriteriaObject> value, Root<T> root, CriteriaBuilder criteriaBuilder,
			Predicate resultPredicate) {

		Predicate predicate = null;

		for (CriteriaObject criteriaObject : value) {
			predicate = getPredicate(criteriaObject, criteriaBuilder, root);

			if (resultPredicate != null) {
				resultPredicate = criteriaBuilder.and(resultPredicate, predicate);
			} else {
				resultPredicate = predicate;
			}

		}
		return resultPredicate;

	}

	private Predicate getPredicate(CriteriaObject criteriaObject, CriteriaBuilder criteriaBuilder, Root<T> root) {
		Predicate predicate = null;
		switch (criteriaObject.getOperator()) {
		case GREATER_THAN:
			if (criteriaObject.getValue() instanceof Number)
				predicate = criteriaBuilder.gt(root.<Number> get(criteriaObject.getFieldName()),
						(Number) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof Date)
				predicate = criteriaBuilder.greaterThan(root.<Date> get(criteriaObject.getFieldName()),
						(Date) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof String)
				predicate = criteriaBuilder.greaterThan(root.<String> get(criteriaObject.getFieldName()),
						(String) criteriaObject.getValue());
			break;

		case GREATER_EQUAL:
			if (criteriaObject.getValue() instanceof Number)
				predicate = criteriaBuilder.ge(root.<Number> get(criteriaObject.getFieldName()),
						(Number) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof Date)
				predicate = criteriaBuilder.greaterThanOrEqualTo(root.<Date> get(criteriaObject.getFieldName()),
						(Date) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof String)
				predicate = criteriaBuilder.greaterThanOrEqualTo(root.<String> get(criteriaObject.getFieldName()),
						(String) criteriaObject.getValue());
			break;

		case EQUALS:
			predicate = criteriaBuilder.equal(root.get(criteriaObject.getFieldName()), criteriaObject.getValue());
			break;
		case NOT_EQUALS:
			predicate = criteriaBuilder.notEqual(root.get(criteriaObject.getFieldName()), criteriaObject.getValue());
			break;
		case LESS_THAN:
			if (criteriaObject.getValue() instanceof Number)
				predicate = criteriaBuilder.lt(root.<Number> get(criteriaObject.getFieldName()),
						(Number) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof Date)
				predicate = criteriaBuilder.lessThan(root.<Date> get(criteriaObject.getFieldName()),
						(Date) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof String)
				predicate = criteriaBuilder.lessThan(root.<String> get(criteriaObject.getFieldName()),
						(String) criteriaObject.getValue());

			break;
		case LESSOR_THAN_EQUAL:
			if (criteriaObject.getValue() instanceof Number)
				predicate = criteriaBuilder.le(root.<Number> get(criteriaObject.getFieldName()),
						(Number) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof Date)
				predicate = criteriaBuilder.lessThanOrEqualTo(root.<Date> get(criteriaObject.getFieldName()),
						(Date) criteriaObject.getValue());
			else if (criteriaObject.getValue() instanceof String)
				predicate = criteriaBuilder.lessThanOrEqualTo(root.<String> get(criteriaObject.getFieldName()),
						(String) criteriaObject.getValue());

			break;
		default:
			LOGGER.error("Error : CASE NOT FOUND");
			break;
		}
		return predicate;

	}
}
