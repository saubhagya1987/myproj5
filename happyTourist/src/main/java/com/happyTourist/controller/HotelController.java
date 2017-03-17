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
import com.happyTourist.service.HotelService;
import com.happyTourist.utils.HappyTouristResponseUtils;
import com.happyTouristDTO.FlightDto;
import com.happyTouristDTO.HappyTouristResponse;
import com.happyTouristDTO.HotelDto;
import com.happyTouristDTO.HotelResponseDto;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelController.
 */
@RestController
public class HotelController {
	
	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(HotelController.class);
	
	/** The gson. */
	@Autowired
	private Gson gson;
	
	/** The hotel service. */
	@Autowired
	HotelService hotelService;
	
	/**
	 * Search hotel.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/searchHotel", method = RequestMethod.POST)
	public HappyTouristResponse searchHotel(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for searchHotel -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.searchHotel(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for searchHotel-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Hotel offers.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/hotelOffers", method = RequestMethod.POST)
	public HappyTouristResponse hotelOffers(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for hotelOffers -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.hotelOffers(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for hotelOffers-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Hotel info.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/hotelInfo", method = RequestMethod.POST)
	public HappyTouristResponse hotelInfo(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for hotelInfo -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.hotelInfo(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for hotelInfo-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Hotel reviews.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/hotelReviews", method = RequestMethod.POST)
	public HappyTouristResponse hotelReviews(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for hotelReviews -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.hotelReviews(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for hotelReviews-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Thing to do.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/thingToDo", method = RequestMethod.POST)
	public HappyTouristResponse thingToDo(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for thingToDo -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.thingToDo(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for thingToDo-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	/*@RequestMapping(value = "/allHotelSearchData", method = RequestMethod.POST)
	public HappyTouristResponse allHotelSearchData(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for allHotelSearchData -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.allHotelSearchData(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for allHotelSearchData-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }*/
	
	/**
	 * Top attraction.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/topAttraction", method = RequestMethod.POST)
	public HappyTouristResponse topAttraction(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for topAttraction -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.topAttraction(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for topAttraction-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Activity details.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/activityDetails", method = RequestMethod.POST)
	public HappyTouristResponse activityDetails(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for activityDetails -" + gson.toJson(hotelDto));	    
		HotelResponseDto  hotelData=hotelService.activityDetails(hotelDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for activityDetails-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * All hotel search data.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/allHotelSearchData", method = RequestMethod.POST)
	public HappyTouristResponse allHotelSearchData(@RequestBody HotelDto hotelDto)throws HappyTouristException { 
		LOGGER.debug("Request data for allHotelSearchData -" + gson.toJson(hotelDto));		
		HotelResponseDto  hotelData=hotelService.allHotelSearchData(hotelDto,Integer.parseInt(hotelDto.getLimitCount()),Integer.parseInt(hotelDto.getSkipCount()));			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(hotelData);
		LOGGER.debug("Response data for allHotelSearchData-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	
}
