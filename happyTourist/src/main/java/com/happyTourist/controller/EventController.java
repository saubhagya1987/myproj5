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
import com.happyTourist.service.EventService;
import com.happyTourist.utils.HappyTouristResponseUtils;
import com.happyTouristDTO.EventDto;
import com.happyTouristDTO.EventResponseDto;
import com.happyTouristDTO.HappyTouristResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class EventController.
 */
@RestController
public class EventController {
	
	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(EventController.class);
	
	/** The gson. */
	@Autowired
	private Gson gson;
	
	/** The event service. */
	@Autowired
	EventService eventService;
	
	
	/**
	 * Gets the events.
	 *
	 * @param eventDto the event dto
	 * @return the events
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/getEvents", method = RequestMethod.POST)
	public HappyTouristResponse getEvents(@RequestBody EventDto eventDto)throws HappyTouristException { 
		LOGGER.debug("Request data for getEvents -" + gson.toJson(eventDto));	    
		EventResponseDto  eventData=eventService.getEvents(eventDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(eventData);
		LOGGER.debug("Response data for getEvents-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Gets the events by city.
	 *
	 * @param eventDto the event dto
	 * @return the events by city
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/getEventsByCity", method = RequestMethod.POST)
	public HappyTouristResponse getEventsByCity(@RequestBody EventDto eventDto)throws HappyTouristException { 
		LOGGER.debug("Request data for getEventsByCity -" + gson.toJson(eventDto));	    
		EventResponseDto  eventData=eventService.getEventsByCity(eventDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(eventData);
		LOGGER.debug("Response data for getEventsByCity-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }

}
