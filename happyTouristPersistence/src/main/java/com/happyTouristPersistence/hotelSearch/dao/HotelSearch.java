package com.happyTouristPersistence.hotelSearch.dao;

import java.util.List;

import com.happyTouristDTO.HotelDto;
import com.happyTouristDTO.HotelList;
import com.happyTouristDTO.HotelResponseDto;
import com.happyTouristDTO.HotelSerchMongoJson;

public interface HotelSearch {
	//public void save(HotelSerchMongoJson hotelSerchMongoJson);
	//public List<HotelSerchMongoJson> find(HotelDto hotelDto);
	//public List<HotelSerchMongoJson> findExistingData(HotelDto hotelDto);
	/**
	 * Saving  hotel data.
	 *
	 */
	
	public void save(HotelResponseDto hotelResponseDto, HotelDto hotelDto);
	/**
	 * All hotel search data.
	 *
	 * @param hotelDto the hotel dto
	 * 
	 * 
	 */
	public HotelResponseDto findExistingData(HotelDto hotelDto);
	/**
	 * All hotel search data.
	 *
	 * @param hotelDto the hotel dto
	 * 
	 * 
	 */
	public HotelResponseDto find(HotelDto hotelDto,int limitCount,int skipCount);
}
