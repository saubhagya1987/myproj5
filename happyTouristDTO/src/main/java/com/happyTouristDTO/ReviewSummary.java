package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewSummary {
	private LanguageCounts languageCounts;

    private String neighborhoodSatisfaction;

    private String valueForMoney;

    private String roomComfort;

    private String serviceAndStaff;

    private CategoryCounts categoryCounts;

    private String avgOverallRating;

    private String hotelId;

    private String totalReviewCnt;

    private String convenienceOfLocation;

    //private String featuredReview;

    private String roomQuality;

    private String recommendedPercent;

    private String targetedBrand;

    private String cleanliness;

    private List<OriginSummary> originSummary;

    private RoomTypeIdCounts roomTypeIdCounts;

    private String hotelCondition;

	public LanguageCounts getLanguageCounts() {
		return languageCounts;
	}

	public void setLanguageCounts(LanguageCounts languageCounts) {
		this.languageCounts = languageCounts;
	}

	public String getNeighborhoodSatisfaction() {
		return neighborhoodSatisfaction;
	}

	public void setNeighborhoodSatisfaction(String neighborhoodSatisfaction) {
		this.neighborhoodSatisfaction = neighborhoodSatisfaction;
	}

	public String getValueForMoney() {
		return valueForMoney;
	}

	public void setValueForMoney(String valueForMoney) {
		this.valueForMoney = valueForMoney;
	}

	public String getRoomComfort() {
		return roomComfort;
	}

	public void setRoomComfort(String roomComfort) {
		this.roomComfort = roomComfort;
	}

	public String getServiceAndStaff() {
		return serviceAndStaff;
	}

	public void setServiceAndStaff(String serviceAndStaff) {
		this.serviceAndStaff = serviceAndStaff;
	}

	public CategoryCounts getCategoryCounts() {
		return categoryCounts;
	}

	public void setCategoryCounts(CategoryCounts categoryCounts) {
		this.categoryCounts = categoryCounts;
	}

	public String getAvgOverallRating() {
		return avgOverallRating;
	}

	public void setAvgOverallRating(String avgOverallRating) {
		this.avgOverallRating = avgOverallRating;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getTotalReviewCnt() {
		return totalReviewCnt;
	}

	public void setTotalReviewCnt(String totalReviewCnt) {
		this.totalReviewCnt = totalReviewCnt;
	}

	public String getConvenienceOfLocation() {
		return convenienceOfLocation;
	}

	public void setConvenienceOfLocation(String convenienceOfLocation) {
		this.convenienceOfLocation = convenienceOfLocation;
	}

		public String getRoomQuality() {
		return roomQuality;
	}

	public void setRoomQuality(String roomQuality) {
		this.roomQuality = roomQuality;
	}

	public String getRecommendedPercent() {
		return recommendedPercent;
	}

	public void setRecommendedPercent(String recommendedPercent) {
		this.recommendedPercent = recommendedPercent;
	}

	public String getTargetedBrand() {
		return targetedBrand;
	}

	public void setTargetedBrand(String targetedBrand) {
		this.targetedBrand = targetedBrand;
	}

	public String getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(String cleanliness) {
		this.cleanliness = cleanliness;
	}

	public List<OriginSummary> getOriginSummary() {
		return originSummary;
	}

	public void setOriginSummary(List<OriginSummary> originSummary) {
		this.originSummary = originSummary;
	}

	public RoomTypeIdCounts getRoomTypeIdCounts() {
		return roomTypeIdCounts;
	}

	public void setRoomTypeIdCounts(RoomTypeIdCounts roomTypeIdCounts) {
		this.roomTypeIdCounts = roomTypeIdCounts;
	}

	public String getHotelCondition() {
		return hotelCondition;
	}

	public void setHotelCondition(String hotelCondition) {
		this.hotelCondition = hotelCondition;
	}
}
