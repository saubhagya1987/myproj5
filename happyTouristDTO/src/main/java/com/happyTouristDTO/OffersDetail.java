package com.happyTouristDTO;

import java.util.List;

public class OffersDetail {
	
	 private String priceFootnote;
	 private List<Offers> offers;
     private String sameDateSearch;
	public String getPriceFootnote() {
		return priceFootnote;
	}
	public void setPriceFootnote(String priceFootnote) {
		this.priceFootnote = priceFootnote;
	}
	public List<Offers> getOffers() {
		return offers;
	}
	public void setOffers(List<Offers> offers) {
		this.offers = offers;
	}
	public String getSameDateSearch() {
		return sameDateSearch;
	}
	public void setSameDateSearch(String sameDateSearch) {
		this.sameDateSearch = sameDateSearch;
	}

}
