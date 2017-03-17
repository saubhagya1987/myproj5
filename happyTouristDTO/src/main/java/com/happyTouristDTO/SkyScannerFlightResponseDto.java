package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SkyScannerFlightResponseDto {
	
	private String Code;
	private String Symbol;
	private String ThousandsSeparator;
	private String DecimalSeparator;
	private boolean SymbolOnLeft;
	private boolean SpaceBetweenAmountAndSymbol;
	private Integer RoundingCoefficient;
	private Integer DecimalDigits;
	
	//for hotel auto suggest
	private Integer place_id;
	private String country_name;
	private String display_name;
	private String geo_type;
	
	
	private String Body;
	private String Method;
	private String Uri;
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

	
	
	public Integer getPlace_id() {
		return place_id;
	}
	public void setPlace_id(Integer place_id) {
		this.place_id = place_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getGeo_type() {
		return geo_type;
	}
	public void setGeo_type(String geo_type) {
		this.geo_type = geo_type;
	}
	
	
	//Original
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}
	public String getThousandsSeparator() {
		return ThousandsSeparator;
	}
	public void setThousandsSeparator(String thousandsSeparator) {
		ThousandsSeparator = thousandsSeparator;
	}
	public String getDecimalSeparator() {
		return DecimalSeparator;
	}
	public void setDecimalSeparator(String decimalSeparator) {
		DecimalSeparator = decimalSeparator;
	}
	public boolean isSymbolOnLeft() {
		return SymbolOnLeft;
	}
	public void setSymbolOnLeft(boolean symbolOnLeft) {
		SymbolOnLeft = symbolOnLeft;
	}
	public boolean isSpaceBetweenAmountAndSymbol() {
		return SpaceBetweenAmountAndSymbol;
	}
	public void setSpaceBetweenAmountAndSymbol(boolean spaceBetweenAmountAndSymbol) {
		SpaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
	}
	public Integer getRoundingCoefficient() {
		return RoundingCoefficient;
	}
	public void setRoundingCoefficient(Integer roundingCoefficient) {
		RoundingCoefficient = roundingCoefficient;
	}
	public Integer getDecimalDigits() {
		return DecimalDigits;
	}
	public void setDecimalDigits(Integer decimalDigits) {
		DecimalDigits = decimalDigits;
	}
	
	
		
}
