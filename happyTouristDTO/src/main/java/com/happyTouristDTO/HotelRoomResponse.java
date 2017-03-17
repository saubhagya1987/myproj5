package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelRoomResponse {
	
	private String currentAllotment;

    private String roomTypeDescription;

    private String isSameDayDRR;

    private PromotionDetails promotionDetails;

    private String roomThumbnailUrl;

    private String guaranteeRequired;

    private String rateChange;

    private String rateDescription;

    private String quotedOccupancy;

    private String promoDescription;

    private String hasFreeCancellation;

    private String roomLongDescription;

    private String isMemberDeal;

    private List<BedTypes> bedTypes;

    private String minGuestAge;

    private String ratePlanCode;

    private String cancellationPolicy;

    private String nonRefundable;

    private String supplierType;

    private String smokingPreferences;

    private String depositRequired;

    private String isPayLater;

    private String productKey;

    private String immediateChargeRequired;

    private RateInfo rateInfo;

    private String isDiscountRestrictedToCurrentSourceType;

	public String getCurrentAllotment() {
		return currentAllotment;
	}

	public void setCurrentAllotment(String currentAllotment) {
		this.currentAllotment = currentAllotment;
	}

	public String getRoomTypeDescription() {
		return roomTypeDescription;
	}

	public void setRoomTypeDescription(String roomTypeDescription) {
		this.roomTypeDescription = roomTypeDescription;
	}

	public String getIsSameDayDRR() {
		return isSameDayDRR;
	}

	public void setIsSameDayDRR(String isSameDayDRR) {
		this.isSameDayDRR = isSameDayDRR;
	}

	public PromotionDetails getPromotionDetails() {
		return promotionDetails;
	}

	public void setPromotionDetails(PromotionDetails promotionDetails) {
		this.promotionDetails = promotionDetails;
	}

	public String getRoomThumbnailUrl() {
		return roomThumbnailUrl;
	}

	public void setRoomThumbnailUrl(String roomThumbnailUrl) {
		this.roomThumbnailUrl = roomThumbnailUrl;
	}

	public String getGuaranteeRequired() {
		return guaranteeRequired;
	}

	public void setGuaranteeRequired(String guaranteeRequired) {
		this.guaranteeRequired = guaranteeRequired;
	}

	public String getRateChange() {
		return rateChange;
	}

	public void setRateChange(String rateChange) {
		this.rateChange = rateChange;
	}

	public String getRateDescription() {
		return rateDescription;
	}

	public void setRateDescription(String rateDescription) {
		this.rateDescription = rateDescription;
	}

	public String getQuotedOccupancy() {
		return quotedOccupancy;
	}

	public void setQuotedOccupancy(String quotedOccupancy) {
		this.quotedOccupancy = quotedOccupancy;
	}

	public String getPromoDescription() {
		return promoDescription;
	}

	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}

	public String getHasFreeCancellation() {
		return hasFreeCancellation;
	}

	public void setHasFreeCancellation(String hasFreeCancellation) {
		this.hasFreeCancellation = hasFreeCancellation;
	}

	public String getRoomLongDescription() {
		return roomLongDescription;
	}

	public void setRoomLongDescription(String roomLongDescription) {
		this.roomLongDescription = roomLongDescription;
	}

	public String getIsMemberDeal() {
		return isMemberDeal;
	}

	public void setIsMemberDeal(String isMemberDeal) {
		this.isMemberDeal = isMemberDeal;
	}

	public List<BedTypes> getBedTypes() {
		return bedTypes;
	}

	public void setBedTypes(List<BedTypes> bedTypes) {
		this.bedTypes = bedTypes;
	}

	public String getMinGuestAge() {
		return minGuestAge;
	}

	public void setMinGuestAge(String minGuestAge) {
		this.minGuestAge = minGuestAge;
	}

	public String getRatePlanCode() {
		return ratePlanCode;
	}

	public void setRatePlanCode(String ratePlanCode) {
		this.ratePlanCode = ratePlanCode;
	}

	public String getCancellationPolicy() {
		return cancellationPolicy;
	}

	public void setCancellationPolicy(String cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}

	public String getNonRefundable() {
		return nonRefundable;
	}

	public void setNonRefundable(String nonRefundable) {
		this.nonRefundable = nonRefundable;
	}

	public String getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}

	public String getSmokingPreferences() {
		return smokingPreferences;
	}

	public void setSmokingPreferences(String smokingPreferences) {
		this.smokingPreferences = smokingPreferences;
	}

	public String getDepositRequired() {
		return depositRequired;
	}

	public void setDepositRequired(String depositRequired) {
		this.depositRequired = depositRequired;
	}

	public String getIsPayLater() {
		return isPayLater;
	}

	public void setIsPayLater(String isPayLater) {
		this.isPayLater = isPayLater;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getImmediateChargeRequired() {
		return immediateChargeRequired;
	}

	public void setImmediateChargeRequired(String immediateChargeRequired) {
		this.immediateChargeRequired = immediateChargeRequired;
	}

	public RateInfo getRateInfo() {
		return rateInfo;
	}

	public void setRateInfo(RateInfo rateInfo) {
		this.rateInfo = rateInfo;
	}

	public String getIsDiscountRestrictedToCurrentSourceType() {
		return isDiscountRestrictedToCurrentSourceType;
	}

	public void setIsDiscountRestrictedToCurrentSourceType(
			String isDiscountRestrictedToCurrentSourceType) {
		this.isDiscountRestrictedToCurrentSourceType = isDiscountRestrictedToCurrentSourceType;
	}

    

}
