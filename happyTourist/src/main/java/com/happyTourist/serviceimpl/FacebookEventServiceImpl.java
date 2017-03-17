package com.happyTourist.serviceimpl;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.EventService;
import com.happyTouristDTO.BookingItems;
import com.happyTouristDTO.Datum;
import com.happyTouristDTO.Datum2;
import com.happyTouristDTO.EventDto;
import com.happyTouristDTO.EventResponseDto;
import com.happyTouristDTO.ExpediaResponseDto;
import com.happyTouristDTO.FacebookResponseDto;
import com.happyTouristDTO.HotelList;
import com.happyTouristDTO.HotelResponseDto;
@Component
public class FacebookEventServiceImpl implements EventService{
	@Autowired
	private MessageSource messageSource;
	private static final String FACEBOOK_ACCESS_TOKEN = "facebook.access.token";
	private static final String FACEBOOK_EVENTS_URL = "facebook.events.url";
	private static final String SEATGEEK_EVENTS_URL = "seatgeek.events.url";
	/**
	 * Gets the events.
	 *
	 * @param eventDto the event dto
	 * @return the events
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public EventResponseDto getEvents(EventDto eventDto)throws HappyTouristException {
		
		EventResponseDto eventResponseDto=new EventResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		FacebookResponseDto myObjects=null;
		
		String url=messageSource.getMessage(FACEBOOK_EVENTS_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("fields", eventDto.getFields())	    	    		    	    
	    	    .queryParam("type", eventDto.getType())
	    	    .queryParam("q", eventDto.getQ())
	    	    .queryParam("center", eventDto.getCenter())
	    	    .queryParam("distance", eventDto.getDistance())	    	    
	    	    .queryParam("access_token", messageSource.getMessage(FACEBOOK_ACCESS_TOKEN, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
	    Map<String,String> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<FacebookResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}	       
	   
	    /*List<Datum> data=myObjects.getData();
	    boolean eventNotExist=true;
	    
	    for (Datum datum : data) {
	    	if(datum.getEvents()!=null){
	    		eventNotExist=false;
	    		break;
	    	}
		  		
		   
	    }
	    if(eventNotExist){
	    	EventResponseDto  eventData=getEventsByCity(eventDto);
		}*/
	    
		if(myObjects!=null)	
		{
			eventResponseDto.setData(myObjects.getData());
			eventResponseDto.setPaging(myObjects.getPaging());
		}
	   
	    return eventResponseDto;
		    
		
		
		
		
	}

	/**
	 * Gets the events by city.
	 *
	 * @param eventDto the event dto
	 * @return the events by city
	 * @throws HappyTouristException the happy tourist exception
	 */

	@Override
	public EventResponseDto getEventsByCity(EventDto eventDto)throws HappyTouristException {
		EventResponseDto eventResponseDto=new EventResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		FacebookResponseDto myObjects=null;
		StringBuilder sb=new StringBuilder("venue.");
		String city=sb.append(eventDto.getCity()).toString();
		String url=messageSource.getMessage(SEATGEEK_EVENTS_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("city", eventDto.getCity())	   	    
	    	    .build()
	    	    .toUri();
	    Map<String,String> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<FacebookResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
