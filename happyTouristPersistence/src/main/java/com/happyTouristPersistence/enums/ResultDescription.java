/**
 * 
 */
package com.happyTouristPersistence.enums;


public enum ResultDescription {
	
	SUCCESS(0), FAIL(1);
	
	/**
	 * @return the resultCode
	 */
	public final int getResultCode() {
		return resultCode;
	}

	private int resultCode;

	private ResultDescription(int resultCode){
		this.resultCode =resultCode;
	}


	@Override
	public String toString() {
		return this.name();
	}
}
