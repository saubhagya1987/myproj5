package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateInfo {
	private String promo;

    private String priceBreakdown;

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getPriceBreakdown() {
		return priceBreakdown;
	}

	public void setPriceBreakdown(String priceBreakdown) {
		this.priceBreakdown = priceBreakdown;
	}
}
