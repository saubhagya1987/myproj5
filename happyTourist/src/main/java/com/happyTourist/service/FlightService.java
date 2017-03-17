package com.happyTourist.service;

import com.happyTourist.exception.HappyTouristException;
import com.happyTouristDTO.FlightDto;
import com.happyTouristDTO.FlightResponseDto;
import com.happyTouristDTO.ResponseDto;

public interface FlightService {
	/**
	 * Gets the flight data.
	 *
	 * @param flightDto the flight dto
	 * @return the flight data
	 * @throws HappyTouristException the happy tourist exception
	 */
	ResponseDto getFlightData(FlightDto flightDto)throws HappyTouristException;

	/**
	 * Gets the hotel data.
	 *
	 * @param flightDto the flight dto
	 * @return the hotel data
	 * @throws HappyTouristException the happy tourist exception
	 */
	ResponseDto getHotelData(FlightDto flightDto)throws HappyTouristException;
	/**
	 * Creates the session.
	 *
	 * @param flightDto the flight dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */

	ResponseDto createSession(FlightDto flightDto)throws HappyTouristException;
	/**
	 * Creates the booking details.
	 *
	 * @param flightDto the flight dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	ResponseDto createBookingDetails(FlightDto flightDto)throws HappyTouristException;

}
