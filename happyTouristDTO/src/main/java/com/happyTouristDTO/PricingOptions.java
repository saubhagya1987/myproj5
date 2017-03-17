package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricingOptions {
	
	private List<String> Agents;

    private String QuoteAgeInMinutes;

    private String DeeplinkUrl;

    private String Price;

	
	public List<String> getAgents() {
		return Agents;
	}

	public void setAgents(List<String> agents) {
		Agents = agents;
	}

	public String getQuoteAgeInMinutes() {
		return QuoteAgeInMinutes;
	}

	public void setQuoteAgeInMinutes(String quoteAgeInMinutes) {
		QuoteAgeInMinutes = quoteAgeInMinutes;
	}

	public String getDeeplinkUrl() {
		return DeeplinkUrl;
	}

	public void setDeeplinkUrl(String deeplinkUrl) {
		DeeplinkUrl = deeplinkUrl;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

}
