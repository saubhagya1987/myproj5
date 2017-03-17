package com.happyTouristDTO;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
//@Document(collection="expedia_hotel_search")
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelResponseDto {
	private String totalHotelCount;
	private String deepLinkUrl;
	private List<HotelList> hotelList;
	private List<HotelRoomResponse> hotelRoomResponse;
	private String hotelId;
	private String hotelName;
	private String localizedHotelName;
	private String nonLocalizedHotelName;
	private String hotelAddress;
	private String hotelCity;
	private String hotelStateProvince;
	private String hotelCountry;
	private String latitude;
	private String longitude;
	private String longDescription;
	private List<Photos> photos;
	private ReviewDetails reviewDetails;
	
	//for Hotel Search
    private List<Activities> activities;
    
    //for top Attraction
    private List<TopAttractionResponseDto> topAttractionResponseDto;
    
    //for Activity Details
    private ActivityDetailsDto activityDetailsDto;
    //For Load More
    private Boolean noMoreHotel;


	public Boolean getNoMoreHotel() {
		return noMoreHotel;
	}
	public void setNoMoreHotel(Boolean noMoreHotel) {
		this.noMoreHotel = noMoreHotel;
	}
	public String getDeepLinkUrl() {
		return deepLinkUrl;
	}
	public void setDeepLinkUrl(String deepLinkUrl) {
		this.deepLinkUrl = deepLinkUrl;
	}
	public List<HotelList> getHotelList() {
		return hotelList;
	}
	public void setHotelList(List<HotelList> hotelList) {
		this.hotelList = hotelList;
	}
	public List<HotelRoomResponse> getHotelRoomResponse() {
		return hotelRoomResponse;
	}
	public void setHotelRoomResponse(List<HotelRoomResponse> hotelRoomResponse) {
		this.hotelRoomResponse = hotelRoomResponse;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocalizedHotelName() {
		return localizedHotelName;
	}
	public void setLocalizedHotelName(String localizedHotelName) {
		this.localizedHotelName = localizedHotelName;
	}
	public String getNonLocalizedHotelName() {
		return nonLocalizedHotelName;
	}
	public void setNonLocalizedHotelName(String nonLocalizedHotelName) {
		this.nonLocalizedHotelName = nonLocalizedHotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	public String getHotelStateProvince() {
		return hotelStateProvince;
	}
	public void setHotelStateProvince(String hotelStateProvince) {
		this.hotelStateProvince = hotelStateProvince;
	}
	public String getHotelCountry() {
		return hotelCountry;
	}
	public void setHotelCountry(String hotelCountry) {
		this.hotelCountry = hotelCountry;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public List<Photos> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}
	public ReviewDetails getReviewDetails() {
		return reviewDetails;
	}
	public void setReviewDetails(ReviewDetails reviewDetails) {
		this.reviewDetails = reviewDetails;
	}
	public List<Activities> getActivities() {
		return activities;
	}
	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}
	public String getTotalHotelCount() {
		return totalHotelCount;
	}
	public void setTotalHotelCount(String totalHotelCount) {
		this.totalHotelCount = totalHotelCount;
	}
	public List<TopAttractionResponseDto> getTopAttractionResponseDto() {
		return topAttractionResponseDto;
	}
	public void setTopAttractionResponseDto(
			List<TopAttractionResponseDto> topAttractionResponseDto) {
		this.topAttractionResponseDto = topAttractionResponseDto;
	}
	public ActivityDetailsDto getActivityDetailsDto() {
		return activityDetailsDto;
	}
	public void setActivityDetailsDto(ActivityDetailsDto activityDetailsDto) {
		this.activityDetailsDto = activityDetailsDto;
	}
	


}
