package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightResponseDto {
	
	private String currencieCode;
	private String currencieSymbol;
	
	//for testing
	
	private Integer placeId;
	private String countryName;
	private String displayName;
	private String geoType;
	
	//testing
	
	private String Body;
	private String Method;
	private String Uri;
	
	private String InboundLegId;
	private String OutboundLegId;
	private List<PricingOptions> PricingOptions;
	

	
	private String AgentID;
	private String Status;
	private String Price;
	private String Deeplink;
	
	
	public String getAgentID() {
		return AgentID;
	}
	public void setAgentID(String agentID) {
		AgentID = agentID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getDeeplink() {
		return Deeplink;
	}
	public void setDeeplink(String deeplink) {
		Deeplink = deeplink;
	}
	public String getInboundLegId() {
		return InboundLegId;
	}
	public void setInboundLegId(String inboundLegId) {
		InboundLegId = inboundLegId;
	}
	public String getOutboundLegId() {
		return OutboundLegId;
	}
	public void setOutboundLegId(String outboundLegId) {
		OutboundLegId = outboundLegId;
	}
	public List<PricingOptions> getPricingOptions() {
		return PricingOptions;
	}
	public void setPricingOptions(List<PricingOptions> pricingOptions) {
		PricingOptions = pricingOptions;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getUri() {
		return Uri;
	}
	public void setUri(String uri) {
		Uri = uri;
	}

	//testing
	
	public Integer getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getGeoType() {
		return geoType;
	}
	public void setGeoType(String geoType) {
		this.geoType = geoType;
	}
	
	
	//testing
	
	
	public String getCurrencieCode() {
		return currencieCode;
	}
	public void setCurrencieCode(String currencieCode) {
		this.currencieCode = currencieCode;
	}
	public String getCurrencieSymbol() {
		return currencieSymbol;
	}
	public void setCurrencieSymbol(String currencieSymbol) {
		this.currencieSymbol = currencieSymbol;
	}
	
}
