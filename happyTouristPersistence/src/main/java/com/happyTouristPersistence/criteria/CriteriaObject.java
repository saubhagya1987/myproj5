/**
 * 
 */
package com.happyTouristPersistence.criteria;

import com.happyTouristPersistence.enums.RelationalOperator;






public class CriteriaObject {

	private String fieldName;
	private RelationalOperator operator;
	private Object value;
	
	
	public CriteriaObject(){}
	public CriteriaObject(String fieldName, RelationalOperator operator, Object value){
		super();
		this.fieldName = fieldName;
		this.operator = operator;
		this.value = value;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the operator
	 */
	public RelationalOperator getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(RelationalOperator operator) {
		this.operator = operator;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
