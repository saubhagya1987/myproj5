package com.happyTouristDTO;


public enum ResponseResult {
	OK(200), FAIL(400);
	private Integer code;

	private ResponseResult(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return code.toString();
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
}
