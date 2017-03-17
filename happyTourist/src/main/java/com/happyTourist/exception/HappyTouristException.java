package com.happyTourist.exception;

import com.happyTourist.enumdata.HappyTouristCode;

public class HappyTouristException extends Exception {

	private static final long serialVersionUID = 1L;

	private HappyTouristCode happyTouristCode;

	public HappyTouristException() {
	}

	public HappyTouristException(HappyTouristCode happyTouristCode) {
		super(happyTouristCode.getDescription());
		this.setReefCode(happyTouristCode);
	}

	public HappyTouristException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public HappyTouristException(Throwable throwable) {
		super(throwable);
	}

	public HappyTouristCode getReefCode() {
		return happyTouristCode;
	}

	public void setReefCode(HappyTouristCode happyTouristCode) {
		this.happyTouristCode = happyTouristCode;
	}

}
