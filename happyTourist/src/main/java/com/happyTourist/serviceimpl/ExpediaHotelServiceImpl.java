package com.happyTourist.serviceimpl;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import com.happyTourist.config.AsyncTask;
import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.HotelService;
import com.happyTourist.utils.ValueComparator;
import com.happyTouristDTO.Activities;
import com.happyTouristDTO.ActivityDetailsDto;
import com.happyTouristDTO.ExpediaResponseDto;
import com.happyTouristDTO.HotelDto;
import com.happyTouristDTO.HotelList;
import com.happyTouristDTO.HotelResponseDto;
import com.happyTouristDTO.HotelSerchMongoJson;
import com.happyTouristDTO.Images;
import com.happyTouristDTO.TopAttractionResponseDto;
import com.happyTouristPersistence.hotelSearch.dao.HotelSearch;

@Component
public class ExpediaHotelServiceImpl implements HotelService{
	@Autowired
	private MessageSource messageSource;
	@Autowired
	AsyncTask asyncTask;
	@Autowired
	HotelSearch hotelSearch;
	private static final String VALUE="http:";
	private static final String EXPEDIA_API_KEY = "expedia.api.key";
	private static final String EXPEDIA_HOTEL_SEARCH_URL = "expedia.hotel.search.url";
	private static final String EXPEDIA_HOTEL_OFFERS_URL = "expedia.hotel.offers.url";
	private static final String EXPEDIA_HOTEL_INFO_URL = "expedia.hotel.info.url";
	private static final String EXPEDIA_HOTEL_REVIEWS_URL = "expedia.hotel.reviews.url";
	private static final String EXPEDIA_ACTIVITY_SEARCH_URL = "expedia.activity.search.url";
	private static final String EXPEDIA_TOP_ATTRACTION_URL = "expedia.top.attraction.url";
	private static final String EXPEDIA_ACTIVITY_DETAILS_URL = "expedia.activity.details.url";
	/**
	 * Search hotel.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto searchHotel(HotelDto hotelDto)throws HappyTouristException {
		
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		ExpediaResponseDto myObjects=null;
		if(Integer.parseInt(hotelDto.getSkipCount())>0){
			 hotelResponseDto=allHotelSearchData(hotelDto,Integer.parseInt(hotelDto.getLimitCount()),Integer.parseInt(hotelDto.getSkipCount())); 
			 if(hotelResponseDto.getHotelList().size()<25)
			 {
				 hotelResponseDto.setNoMoreHotel(true);
			 }
		}
		else{
		
		List<HotelList> dataList=new  ArrayList<HotelList>();
		URI  targetUrl=null;		
		String url=messageSource.getMessage(EXPEDIA_HOTEL_SEARCH_URL, null, Locale.getDefault());	
		if(hotelDto.getLatitude()!=null && hotelDto.getLongitude()!=null && hotelDto.getResultsPerPage()!=null){
	    targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("city", hotelDto.getCity())	    	    		    	    
	    	    .queryParam("checkInDate", hotelDto.getCheckInDate())
	    	    .queryParam("checkOutDate", hotelDto.getCheckOutDate())
	    	    .queryParam("room1", hotelDto.getRoom1())
	    	    .queryParam("latitude", hotelDto.getLatitude())
	    	    .queryParam("longitude", hotelDto.getLongitude())
	    	    .queryParam("resultsPerPage", hotelDto.getResultsPerPage())
	    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
		}
		
		else if(hotelDto.getLatitude()!=null && hotelDto.getLongitude()!=null){
		    targetUrl= UriComponentsBuilder.fromUriString(url)
		    	    .queryParam("city", hotelDto.getCity())	    	    		    	    
		    	    .queryParam("checkInDate", hotelDto.getCheckInDate())
		    	    .queryParam("checkOutDate", hotelDto.getCheckOutDate())
		    	    .queryParam("room1", hotelDto.getRoom1())
		    	    .queryParam("latitude", hotelDto.getLatitude())
		    	    .queryParam("longitude", hotelDto.getLongitude())
		    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
		    	    .build()
		    	    .toUri();
		}
		else{			
			targetUrl= UriComponentsBuilder.fromUriString(url)
		    	    .queryParam("city", hotelDto.getCity())	    	    		    	    
		    	    .queryParam("checkInDate", hotelDto.getCheckInDate())
		    	    .queryParam("checkOutDate", hotelDto.getCheckOutDate())
		    	    .queryParam("room1", hotelDto.getRoom1())		    	    
		    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
		    	    .build()
		    	    .toUri();
			
		}
		
			    
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
	    //hotelResponseDto.setTotalHotelCount(myObjects.getTotalHotelCount());	    	
	    //hotelResponseDto.setDeepLinkUrl(myObjects.getDeepLinkUrl());
	    //hotelResponseDto.setHotelList(myObjects.getHotelList());
	    dataList=myObjects.getHotelList();
	    for (HotelList hotelList : dataList) {
	    	
	    	hotelList.setDeepLinkUrl(myObjects.getDeepLinkUrl());
	    
		}
	    	
	    asyncTask.doAsyncTask(hotelDto);
	    hotelResponseDto.setHotelList(dataList);
		//return hotelResponseDto;
		}
		return hotelResponseDto;
	}
	
	/**
	 * Hotel offers.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto hotelOffers(HotelDto hotelDto)throws HappyTouristException {
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		ExpediaResponseDto myObjects=null;
		
		String url=messageSource.getMessage(EXPEDIA_HOTEL_OFFERS_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("hotelId", hotelDto.getHotelId())	    	    		    	    
	    	    .queryParam("checkInDate", hotelDto.getCheckInDate())
	    	    .queryParam("checkOutDate", hotelDto.getCheckOutDate())
	    	    .queryParam("room1", hotelDto.getRoom1())
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
	    
	    if(myObjects.getHotelRoomResponse()!=null)	    	
	    hotelResponseDto.setDeepLinkUrl(myObjects.getDeepLinkUrl());
	    hotelResponseDto.setHotelRoomResponse(myObjects.getHotelRoomResponse());		
	    	    
		return hotelResponseDto;
	    
		
	}
	/**
	 * Hotel info.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto hotelInfo(HotelDto hotelDto)throws HappyTouristException {
		
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		ExpediaResponseDto myObjects=null;
		
		String url=messageSource.getMessage(EXPEDIA_HOTEL_INFO_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("hotelId", hotelDto.getHotelId()) 	    	    
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
	    
	    if(myObjects.getPhotos()!=null)	    	
	    hotelResponseDto.setHotelId(myObjects.getHotelId());
	    hotelResponseDto.setHotelName(myObjects.getHotelName());
	    hotelResponseDto.setLocalizedHotelName(myObjects.getLocalizedHotelName());
	    hotelResponseDto.setNonLocalizedHotelName(myObjects.getNonLocalizedHotelName());
	    hotelResponseDto.setHotelAddress(myObjects.getHotelAddress());
	    hotelResponseDto.setHotelCity(myObjects.getHotelCity());
	    hotelResponseDto.setHotelStateProvince(myObjects.getHotelStateProvince());
	    hotelResponseDto.setHotelCountry(myObjects.getHotelCountry());
	    hotelResponseDto.setLatitude(myObjects.getLatitude());
	    hotelResponseDto.setLongitude(myObjects.getLongitude());
	    hotelResponseDto.setLongDescription(myObjects.getLongDescription());   
	    hotelResponseDto.setPhotos(myObjects.getPhotos());	
	    
	    
		return hotelResponseDto;
	    
	}
	/**
	 * Hotel reviews.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto hotelReviews(HotelDto hotelDto)	throws HappyTouristException {
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		ExpediaResponseDto myObjects=null;
		
		String url=messageSource.getMessage(EXPEDIA_HOTEL_REVIEWS_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("hotelId", hotelDto.getHotelId()) 	
	    	    .queryParam("summary", hotelDto.getSummary()) 
	    	    .queryParam("sortBy", hotelDto.getSortBy()) 
	    	    .queryParam("start", hotelDto.getStart()) 
	    	    .queryParam("items", hotelDto.getItems()) 
	    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
	    
	    Map<String,List<HotelList>> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    
	    
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<ExpediaResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    if(myObjects.getReviewDetails()!=null)	    	
	    hotelResponseDto.setReviewDetails(myObjects.getReviewDetails());
	    
	    return hotelResponseDto;
	 }
	/**
	 * Thing to do.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto thingToDo(HotelDto hotelDto)throws HappyTouristException {
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		ExpediaResponseDto myObjects=null;
		List<Activities> activities=new ArrayList<Activities>();
		
		String url=messageSource.getMessage(EXPEDIA_ACTIVITY_SEARCH_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("location", hotelDto.getLocation()) 	    
	    	    .queryParam("startDate", hotelDto.getStartDate()) 
	    	    .queryParam("endDate", hotelDto.getEndDate()) 
	    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
	    
	    Map<String,String> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    //mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<ExpediaResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    Collections.sort(myObjects.getActivities(),(o1, o2) -> -o1.getRecommendationScore().compareTo(o2.getRecommendationScore()));
	    //Collections.sort(myObjects.getActivities(),new ValueComparator());
	    
	    if(myObjects.getActivities()!=null)	 
	    	for (Activities activitiesData : myObjects.getActivities()) {		    		
	    		Activities activitiesInfo=new Activities();
	    		activitiesInfo.setImageUrl(VALUE.concat(activitiesData.getImageUrl()));
	    		activitiesInfo.setLargeImageURL(VALUE.concat(activitiesData.getLargeImageURL()));
	    		String ignoreProperties[] = { "imageUrl","largeImageURL"};
	    		BeanUtils.copyProperties(activitiesData, activitiesInfo,ignoreProperties);
	    		activities.add(activitiesInfo);
			}
	    	
	    //hotelResponseDto.setActivities(myObjects.getActivities());
	    hotelResponseDto.setActivities(activities);
	    
	    return hotelResponseDto;
	}
	/*@Override
	public HotelResponseDto allHotelSearchData(HotelDto hotelDto)throws HappyTouristException {
		HotelResponseDto hotelResponseDto=new HotelResponseDto();	
		List<HotelSerchMongoJson> hotelData=hotelSearch.find(hotelDto);
		if(hotelData.size()>0){			
			for (HotelSerchMongoJson hotelSerchMongoJson : hotelData) {
				hotelResponseDto.setDeepLinkUrl(hotelSerchMongoJson.getHotelResponseDto().getDeepLinkUrl());
				hotelResponseDto.setHotelList(hotelSerchMongoJson.getHotelResponseDto().getHotelList());
			}
			
		}
		return hotelResponseDto;
	}*/
	/**
	 * Top attraction.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto topAttraction(HotelDto hotelDto)throws HappyTouristException {
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		RestTemplate restTemplate = new RestTemplate();		
		String url=messageSource.getMessage(EXPEDIA_TOP_ATTRACTION_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("within", hotelDto.getWithin())
	    	    .queryParam("lng", hotelDto.getLongitude())
	    	    .queryParam("lat", hotelDto.getLatitude())	    	    
	    	    .queryParam("type", hotelDto.getType())
	    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
	    
	    List<TopAttractionResponseDto> list=restTemplate.getForObject(targetUrl, ArrayList.class);
	    hotelResponseDto.setTopAttractionResponseDto(list);
		return hotelResponseDto;
	}
	/**
	 * Activity details.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto activityDetails(HotelDto hotelDto)throws HappyTouristException {
		HotelResponseDto hotelResponseDto=new HotelResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		ExpediaResponseDto myObjects=null;
		List<Images> images=new ArrayList<Images>();
		ActivityDetailsDto activityDetailsDto=new ActivityDetailsDto();
		
		String url=messageSource.getMessage(EXPEDIA_ACTIVITY_DETAILS_URL, null, Locale.getDefault());	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("activityId", hotelDto.getActivityId()) 	    	    
	    	    .queryParam("apikey", messageSource.getMessage(EXPEDIA_API_KEY, null, Locale.getDefault()))
	    	    .build()
	    	    .toUri();
	    
	    Map<String,String> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);	    
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<ExpediaResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    if(myObjects.getImages()!=null)
	    {
	    	for (Images imageObj : myObjects.getImages()) {
	    		Images imageData=new Images();
	    		imageData.setCaption(imageObj.getCaption());
	    		imageData.setCreditString(imageObj.getCreditString());
	    		imageData.setIsImage(imageObj.getIsImage());
	    		imageData.setLarge(VALUE.concat(imageObj.getLarge()));
	    		imageData.setThumbnail(VALUE.concat(imageObj.getThumbnail()));
	    		imageData.setUrl(VALUE.concat(imageObj.getUrl()));
	    		images.add(imageData);
	    	}
	    }
	    String ignoreProperties[] = { "images"};     
	    
	    BeanUtils.copyProperties(myObjects, activityDetailsDto,ignoreProperties);
	    activityDetailsDto.setImages(images);
	    activityDetailsDto.setStaticMapUrl(VALUE.concat(activityDetailsDto.getStaticMapUrl()));
	    hotelResponseDto.setActivityDetailsDto(activityDetailsDto);
		
		return hotelResponseDto;
	}
	/**
	 * All hotel search data.
	 *
	 * @param hotelDto the hotel dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public HotelResponseDto allHotelSearchData(HotelDto hotelDto,int limitCount,int skipCount)throws HappyTouristException {
		//HotelResponseDto hotelResponseDto=new HotelResponseDto();	
		HotelResponseDto hotelData=hotelSearch.find(hotelDto,limitCount,skipCount);
		/*if(hotelData.size()>0){			
			for (HotelResponseDto hotelResponseDto : hotelData) {
				hotelResponseDto.setDeepLinkUrl(hotelResponseDto.getHotelResponseDto());
				hotelResponseDto.setHotelList(hotelResponseDto.getHotelResponseDto());
			}
			
		}*/
		return hotelData;
	}
	
	
	
}
