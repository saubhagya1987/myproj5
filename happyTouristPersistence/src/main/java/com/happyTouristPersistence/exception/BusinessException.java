package com.happyTouristPersistence.exception;

import com.happyTouristPersistence.enums.ResultDescription;



public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String exceptionCode;
	private String exceptionMessage;
	private ResultDescription resultDescription = ResultDescription.FAIL;

	/**
	 * @return the resultDescription
	 */
	public final ResultDescription getResultDescription() {
		return resultDescription;
	}

	/**
	 * @param resultDescription the resultDescription to set
	 */
	public final void setResultDescription(ResultDescription resultDescription) {
		this.resultDescription = resultDescription;
	}

	public BusinessException() {
	}

	public BusinessException(String exceptionCode) {
		super(exceptionCode);
		this.setExceptionCode(exceptionCode);
	}

	/*
	 * public BusinessException(String exceptionMessage) {
	 * super(exceptionMessage); this.exceptionMessage(exceptionMessage); }
	 */

	public BusinessException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public BusinessException(Throwable throwable) {
		super(throwable);
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
