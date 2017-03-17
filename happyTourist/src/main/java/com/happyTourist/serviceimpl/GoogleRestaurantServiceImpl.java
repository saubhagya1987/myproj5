package com.happyTourist.serviceimpl;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
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
import com.happyTourist.service.RestaurantService;
import com.happyTouristDTO.EventResponseDto;
import com.happyTouristDTO.FacebookResponseDto;
import com.happyTouristDTO.GoogleResponseDto;
import com.happyTouristDTO.Photo;
import com.happyTouristDTO.RestaurantDto;
import com.happyTouristDTO.RestaurantResponseDto;
import com.happyTouristDTO.Result;
@Component
public class GoogleRestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private MessageSource messageSource;
	
	private static final String GOOGLE_API_KEY = "google.api.key";
	private static final String GOOGLE_RESTAURANT_URL = "google.restaurant.url";
	private static final String GOOGLE_PLACE_URL ="google.place.url";
	private static final String PHOTO_REFERENCE_URL ="photo.reference.url";
	private static final String PHOTO_REFERENCE_APPEND_URL="photo.reference.append.url";
	private static final String EXEMPT_TYPE_LIST="exempt.type.list";
	
	
	/**
	 * Search places.
	 *
	 * @param restaurantDto the restaurant dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public RestaurantResponseDto searchRestaurant(RestaurantDto restaurantDto)throws HappyTouristException {
		
		RestaurantResponseDto restaurantResponseDto=new RestaurantResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		GoogleResponseDto myObjects=null;
		
		
		String url=messageSource.getMessage(GOOGLE_RESTAURANT_URL, null, Locale.getDefault());	
		URI  targetUrl=null;
		if(restaurantDto.getPagetoken()==null){
	      targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("location", restaurantDto.getLocation())	    	    		    	    
	    	    .queryParam("radius", restaurantDto.getRadius())
	    	    .queryParam("types", restaurantDto.getTypes())
	    	    .queryParam("key", messageSource.getMessage(GOOGLE_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
		}
		else{
			  targetUrl= UriComponentsBuilder.fromUriString(url)
		    	    .queryParam("location", restaurantDto.getLocation())	    	    		    	    
		    	    .queryParam("radius", restaurantDto.getRadius())
		    	    .queryParam("types", restaurantDto.getTypes())
		    	    .queryParam("key", messageSource.getMessage(GOOGLE_API_KEY, null, Locale.getDefault()))
		    	    .queryParam("pagetoken", restaurantDto.getPagetoken())
		    	    .build()
		    	    .toUri();
			
		}
	    Map<String,String> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<GoogleResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
	    if(myObjects!=null)
	    {	    	
	    	restaurantResponseDto.setHtml_attributions(myObjects.getHtml_attributions());
	    	restaurantResponseDto.setNext_page_token(myObjects.getNext_page_token());
	    	restaurantResponseDto.setResults(myObjects.getResults());
	    	
	    	List<Result> resultList=myObjects.getResults();	 
	    	if(!restaurantDto.getTypes().equalsIgnoreCase( messageSource.getMessage(EXEMPT_TYPE_LIST, null, Locale.getDefault()))){
	    	   Collections.sort(resultList,(o1, o2) -> -String.valueOf(o1.getRating()).compareTo(String.valueOf(o2.getRating())));
	    	}
	    	
			
			

	    	for (Result result : resultList) {
	    		
	    		List<Photo> photoList=result.getPhotos();
	    		if(photoList!=null)
	    		for (Photo photo : photoList) {
	    			//photo.setPhoto_reference("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+photo.getPhoto_reference()+"&sensor=false&key=AIzaSyAS2OIiR1DFzDb8oig4AWArtN1GEv5JDVw");
	    			
	    			photo.setPhoto_reference(messageSource.getMessage(PHOTO_REFERENCE_URL, null, Locale.getDefault()).concat(photo.getPhoto_reference()).concat(messageSource.getMessage(PHOTO_REFERENCE_APPEND_URL, null, Locale.getDefault())));
				}
			}
	    	
	    	restaurantResponseDto.setStatus(myObjects.getStatus());
	    }
	    
	    return restaurantResponseDto;		
		
		
		
	}
	/**
	 * Gets the place detail.
	 *
	 * @param restaurantDto the restaurant dto
	 * @return the place detail
	 * @throws HappyTouristException the happy tourist exception
	 */

	@Override
	public RestaurantResponseDto searchPlace(RestaurantDto restaurantDto)throws HappyTouristException {
		RestaurantResponseDto restaurantResponseDto=new RestaurantResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		GoogleResponseDto myObjects=null;
		
		String url=messageSource.getMessage(GOOGLE_PLACE_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("placeid", restaurantDto.getPlaceid())	    	    		    	    
	    	    
	    	    .queryParam("key", messageSource.getMessage(GOOGLE_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
	    Map<String,String> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<GoogleResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    if(myObjects!=null)
	    {
	    	restaurantResponseDto.setHtml_attributions(myObjects.getHtml_attributions());
	    	restaurantResponseDto.setNext_page_token(myObjects.getNext_page_token());
	    	restaurantResponseDto.setResults(myObjects.getResults());
	    	restaurantResponseDto.setResult(myObjects.getResult());
	    	
           Result resultObj=myObjects.getResult();           
	    	if(resultObj!=null){
	    		List<Photo> photoList=resultObj.getPhotos();
	    		if(photoList!=null)
	    		for (Photo photo : photoList) {
	    			//photo.setPhoto_reference("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+photo.getPhoto_reference()+"&sensor=false&key=AIzaSyAS2OIiR1DFzDb8oig4AWArtN1GEv5JDVw");
	    			
	    			photo.setPhoto_reference(messageSource.getMessage(PHOTO_REFERENCE_URL, null, Locale.getDefault()).concat(photo.getPhoto_reference()).concat(messageSource.getMessage(PHOTO_REFERENCE_APPEND_URL, null, Locale.getDefault())));
				}
	    	}
			
	    	
	    	
	    	
	    	restaurantResponseDto.setStatus(myObjects.getStatus());
	    } 
	    
	    
		return restaurantResponseDto;
	}

}
