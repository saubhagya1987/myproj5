package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OriginSummary {
	
	private LanguageCounts languageCounts;

    private String neighborhoodSatisfaction;

    private String valueForMoney;

    private String roomComfort;

    private String origin;

    private String serviceAndStaff;

    private CategoryCounts categoryCounts;

    private String avgOverallRating;

    private String convenienceOfLocation;

    private String roomQuality;

    private String reviewCnt;

    private String recommendedPercent;

    private String cleanliness;

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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
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

	public String getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(String reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public String getRecommendedPercent() {
		return recommendedPercent;
	}

	public void setRecommendedPercent(String recommendedPercent) {
		this.recommendedPercent = recommendedPercent;
	}

	public String getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(String cleanliness) {
		this.cleanliness = cleanliness;
	}

	
	public String getHotelCondition() {
		return hotelCondition;
	}

	public void setHotelCondition(String hotelCondition) {
		this.hotelCondition = hotelCondition;
	}

	public RoomTypeIdCounts getRoomTypeIdCounts() {
		return roomTypeIdCounts;
	}

	public void setRoomTypeIdCounts(RoomTypeIdCounts roomTypeIdCounts) {
		this.roomTypeIdCounts = roomTypeIdCounts;
	}

}
