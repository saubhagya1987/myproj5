package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Result {
	
	  private Geometry geometry;
	  private String icon;
	  private String id;
	  private String name;
	  private OpeningHours opening_hours;
	  private List<Photo> photos;
	  private String place_id;
	  private int price_level;
	  private double rating;	  
	  private String reference;	  
	  private String scope;	  
	  private List<String> types;	  
	  private String vicinity;  	 
      
	  //Added For Places	  
	  private List<AddressComponent> address_components;
	  private String adr_address;
	  private String formatted_address;   
	  private String url;
	  private int utc_offset;
	  private List<Review> reviews;
	  private String international_phone_number;
	  private String formatted_phone_number;
	  private String website;

	  
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OpeningHours getOpening_hours() {
		return opening_hours;
	}
	public void setOpening_hours(OpeningHours opening_hours) {
		this.opening_hours = opening_hours;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public int getPrice_level() {
		return price_level;
	}
	public void setPrice_level(int price_level) {
		this.price_level = price_level;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	public List<AddressComponent> getAddress_components() {
		return address_components;
	}
	public void setAddress_components(List<AddressComponent> address_components) {
		this.address_components = address_components;
	}
	public String getAdr_address() {
		return adr_address;
	}
	public void setAdr_address(String adr_address) {
		this.adr_address = adr_address;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getUtc_offset() {
		return utc_offset;
	}
	public void setUtc_offset(int utc_offset) {
		this.utc_offset = utc_offset;
	}
	public String getInternational_phone_number() {
		return international_phone_number;
	}
	public void setInternational_phone_number(String international_phone_number) {
		this.international_phone_number = international_phone_number;
	}
	public String getFormatted_phone_number() {
		return formatted_phone_number;
	}
	public void setFormatted_phone_number(String formatted_phone_number) {
		this.formatted_phone_number = formatted_phone_number;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	  

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	  	

}
