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
import com.happyTourist.service.RestaurantService;
import com.happyTourist.utils.HappyTouristResponseUtils;
import com.happyTouristDTO.HappyTouristResponse;
import com.happyTouristDTO.RestaurantDto;
import com.happyTouristDTO.RestaurantResponseDto;
// TODO: Auto-generated Javadoc

/**
 * The Class RestaurantController.
 */
@RestController
public class RestaurantController {
	
	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(RestaurantController.class);
	
	/** The gson. */
	@Autowired
	private Gson gson;
	
	/** The restaurant service. */
	@Autowired
	RestaurantService restaurantService;
	
	/**
	 * Search places.
	 *
	 * @param restaurantDto the restaurant dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/searchPlaces", method = RequestMethod.POST)
	public HappyTouristResponse searchPlaces(@RequestBody RestaurantDto restaurantDto)throws HappyTouristException { 
		LOGGER.debug("Request data for searchPlaces -" + gson.toJson(restaurantDto));	    
		RestaurantResponseDto  restaurantData=restaurantService.searchRestaurant(restaurantDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(restaurantData);
		LOGGER.debug("Response data for searchPlaces-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Gets the place detail.
	 *
	 * @param restaurantDto the restaurant dto
	 * @return the place detail
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/getPlaceDetail", method = RequestMethod.POST)
	public HappyTouristResponse getPlaceDetail(@RequestBody RestaurantDto restaurantDto)throws HappyTouristException { 
		LOGGER.debug("Request data for getPlaceDetail -" + gson.toJson(restaurantDto));	    
		RestaurantResponseDto  restaurantData=restaurantService.searchPlace(restaurantDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(restaurantData);
		LOGGER.debug("Response data for getPlaceDetail-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }

}
