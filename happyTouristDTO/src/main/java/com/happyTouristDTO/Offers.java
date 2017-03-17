package com.happyTouristDTO;

import java.util.List;

public class Offers {
	private String id;
    private String duration;
    private String title;
    private String freeCancellation;
    //private null discountType;
    private List<AvailabilityInfo> availabilityInfo;
    private String defaultTicketCountPrice;
    private String description;
    private String withinRange;
    private String discountPercentage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFreeCancellation() {
		return freeCancellation;
	}
	public void setFreeCancellation(String freeCancellation) {
		this.freeCancellation = freeCancellation;
	}
	public List<AvailabilityInfo> getAvailabilityInfo() {
		return availabilityInfo;
	}
	public void setAvailabilityInfo(List<AvailabilityInfo> availabilityInfo) {
		this.availabilityInfo = availabilityInfo;
	}
	public String getDefaultTicketCountPrice() {
		return defaultTicketCountPrice;
	}
	public void setDefaultTicketCountPrice(String defaultTicketCountPrice) {
		this.defaultTicketCountPrice = defaultTicketCountPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWithinRange() {
		return withinRange;
	}
	public void setWithinRange(String withinRange) {
		this.withinRange = withinRange;
	}
	public String getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

}
