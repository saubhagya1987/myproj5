package com.happyTourist.service;

import com.happyTourist.exception.HappyTouristException;
import com.happyTouristDTO.HotelDto;
import com.happyTouristDTO.HotelResponseDto;
import com.happyTouristDTO.ResponseDto;

public interface HotelService {
	/**
	 * Search hotel.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto searchHotel(HotelDto hotelDto)throws HappyTouristException;
	/**
	 * Hotel offers.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto hotelOffers(HotelDto hotelDto)throws HappyTouristException;
	/**
	 * Hotel info.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto hotelInfo(HotelDto hotelDto)throws HappyTouristException;
	/**
	 * Hotel reviews.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto hotelReviews(HotelDto hotelDto)throws HappyTouristException;
	/**
	 * Thing to do.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto thingToDo(HotelDto hotelDto)throws HappyTouristException;
	/**
	 * All hotel search data.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto allHotelSearchData(HotelDto hotelDto,int limitCount,int skipCount)throws HappyTouristException;
	/**
	 * Top attraction.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto topAttraction(HotelDto hotelDto)throws HappyTouristException;
	/**
	 * Activity details.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	HotelResponseDto activityDetails(HotelDto hotelDto)throws HappyTouristException;

}
