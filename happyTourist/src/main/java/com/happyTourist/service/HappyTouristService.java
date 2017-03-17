package com.happyTourist.service;

import java.util.List;

import com.happyTourist.exception.HappyTouristException;
import com.happyTouristDTO.HappyTouristDto;
import com.happyTouristDTO.TripRequestDto;

public interface HappyTouristService {
	/**
	 * Gets the group name.
	 *
	 * @param happyTouristDto the happy tourist dto
	 * @return the group name
	 * @throws HappyTouristException the happy tourist exception
	 */
	HappyTouristDto getGroupName(Integer groupId, String groupAdminName) throws HappyTouristException;
	/**
	 * Gets the trip data.
	 *
	 * @param tripAdvisorDto the trip advisor dto
	 * @return the trip data
	 * @throws HappyTouristException the happy tourist exception
	 */
	TripRequestDto getTripData(TripRequestDto tripAdvisorDto)throws HappyTouristException;

}
