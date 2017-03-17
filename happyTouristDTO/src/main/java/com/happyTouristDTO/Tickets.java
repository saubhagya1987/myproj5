package com.happyTouristDTO;

public class Tickets {
	
	private String originalAmount;

    private String price;

    private String ticketId;

    private String originalPrice;

    private String restrictionText;

    private Restriction restriction;

	public String getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(String originalAmount) {
		this.originalAmount = originalAmount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getRestrictionText() {
		return restrictionText;
	}

	public void setRestrictionText(String restrictionText) {
		this.restrictionText = restrictionText;
	}

	public Restriction getRestriction() {
		return restriction;
	}

	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}

}
