package com.happyTouristDTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightDto {
  private String apiKey;
  private String country;
  private String currency;
  private String locale;
  private String locationSchema;
  private boolean grouppricing;
  private String originplace;
  private String destinationplace;
  private Date outbounddate;
  private Date inbounddate;
  private Integer adults;
  private Integer children;
  private Integer infants;
  private String cabinclass;
  
  private String uri;
  private String outboundLegId;
  private String inboundLegId;
  
public String getUri() {
	return uri;
}
public void setUri(String uri) {
	this.uri = uri;
}
public String getApiKey() {
	return apiKey;
}
public void setApiKey(String apiKey) {
	this.apiKey = apiKey;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public String getLocale() {
	return locale;
}
public void setLocale(String locale) {
	this.locale = locale;
}
public String getLocationSchema() {
	return locationSchema;
}
public void setLocationSchema(String locationSchema) {
	this.locationSchema = locationSchema;
}
public boolean getGrouppricing() {
	return grouppricing;
}
public void setGrouppricing(boolean grouppricing) {
	this.grouppricing = grouppricing;
}
public String getOriginplace() {
	return originplace;
}
public void setOriginplace(String originplace) {
	this.originplace = originplace;
}
public String getDestinationplace() {
	return destinationplace;
}
public void setDestinationplace(String destinationplace) {
	this.destinationplace = destinationplace;
}
public Date getOutbounddate() {
	return outbounddate;
}
public void setOutbounddate(Date outbounddate) {
	this.outbounddate = outbounddate;
}
public Date getInbounddate() {
	return inbounddate;
}
public void setInbounddate(Date inbounddate) {
	this.inbounddate = inbounddate;
}
public Integer getAdults() {
	return adults;
}
public void setAdults(Integer adults) {
	this.adults = adults;
}
public Integer getChildren() {
	return children;
}
public void setChildren(Integer children) {
	this.children = children;
}
public Integer getInfants() {
	return infants;
}
public void setInfants(Integer infants) {
	this.infants = infants;
}
public String getOutboundLegId() {
	return outboundLegId;
}
public void setOutboundLegId(String outboundLegId) {
	this.outboundLegId = outboundLegId;
}
public String getInboundLegId() {
	return inboundLegId;
}
public void setInboundLegId(String inboundLegId) {
	this.inboundLegId = inboundLegId;
}
public String getCabinclass() {
	return cabinclass;
}
public void setCabinclass(String cabinclass) {
	this.cabinclass = cabinclass;
}
}
