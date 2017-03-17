package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelDto {

	private String city;
	private String checkInDate;
	private String checkOutDate;
	private String room1;
	private String apikey;
	private String hotelId;
	private String location;
	private String startDate;
	private String endDate;
	private String latitude;
	private String longitude;
	private String resultsPerPage;
	private String within;
	private String type;
	private String activityId;
	
	private String limitCount;
	private String skipCount;
	
	private Boolean summary;
	private String sortBy;
	private String start;
	private String items;
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getRoom1() {
		return room1;
	}
	public void setRoom1(String room1) {
		this.room1 = room1;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getResultsPerPage() {
		return resultsPerPage;
	}
	public void setResultsPerPage(String resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}
	public String getWithin() {
		return within;
	}
	public void setWithin(String within) {
		this.within = within;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getLimitCount() {
		return limitCount;
	}
	public void setLimitCount(String limitCount) {
		this.limitCount = limitCount;
	}
	public String getSkipCount() {
		return skipCount;
	}
	public void setSkipCount(String skipCount) {
		this.skipCount = skipCount;
	}
	
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Boolean getSummary() {
		return summary;
	}
	public void setSummary(Boolean summary) {
		this.summary = summary;
	}
		
}
