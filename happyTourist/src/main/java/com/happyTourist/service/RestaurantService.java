package com.happyTourist.service;

import com.happyTourist.exception.HappyTouristException;
import com.happyTouristDTO.RestaurantDto;
import com.happyTouristDTO.RestaurantResponseDto;

public interface RestaurantService {
	/**
	 * Search places.
	 *
	 * @param restaurantDto the restaurant dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	RestaurantResponseDto searchRestaurant(RestaurantDto restaurantDto)throws HappyTouristException;
	/**
	 * Gets the place detail.
	 *
	 * @param restaurantDto the restaurant dto
	 * @return the place detail
	 * @throws HappyTouristException the happy tourist exception
	 */
	RestaurantResponseDto searchPlace(RestaurantDto restaurantDto)throws HappyTouristException;

}
