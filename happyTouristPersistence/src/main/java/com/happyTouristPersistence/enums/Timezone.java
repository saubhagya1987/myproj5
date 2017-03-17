/**
 * 
 */
package com.happyTouristPersistence.enums;

/**
 * @author Saubhagya
 *
 */
public enum Timezone {
UTC("UTC");
private String timeZone;
/**
 * @return the code
 */
public String getTimezone() {
	return timeZone;
}
private Timezone(String timeZone){
	this.timeZone =timeZone;
}
}
