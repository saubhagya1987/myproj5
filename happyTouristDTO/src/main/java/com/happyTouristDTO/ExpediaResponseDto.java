package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpediaResponseDto {
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
    private Position position;
    private String id;
    private Source source;
    private String status;
    private String name;
    private String type;
    
    //For Activity Details
    private String fromPriceLabel;
    private String startDate;
    private String supplierName;
    private String location;
    private String metaKeywords;
    private String endDate;
    //private String id;
    private String title;
    private String fromPrice;
    private String dateAdjusted;
    private String description;
    private List<String> inclusions;
    private String discountPercentage;
    private String regionId;
    private String recommendationScore;
    private EventLocation eventLocation;
    private String staticMapUrl;
    private String currencyCode;
    private String freeCancellation;
    private String latLng;
    private String freeCancellationMinHours;
    //private String status;
    private List<String> knowBeforeYouBook;
    private String metaDescription;
    private OffersDetail offersDetail;
    private List<String> exclusions;
    private String fromOriginalPrice;
    private String termsAndConditions;
    private List<String> highlights;
    private String destination;
    private String cancellationPolicyText;
    private String category;
    private String duration;
    private String address;
    private List<RedemptionLocation> redemptionLocation;
    private String pageTitle;
    private String fromPriceTicketType;
    private String fromOriginalPriceValue;
    private List<Images> images;
    private String fullName;
    private String redemptionType;
    
    

    
	
	
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFromPriceLabel() {
		return fromPriceLabel;
	}
	public void setFromPriceLabel(String fromPriceLabel) {
		this.fromPriceLabel = fromPriceLabel;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMetaKeywords() {
		return metaKeywords;
	}
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFromPrice() {
		return fromPrice;
	}
	public void setFromPrice(String fromPrice) {
		this.fromPrice = fromPrice;
	}
	public String getDateAdjusted() {
		return dateAdjusted;
	}
	public void setDateAdjusted(String dateAdjusted) {
		this.dateAdjusted = dateAdjusted;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getInclusions() {
		return inclusions;
	}
	public void setInclusions(List<String> inclusions) {
		this.inclusions = inclusions;
	}
	public String getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRecommendationScore() {
		return recommendationScore;
	}
	public void setRecommendationScore(String recommendationScore) {
		this.recommendationScore = recommendationScore;
	}
	public EventLocation getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(EventLocation eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getStaticMapUrl() {
		return staticMapUrl;
	}
	public void setStaticMapUrl(String staticMapUrl) {
		this.staticMapUrl = staticMapUrl;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getFreeCancellation() {
		return freeCancellation;
	}
	public void setFreeCancellation(String freeCancellation) {
		this.freeCancellation = freeCancellation;
	}
	public String getLatLng() {
		return latLng;
	}
	public void setLatLng(String latLng) {
		this.latLng = latLng;
	}
	public String getFreeCancellationMinHours() {
		return freeCancellationMinHours;
	}
	public void setFreeCancellationMinHours(String freeCancellationMinHours) {
		this.freeCancellationMinHours = freeCancellationMinHours;
	}
	public List<String> getKnowBeforeYouBook() {
		return knowBeforeYouBook;
	}
	public void setKnowBeforeYouBook(List<String> knowBeforeYouBook) {
		this.knowBeforeYouBook = knowBeforeYouBook;
	}
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public OffersDetail getOffersDetail() {
		return offersDetail;
	}
	public void setOffersDetail(OffersDetail offersDetail) {
		this.offersDetail = offersDetail;
	}
	public List<String> getExclusions() {
		return exclusions;
	}
	public void setExclusions(List<String> exclusions) {
		this.exclusions = exclusions;
	}
	public String getFromOriginalPrice() {
		return fromOriginalPrice;
	}
	public void setFromOriginalPrice(String fromOriginalPrice) {
		this.fromOriginalPrice = fromOriginalPrice;
	}
	public String getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	public List<String> getHighlights() {
		return highlights;
	}
	public void setHighlights(List<String> highlights) {
		this.highlights = highlights;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCancellationPolicyText() {
		return cancellationPolicyText;
	}
	public void setCancellationPolicyText(String cancellationPolicyText) {
		this.cancellationPolicyText = cancellationPolicyText;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<RedemptionLocation> getRedemptionLocation() {
		return redemptionLocation;
	}
	public void setRedemptionLocation(List<RedemptionLocation> redemptionLocation) {
		this.redemptionLocation = redemptionLocation;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public String getFromPriceTicketType() {
		return fromPriceTicketType;
	}
	public void setFromPriceTicketType(String fromPriceTicketType) {
		this.fromPriceTicketType = fromPriceTicketType;
	}
	public String getFromOriginalPriceValue() {
		return fromOriginalPriceValue;
	}
	public void setFromOriginalPriceValue(String fromOriginalPriceValue) {
		this.fromOriginalPriceValue = fromOriginalPriceValue;
	}
	public List<Images> getImages() {
		return images;
	}
	public void setImages(List<Images> images) {
		this.images = images;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRedemptionType() {
		return redemptionType;
	}
	public void setRedemptionType(String redemptionType) {
		this.redemptionType = redemptionType;
	}

}
