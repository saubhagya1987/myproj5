package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Review {
	 private String ratingHotelCondition;

	    private String isUnverified;

	    private String moderationStatus;

	    private String itinId;

	    private String ratingsOnly;

	    private String eapid;

	    private String negativeRemarks;

	    private String reviewText;

	    private String ratingRoomComfort;

	    

	    private String featured;

	    private String contentCodes;

	    private String reviewId;

	    private String hotelId;

	    private String tpid;

	    private String totalPositiveFeedbacks;

	    private String title;

	    private String userLocation;

	    private String lastInitial;

	    private String isRecommended;

	    private String roomTypeId;

	    private String isFlaggable;

	    private String brandType;

	    private String userDisplayName;

	    private String userNickname;

	    private String ratingService;

	    private String positiveRemarks;

	    private String ratingRoomCleanliness;

	    

	    

	    private String locationRemarks;

	    private String totalThanks;

	    private String langId;

	    private String ratingOverall;

	    private String reviewSubmissionTime;

	    private String contentLocale;
	   // private List<String> managementResponses;
	    private List<ReviewerCategories> reviewerCategories;
	    //private List<String> photos;
	    
	    private List<Aspect> aspects;    

	    private String author_name;    

	    private String author_url;    

	    private String language;    

	    private String profile_photo_url;    

	    private int rating;    

	    private String text;    

	    private int time;    
	    
	    
	    
	    
	    
	    
		public String getRatingHotelCondition() {
			return ratingHotelCondition;
		}

		public void setRatingHotelCondition(String ratingHotelCondition) {
			this.ratingHotelCondition = ratingHotelCondition;
		}

		public String getIsUnverified() {
			return isUnverified;
		}

		public void setIsUnverified(String isUnverified) {
			this.isUnverified = isUnverified;
		}

		public String getModerationStatus() {
			return moderationStatus;
		}

		public void setModerationStatus(String moderationStatus) {
			this.moderationStatus = moderationStatus;
		}

		public String getItinId() {
			return itinId;
		}

		public void setItinId(String itinId) {
			this.itinId = itinId;
		}

		public String getRatingsOnly() {
			return ratingsOnly;
		}

		public void setRatingsOnly(String ratingsOnly) {
			this.ratingsOnly = ratingsOnly;
		}

		public String getEapid() {
			return eapid;
		}

		public void setEapid(String eapid) {
			this.eapid = eapid;
		}

		public String getNegativeRemarks() {
			return negativeRemarks;
		}

		public void setNegativeRemarks(String negativeRemarks) {
			this.negativeRemarks = negativeRemarks;
		}

		public String getReviewText() {
			return reviewText;
		}

		public void setReviewText(String reviewText) {
			this.reviewText = reviewText;
		}

		public String getRatingRoomComfort() {
			return ratingRoomComfort;
		}

		public void setRatingRoomComfort(String ratingRoomComfort) {
			this.ratingRoomComfort = ratingRoomComfort;
		}

		

		public String getFeatured() {
			return featured;
		}

		public void setFeatured(String featured) {
			this.featured = featured;
		}

		public String getContentCodes() {
			return contentCodes;
		}

		public void setContentCodes(String contentCodes) {
			this.contentCodes = contentCodes;
		}

		public String getReviewId() {
			return reviewId;
		}

		public void setReviewId(String reviewId) {
			this.reviewId = reviewId;
		}

		public String getHotelId() {
			return hotelId;
		}

		public void setHotelId(String hotelId) {
			this.hotelId = hotelId;
		}

		public String getTpid() {
			return tpid;
		}

		public void setTpid(String tpid) {
			this.tpid = tpid;
		}

		public String getTotalPositiveFeedbacks() {
			return totalPositiveFeedbacks;
		}

		public void setTotalPositiveFeedbacks(String totalPositiveFeedbacks) {
			this.totalPositiveFeedbacks = totalPositiveFeedbacks;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUserLocation() {
			return userLocation;
		}

		public void setUserLocation(String userLocation) {
			this.userLocation = userLocation;
		}

		public String getLastInitial() {
			return lastInitial;
		}

		public void setLastInitial(String lastInitial) {
			this.lastInitial = lastInitial;
		}

		public String getIsRecommended() {
			return isRecommended;
		}

		public void setIsRecommended(String isRecommended) {
			this.isRecommended = isRecommended;
		}

		public String getRoomTypeId() {
			return roomTypeId;
		}

		public void setRoomTypeId(String roomTypeId) {
			this.roomTypeId = roomTypeId;
		}

		public String getIsFlaggable() {
			return isFlaggable;
		}

		public void setIsFlaggable(String isFlaggable) {
			this.isFlaggable = isFlaggable;
		}

		public String getBrandType() {
			return brandType;
		}

		public void setBrandType(String brandType) {
			this.brandType = brandType;
		}

		public String getUserDisplayName() {
			return userDisplayName;
		}

		public void setUserDisplayName(String userDisplayName) {
			this.userDisplayName = userDisplayName;
		}

		public String getUserNickname() {
			return userNickname;
		}

		public void setUserNickname(String userNickname) {
			this.userNickname = userNickname;
		}

		public String getRatingService() {
			return ratingService;
		}

		public void setRatingService(String ratingService) {
			this.ratingService = ratingService;
		}

		public String getPositiveRemarks() {
			return positiveRemarks;
		}

		public void setPositiveRemarks(String positiveRemarks) {
			this.positiveRemarks = positiveRemarks;
		}

		public String getRatingRoomCleanliness() {
			return ratingRoomCleanliness;
		}

		public void setRatingRoomCleanliness(String ratingRoomCleanliness) {
			this.ratingRoomCleanliness = ratingRoomCleanliness;
		}

		
		public String getLocationRemarks() {
			return locationRemarks;
		}

		public void setLocationRemarks(String locationRemarks) {
			this.locationRemarks = locationRemarks;
		}

		public String getTotalThanks() {
			return totalThanks;
		}

		public void setTotalThanks(String totalThanks) {
			this.totalThanks = totalThanks;
		}

		public String getLangId() {
			return langId;
		}

		public void setLangId(String langId) {
			this.langId = langId;
		}

		public String getRatingOverall() {
			return ratingOverall;
		}

		public void setRatingOverall(String ratingOverall) {
			this.ratingOverall = ratingOverall;
		}

		public String getReviewSubmissionTime() {
			return reviewSubmissionTime;
		}

		public void setReviewSubmissionTime(String reviewSubmissionTime) {
			this.reviewSubmissionTime = reviewSubmissionTime;
		}

		public String getContentLocale() {
			return contentLocale;
		}

		public void setContentLocale(String contentLocale) {
			this.contentLocale = contentLocale;
		}

		public List<ReviewerCategories> getReviewerCategories() {
			return reviewerCategories;
		}

		public void setReviewerCategories(List<ReviewerCategories> reviewerCategories) {
			this.reviewerCategories = reviewerCategories;
		}

		public List<Aspect> getAspects() {
			return aspects;
		}

		public void setAspects(List<Aspect> aspects) {
			this.aspects = aspects;
		}

		public String getAuthor_name() {
			return author_name;
		}

		public void setAuthor_name(String author_name) {
			this.author_name = author_name;
		}

		public String getAuthor_url() {
			return author_url;
		}

		public void setAuthor_url(String author_url) {
			this.author_url = author_url;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getProfile_photo_url() {
			return profile_photo_url;
		}

		public void setProfile_photo_url(String profile_photo_url) {
			this.profile_photo_url = profile_photo_url;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		/*public List<String> getManagementResponses() {
			return managementResponses;
		}

		public void setManagementResponses(List<String> managementResponses) {
			this.managementResponses = managementResponses;
		}*/
}
