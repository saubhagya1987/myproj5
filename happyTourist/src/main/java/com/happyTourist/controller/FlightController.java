package com.happyTourist.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.FlightService;
import com.happyTourist.utils.HappyTouristResponseUtils;
import com.happyTouristDTO.FlightDto;
import com.happyTouristDTO.FlightResponseDto;
import com.happyTouristDTO.HappyTouristResponse;
import com.happyTouristDTO.ResponseDto;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightController.
 */
@RestController
public class FlightController {
	
	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(FlightController.class);
	
	/** The gson. */
	@Autowired
	private Gson gson;
	
	/** The flight service. */
	@Autowired
	FlightService flightService;
	
	/**
	 * Gets the flight data.
	 *
	 * @param flightDto the flight dto
	 * @return the flight data
	 * @throws HappyTouristException the happy tourist exception
	 */
	//for demo data(testing purpose)
	@RequestMapping(value = "/getFlightData", method = RequestMethod.POST)
	public HappyTouristResponse getFlightData(@RequestBody FlightDto flightDto)throws HappyTouristException { 
		LOGGER.debug("Request data for getFlightData  -" + gson.toJson(flightDto));	    
		ResponseDto  flightData=flightService.getFlightData(flightDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(flightData);
		LOGGER.debug("Response data for getFlightData-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Gets the hotel data.
	 *
	 * @param flightDto the flight dto
	 * @return the hotel data
	 * @throws HappyTouristException the happy tourist exception
	 */
	//for demo data(testing purpose)
	@RequestMapping(value = "/getHotelData", method = RequestMethod.POST)
	public HappyTouristResponse getHotelData(@RequestBody FlightDto flightDto)throws HappyTouristException { 
		LOGGER.debug("Request data for getHotelData  -" + gson.toJson(flightDto));	    
		ResponseDto  flightData=flightService.getHotelData(flightDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(flightData);
		LOGGER.debug("Response data for getHotelData-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Creates the session.
	 *
	 * @param flightDto the flight dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/createSession", method = RequestMethod.POST)
	public HappyTouristResponse createSession(@RequestBody FlightDto flightDto)throws HappyTouristException { 
		LOGGER.debug("Request data for createSession  -" + gson.toJson(flightDto));	    
		ResponseDto  flightData=flightService.createSession(flightDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(flightData);
		LOGGER.debug("Response data for createSession-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Creates the booking details.
	 *
	 * @param flightDto the flight dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/createBookingDetails", method = RequestMethod.POST)
	public HappyTouristResponse createBookingDetails(@RequestBody FlightDto flightDto)throws HappyTouristException { 
		LOGGER.debug("Request data for createBookingDetails  -" + gson.toJson(flightDto));	    
		ResponseDto  flightData=flightService.createBookingDetails(flightDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(flightData);
		LOGGER.debug("Response data for createBookingDetails-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	

}
