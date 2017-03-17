package com.happyTourist.enumdata;

public enum HappyTouristUserCode implements HappyTouristCode {
	HAPPY_TOURIST_USER(111), NOT_HAPPYTOURIST_USER(112),
	USER_NOT_FOUND(404), USER_NOT_ACTIVATED(405),USER_NOT_AUTHENTICATED(401),
	CLIENT_NOT_AUTHENTICATED(402), 
	CLIENT_NOT_FOUND(403);

	private final int code;

	private HappyTouristUserCode(int code) {
		this.code = code;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return this.name();
	}

}
