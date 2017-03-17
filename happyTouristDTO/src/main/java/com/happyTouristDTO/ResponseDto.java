package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

	private Integer responseCode;
	private String responseDescription;
	//private ResponseResult result;
	private Integer resultCode;


	private List<FlightResponseDto> currencies;
	
    private List<FlightResponseDto> places;
	
	private List<FlightResponseDto> results;
	
	private List<FlightResponseDto> flightBookingResponse;
	
	//private FlightResponseDto flightResponse;
	
	public List<FlightResponseDto> getPollResponse() {
		return pollResponse;
	}

	public void setPollResponse(List<FlightResponseDto> pollResponse) {
		this.pollResponse = pollResponse;
	}

	private List<FlightResponseDto> pollResponse;

	public List<FlightResponseDto> getFlightBookingResponse() {
		return flightBookingResponse;
	}

	public void setFlightBookingResponse(
			List<FlightResponseDto> flightBookingResponse) {
		this.flightBookingResponse = flightBookingResponse;
	}

	public List<FlightResponseDto> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<FlightResponseDto> currencies) {
		this.currencies = currencies;
	}

	public List<FlightResponseDto> getPlaces() {
		return places;
	}

	public void setPlaces(List<FlightResponseDto> places) {
		this.places = places;
	}

	public List<FlightResponseDto> getResults() {
		return results;
	}

	public void setResults(List<FlightResponseDto> results) {
		this.results = results;
	}

	

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	/*public ResponseResult getResult() {
		return result;
	}

	public void setResult(ResponseResult result) {
		this.result = result;
	}*/

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	/*public FlightResponseDto getFlightResponse() {
		return flightResponse;
	}

	public void setFlightResponse(FlightResponseDto flightResponse) {
		this.flightResponse = flightResponse;
	}*/

}
