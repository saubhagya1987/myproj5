package com.happyTouristDTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SkyScannerResponseDto {

	private List<SkyScannerFlightResponseDto> Currencies;
	
	private List<SkyScannerFlightResponseDto> places;
	
	private List<SkyScannerFlightResponseDto> results;
	
	private List<FlightItinerary> Itineraries;
	
	private List<BookingOptions> BookingOptions;	
	

	

	public List<BookingOptions> getBookingOptions() {
		return BookingOptions;
	}

	public void setBookingOptions(List<BookingOptions> bookingOptions) {
		BookingOptions = bookingOptions;
	}

	public List<FlightItinerary> getItineraries() {
		return Itineraries;
	}

	public void setItineraries(List<FlightItinerary> itineraries) {
		Itineraries = itineraries;
	}

	public List<SkyScannerFlightResponseDto> getCurrencies() {
		return Currencies;
	}

	public void setCurrencies(List<SkyScannerFlightResponseDto> currencies) {
		Currencies = currencies;
	}

	public List<SkyScannerFlightResponseDto> getPlaces() {
		return places;
	}

	public void setPlaces(List<SkyScannerFlightResponseDto> places) {
		this.places = places;
	}

	public List<SkyScannerFlightResponseDto> getResults() {
		return results;
	}

	public void setResults(List<SkyScannerFlightResponseDto> results) {
		this.results = results;
	}
	
	
	
}
