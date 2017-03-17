package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Activities {
	
	 private String fromPriceLabel;

	    private String recommendationScore;

	    private String supplierName;

	    private String latLng;

	    private String freeCancellation;

	    private String imageUrl;

	    private String fromOriginalPrice;

	    private String id;

	    private String largeImageURL;

	    private String title;

	    private String duration;

	    private String discountType;

	    private String fromPrice;

	    private String shortDescription;

	    private String discountPercentage;

	    private String fromOriginalPriceValue;

	    private String fromPriceTicketType;

	    private List<String> categories;

	    private String redemptionType;

		public String getFromPriceLabel() {
			return fromPriceLabel;
		}

		public void setFromPriceLabel(String fromPriceLabel) {
			this.fromPriceLabel = fromPriceLabel;
		}

		public String getRecommendationScore() {
			return recommendationScore;
		}

		public void setRecommendationScore(String recommendationScore) {
			this.recommendationScore = recommendationScore;
		}

		public String getSupplierName() {
			return supplierName;
		}

		public void setSupplierName(String supplierName) {
			this.supplierName = supplierName;
		}

		public String getLatLng() {
			return latLng;
		}

		public void setLatLng(String latLng) {
			this.latLng = latLng;
		}

		public String getFreeCancellation() {
			return freeCancellation;
		}

		public void setFreeCancellation(String freeCancellation) {
			this.freeCancellation = freeCancellation;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getFromOriginalPrice() {
			return fromOriginalPrice;
		}

		public void setFromOriginalPrice(String fromOriginalPrice) {
			this.fromOriginalPrice = fromOriginalPrice;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLargeImageURL() {
			return largeImageURL;
		}

		public void setLargeImageURL(String largeImageURL) {
			this.largeImageURL = largeImageURL;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getDiscountType() {
			return discountType;
		}

		public void setDiscountType(String discountType) {
			this.discountType = discountType;
		}

		public String getFromPrice() {
			return fromPrice;
		}

		public void setFromPrice(String fromPrice) {
			this.fromPrice = fromPrice;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}

		public String getDiscountPercentage() {
			return discountPercentage;
		}

		public void setDiscountPercentage(String discountPercentage) {
			this.discountPercentage = discountPercentage;
		}

		public String getFromOriginalPriceValue() {
			return fromOriginalPriceValue;
		}

		public void setFromOriginalPriceValue(String fromOriginalPriceValue) {
			this.fromOriginalPriceValue = fromOriginalPriceValue;
		}

		public String getFromPriceTicketType() {
			return fromPriceTicketType;
		}

		public void setFromPriceTicketType(String fromPriceTicketType) {
			this.fromPriceTicketType = fromPriceTicketType;
		}

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

		public String getRedemptionType() {
			return redemptionType;
		}

		public void setRedemptionType(String redemptionType) {
			this.redemptionType = redemptionType;
		}

}
