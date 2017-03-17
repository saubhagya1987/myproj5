package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionDetails {
	
	 private String minStay;

	    private String promoAdjustmentAmount;

	    private String promoExpirationDate;

		public String getMinStay() {
			return minStay;
		}

		public void setMinStay(String minStay) {
			this.minStay = minStay;
		}

		public String getPromoAdjustmentAmount() {
			return promoAdjustmentAmount;
		}

		public void setPromoAdjustmentAmount(String promoAdjustmentAmount) {
			this.promoAdjustmentAmount = promoAdjustmentAmount;
		}

		public String getPromoExpirationDate() {
			return promoExpirationDate;
		}

		public void setPromoExpirationDate(String promoExpirationDate) {
			this.promoExpirationDate = promoExpirationDate;
		}

}
