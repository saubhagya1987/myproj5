package com.happyTourist.service;

import com.happyTourist.exception.HappyTouristException;
import com.happyTouristDTO.EventDto;
import com.happyTouristDTO.EventResponseDto;
import com.happyTouristDTO.HotelResponseDto;

public interface EventService {
	/**
	 * Gets the events.
	 *
	 * @param eventDto the event dto
	 * @return the events
	 * @throws HappyTouristException the happy tourist exception
	 */
	EventResponseDto getEvents(EventDto eventDto) throws HappyTouristException;
	
	/**
	 * Gets the events by city.
	 *
	 * @param eventDto the event dto
	 * @return the events by city
	 * @throws HappyTouristException the happy tourist exception
	 */

	EventResponseDto getEventsByCity(EventDto eventDto)throws HappyTouristException;

}
