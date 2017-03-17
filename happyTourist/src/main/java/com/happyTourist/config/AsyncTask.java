package com.happyTourist.config;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import com.happyTouristDTO.ExpediaResponseDto;
import com.happyTouristDTO.HotelDto;
import com.happyTouristDTO.HotelList;
import com.happyTouristDTO.HotelResponseDto;
import com.happyTouristDTO.HotelSerchMongoJson;
import com.happyTouristPersistence.hotelSearch.dao.HotelSearch;

public class AsyncTask {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	HotelSearch hotelSearch;
	
	private static final String EXPEDIA_HOTEL_SEARCH_URL = "expedia.hotel.search.url";
	private static final String EXPEDIA_API_KEY = "expedia.api.key";
	@Async
	public void doAsyncTask(HotelDto hotelDto){
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		HotelSerchMongoJson hotelSerchMongoJson=new HotelSerchMongoJson();
		RestTemplate restTemplate = new RestTemplate();
		ExpediaResponseDto myObjects=null;
		String url=messageSource.getMessage(EXPEDIA_HOTEL_SEARCH_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("city", hotelDto.getCity())	    	    		    	    
	    	    .queryParam("checkInDate", hotelDto.getCheckInDate())
	    	    .queryParam("checkOutDate", hotelDto.getCheckOutDate())
	    	    .queryParam("room1", hotelDto.getRoom1())
	    	    .queryParam("resultsPerPage", "-1")
	    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
	    
	    Map<String,List<HotelList>> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<ExpediaResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    if(myObjects.getHotelList()!=null)	    	
	    hotelResponseDto.setDeepLinkUrl(myObjects.getDeepLinkUrl());
	    hotelResponseDto.setHotelList(myObjects.getHotelList());
	    hotelDto.setCity(hotelDto.getCity());
	    /*hotelSerchMongoJson.setHotelResponseDto(hotelResponseDto);
	    hotelSerchMongoJson.setHotelRequestDto(hotelDto);
	    List<HotelSerchMongoJson> hotelData=hotelSearch.findExistingData(hotelDto);
	    if(hotelData.size()<1){
	    	hotelSearch.save(hotelSerchMongoJson);
	    }  */ 
	    	    
	    HotelResponseDto hotelData=hotelSearch.findExistingData(hotelDto);
	    if(hotelData==null)
	    {
	       hotelSearch.save(hotelResponseDto,hotelDto);
	    }
		System.out.println("do some async task");
	}
}