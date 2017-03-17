package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelList {
	
	private String deepLinkUrl;
	
	private String discountMessage;

    private String isPaymentChoiceAvailable;

    private String roomsLeftAtThisRate;

    private String proximityDistanceInMiles;

    private String isMobileExclusive;

    private String city;

    private String notAvailableMessage;

    private String isDudley;

    private String hotelGuestRating;

    private String postalCode;

    private String shortDiscountMessage;

    private String longitude;

    private String hasFreeCancellation;

    private String hotelStarRating;

    private String locationDescription;

    private String isMemberDeal;

    private String countryCode;

    private String isShowEtpChoice;

    private LowRateInfo lowRateInfo;

    private String largeThumbnailUrl;

    private String shortDescription;

    private String proximityDistanceInKiloMeters;

    private String latitude;

    private String isSponsoredListing;

    private String isDiscountRestrictedToCurrentSourceType;

    private String isSameDayDRR;

    private String didGetBackHighestPriceFromSurvey;

    private String locationId;

    private String rateCurrencySymbol;

    private String hotelId;

    private String isHotelAvailable;

    private String localizedName;

    private JsonHotelBrand jsonHotelBrand;

    private String totalRecommendations;

    private String name;

    private String thumbnailUrl;

    private String rateCurrencyCode;

    private String sortIndex;

    private List<Amenities> amenities;

    private String hotelStarRatingCssClassName;

    private String isVipAccess;

    private String totalReviews;

    private String nonLocalizedName;

    private String supplierType;

    private String lowRate;

    private String address;

    private String stateProvinceCode;

    private String airportCode;

    private String distanceUnit;

    private String percentRecommended;

	public String getDiscountMessage() {
		return discountMessage;
	}

	public void setDiscountMessage(String discountMessage) {
		this.discountMessage = discountMessage;
	}

	public String getIsPaymentChoiceAvailable() {
		return isPaymentChoiceAvailable;
	}

	public void setIsPaymentChoiceAvailable(String isPaymentChoiceAvailable) {
		this.isPaymentChoiceAvailable = isPaymentChoiceAvailable;
	}

	public String getRoomsLeftAtThisRate() {
		return roomsLeftAtThisRate;
	}

	public void setRoomsLeftAtThisRate(String roomsLeftAtThisRate) {
		this.roomsLeftAtThisRate = roomsLeftAtThisRate;
	}

	public String getProximityDistanceInMiles() {
		return proximityDistanceInMiles;
	}

	public void setProximityDistanceInMiles(String proximityDistanceInMiles) {
		this.proximityDistanceInMiles = proximityDistanceInMiles;
	}

	public String getIsMobileExclusive() {
		return isMobileExclusive;
	}

	public void setIsMobileExclusive(String isMobileExclusive) {
		this.isMobileExclusive = isMobileExclusive;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNotAvailableMessage() {
		return notAvailableMessage;
	}

	public void setNotAvailableMessage(String notAvailableMessage) {
		this.notAvailableMessage = notAvailableMessage;
	}

	public String getIsDudley() {
		return isDudley;
	}

	public void setIsDudley(String isDudley) {
		this.isDudley = isDudley;
	}

	public String getHotelGuestRating() {
		return hotelGuestRating;
	}

	public void setHotelGuestRating(String hotelGuestRating) {
		this.hotelGuestRating = hotelGuestRating;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getShortDiscountMessage() {
		return shortDiscountMessage;
	}

	public void setShortDiscountMessage(String shortDiscountMessage) {
		this.shortDiscountMessage = shortDiscountMessage;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getHasFreeCancellation() {
		return hasFreeCancellation;
	}

	public void setHasFreeCancellation(String hasFreeCancellation) {
		this.hasFreeCancellation = hasFreeCancellation;
	}

	public String getHotelStarRating() {
		return hotelStarRating;
	}

	public void setHotelStarRating(String hotelStarRating) {
		this.hotelStarRating = hotelStarRating;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getIsMemberDeal() {
		return isMemberDeal;
	}

	public void setIsMemberDeal(String isMemberDeal) {
		this.isMemberDeal = isMemberDeal;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getIsShowEtpChoice() {
		return isShowEtpChoice;
	}

	public void setIsShowEtpChoice(String isShowEtpChoice) {
		this.isShowEtpChoice = isShowEtpChoice;
	}

	public LowRateInfo getLowRateInfo() {
		return lowRateInfo;
	}

	public void setLowRateInfo(LowRateInfo lowRateInfo) {
		this.lowRateInfo = lowRateInfo;
	}

	public String getLargeThumbnailUrl() {
		return largeThumbnailUrl;
	}

	public void setLargeThumbnailUrl(String largeThumbnailUrl) {
		this.largeThumbnailUrl = largeThumbnailUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getProximityDistanceInKiloMeters() {
		return proximityDistanceInKiloMeters;
	}

	public void setProximityDistanceInKiloMeters(
			String proximityDistanceInKiloMeters) {
		this.proximityDistanceInKiloMeters = proximityDistanceInKiloMeters;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getIsSponsoredListing() {
		return isSponsoredListing;
	}

	public void setIsSponsoredListing(String isSponsoredListing) {
		this.isSponsoredListing = isSponsoredListing;
	}

	public String getIsDiscountRestrictedToCurrentSourceType() {
		return isDiscountRestrictedToCurrentSourceType;
	}

	public void setIsDiscountRestrictedToCurrentSourceType(
			String isDiscountRestrictedToCurrentSourceType) {
		this.isDiscountRestrictedToCurrentSourceType = isDiscountRestrictedToCurrentSourceType;
	}

	public String getIsSameDayDRR() {
		return isSameDayDRR;
	}

	public void setIsSameDayDRR(String isSameDayDRR) {
		this.isSameDayDRR = isSameDayDRR;
	}

	public String getDidGetBackHighestPriceFromSurvey() {
		return didGetBackHighestPriceFromSurvey;
	}

	public void setDidGetBackHighestPriceFromSurvey(
			String didGetBackHighestPriceFromSurvey) {
		this.didGetBackHighestPriceFromSurvey = didGetBackHighestPriceFromSurvey;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getRateCurrencySymbol() {
		return rateCurrencySymbol;
	}

	public void setRateCurrencySymbol(String rateCurrencySymbol) {
		this.rateCurrencySymbol = rateCurrencySymbol;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getIsHotelAvailable() {
		return isHotelAvailable;
	}

	public void setIsHotelAvailable(String isHotelAvailable) {
		this.isHotelAvailable = isHotelAvailable;
	}

	public String getLocalizedName() {
		return localizedName;
	}

	public void setLocalizedName(String localizedName) {
		this.localizedName = localizedName;
	}

	public JsonHotelBrand getJsonHotelBrand() {
		return jsonHotelBrand;
	}

	public void setJsonHotelBrand(JsonHotelBrand jsonHotelBrand) {
		this.jsonHotelBrand = jsonHotelBrand;
	}

	public String getTotalRecommendations() {
		return totalRecommendations;
	}

	public void setTotalRecommendations(String totalRecommendations) {
		this.totalRecommendations = totalRecommendations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getRateCurrencyCode() {
		return rateCurrencyCode;
	}

	public void setRateCurrencyCode(String rateCurrencyCode) {
		this.rateCurrencyCode = rateCurrencyCode;
	}

	public String getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(String sortIndex) {
		this.sortIndex = sortIndex;
	}

	public List<Amenities> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<Amenities> amenities) {
		this.amenities = amenities;
	}

	public String getHotelStarRatingCssClassName() {
		return hotelStarRatingCssClassName;
	}

	public void setHotelStarRatingCssClassName(String hotelStarRatingCssClassName) {
		this.hotelStarRatingCssClassName = hotelStarRatingCssClassName;
	}

	public String getIsVipAccess() {
		return isVipAccess;
	}

	public void setIsVipAccess(String isVipAccess) {
		this.isVipAccess = isVipAccess;
	}

	public String getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(String totalReviews) {
		this.totalReviews = totalReviews;
	}

	public String getNonLocalizedName() {
		return nonLocalizedName;
	}

	public void setNonLocalizedName(String nonLocalizedName) {
		this.nonLocalizedName = nonLocalizedName;
	}

	public String getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}

	public String getLowRate() {
		return lowRate;
	}

	public void setLowRate(String lowRate) {
		this.lowRate = lowRate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStateProvinceCode() {
		return stateProvinceCode;
	}

	public void setStateProvinceCode(String stateProvinceCode) {
		this.stateProvinceCode = stateProvinceCode;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getDistanceUnit() {
		return distanceUnit;
	}

	public void setDistanceUnit(String distanceUnit) {
		this.distanceUnit = distanceUnit;
	}

	public String getPercentRecommended() {
		return percentRecommended;
	}

	public void setPercentRecommended(String percentRecommended) {
		this.percentRecommended = percentRecommended;
	}

	public String getDeepLinkUrl() {
		return deepLinkUrl;
	}

	public void setDeepLinkUrl(String deepLinkUrl) {
		this.deepLinkUrl = deepLinkUrl;
	}


}
