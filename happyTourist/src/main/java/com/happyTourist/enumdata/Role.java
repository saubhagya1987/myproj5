package com.happyTourist.enumdata;

public enum Role {
	ROLE_USER("ROLE_USER");
	
	private String key;
	private  Role (String key){
		 this.key = key;
	 }

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

}
