package com.happyTourist.serviceimpl;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.FlightService;
import com.happyTourist.utils.DateUtils;
import com.happyTouristDTO.BookingItems;
import com.happyTouristDTO.BookingOptions;
import com.happyTouristDTO.FlightDto;
import com.happyTouristDTO.FlightItinerary;
import com.happyTouristDTO.FlightResponseDto;
import com.happyTouristDTO.ResponseDto;
import com.happyTouristDTO.SkyScannerFlightResponseDto;
import com.happyTouristDTO.SkyScannerResponseDto;
// TODO: Auto-generated Javadoc

/**
 * The Class SkyScanFlightServiceImpl.
 */
@Component
//@Profile("SkyScanner")
public class SkyScanFlightServiceImpl implements FlightService {
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The Constant SKYSCANNER_API_KEY. */
	private static final String SKYSCANNER_API_KEY = "skyscanner.api.key";
	
	/** The Constant SKYSCANNER_PRICE_URL. */
	private static final String SKYSCANNER_PRICE_URL = "skyscanner.price.url";
	
	/** The Constant SKYSCANNER_BASE_URL. */
	private static final String SKYSCANNER_BASE_URL ="skyscanner.base.url";
	
	/*@Override
	public ResponseDto getFlightData(FlightDto flightDto)throws HappyTouristException {
		
	    ResponseDto responseDto=new ResponseDto();
	    RestTemplate restTemplate = new RestTemplate();	
	    FlightResponseDto flightResponseDto=null;
	    List<SkyScannerFlightResponseDto> currencies=null;
	    List<SkyScannerFlightResponseDto> myObjects = null;
	    
	    List<FlightResponseDto> currenciesList=new ArrayList<FlightResponseDto>();
	    
		flightDto.setApiKey("ir908041111719991942734146257682");
		String url="http://partners.api.skyscanner.net/apiservices/reference/v1.0/currencies";	
		
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("apiKey", flightDto.getApiKey())	    	    
	    	    .build()
	    	    .toUri();
	    Map<String,List<SkyScannerFlightResponseDto>> map=restTemplate.getForObject(targetUrl, Map.class);
	    
	    for (Map.Entry<String, List<SkyScannerFlightResponseDto>> entry : map.entrySet()) {
	    	 String key = entry.getKey();
	    	 currencies=new ArrayList<SkyScannerFlightResponseDto>();
	    	 currencies.addAll(entry.getValue());	
	    }
	    
	    //String jsonString = new Gson().toJson(map, Map.class);
	    String jsonString = new Gson().toJson(currencies);
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<List<SkyScannerFlightResponseDto>>(){});
	    	// myObjects = mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, SkyScannerFlightResponseDto.class));
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    for (SkyScannerFlightResponseDto skyScannerFlightResponseDto : myObjects) {
    		flightResponseDto=new FlightResponseDto();
	    	flightResponseDto.setCurrencieCode(skyScannerFlightResponseDto.getCode());
	    	flightResponseDto.setCurrencieSymbol(skyScannerFlightResponseDto.getSymbol());
	    	currenciesList.add(flightResponseDto);
		}
	    responseDto.setCurrencies(currenciesList);
		return responseDto;
		
	}*/
	
	
	/**
	 * Gets the flight data.
	 *
	 * @param flightDto the flight dto
	 * @return the flight data
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public ResponseDto getFlightData(FlightDto flightDto)throws HappyTouristException {
		
	    ResponseDto responseDto=new ResponseDto();
	    RestTemplate restTemplate = new RestTemplate();	
	    FlightResponseDto flightResponseDto=null;
	    List<SkyScannerFlightResponseDto> currencies=null;
	    //List<SkyScannerFlightResponseDto> myObjects = null;
	    
	    SkyScannerResponseDto myObjects = null;
	    
	    List<FlightResponseDto> currenciesList=new ArrayList<FlightResponseDto>();
	    
		flightDto.setApiKey(messageSource.getMessage(SKYSCANNER_API_KEY, null, Locale.getDefault()));
		String url="http://partners.api.skyscanner.net/apiservices/reference/v1.0/currencies";	
		
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("apiKey", flightDto.getApiKey())	    	    
	    	    .build()
	    	    .toUri();
	    Map<String,List<SkyScannerFlightResponseDto>> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();
	    //mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<SkyScannerResponseDto>(){});
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    for (SkyScannerFlightResponseDto skyScannerFlightResponseDto : myObjects.getCurrencies()) {
    		flightResponseDto=new FlightResponseDto();
	    	flightResponseDto.setCurrencieCode(skyScannerFlightResponseDto.getCode());
	    	flightResponseDto.setCurrencieSymbol(skyScannerFlightResponseDto.getSymbol());
	    	currenciesList.add(flightResponseDto);
		}
	    responseDto.setCurrencies(currenciesList);
		return responseDto;
		
	}
	

	/**
	 * Gets the hotel data.
	 *
	 * @param flightDto the flight dto
	 * @return the hotel data
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public ResponseDto getHotelData(FlightDto flightDto)throws HappyTouristException {
		
	    ResponseDto responseDto=new ResponseDto();
	    RestTemplate restTemplate = new RestTemplate();	
	    FlightResponseDto flightResponseDto=null;
	    List<SkyScannerFlightResponseDto> currencies=null;
	    //List<SkyScannerFlightResponseDto> myObjects = null;
	    
	    SkyScannerResponseDto myObjects = null;
	    
	    List<FlightResponseDto> currenciesList=new ArrayList<FlightResponseDto>();
	    List<FlightResponseDto> placesList=new ArrayList<FlightResponseDto>();
	    List<FlightResponseDto> resultsList=new ArrayList<FlightResponseDto>();
	    
	    
		flightDto.setApiKey(messageSource.getMessage(SKYSCANNER_API_KEY, null, Locale.getDefault()));
		String url="http://partners.api.skyscanner.net/apiservices/hotels/autosuggest/v2/UK/EUR/en-GB/pari";	
		
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("apiKey", flightDto.getApiKey())	    	    
	    	    .build()
	    	    .toUri();
	    Map<String,List<SkyScannerFlightResponseDto>> map=restTemplate.getForObject(targetUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();
	    //mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<SkyScannerResponseDto>(){});
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    if(myObjects.getCurrencies()!=null)
	    for (SkyScannerFlightResponseDto skyScannerFlightResponseDto : myObjects.getCurrencies()) {
    		flightResponseDto=new FlightResponseDto();
	    	flightResponseDto.setCurrencieCode(skyScannerFlightResponseDto.getCode());
	    	flightResponseDto.setCurrencieSymbol(skyScannerFlightResponseDto.getSymbol());
	    	currenciesList.add(flightResponseDto);
		}
	    if(myObjects.getPlaces()!=null)
	    for (SkyScannerFlightResponseDto skyScannerFlightResponseDto : myObjects.getPlaces()) {
    		flightResponseDto=new FlightResponseDto();
	    	flightResponseDto.setPlaceId(skyScannerFlightResponseDto.getPlace_id());
	    	flightResponseDto.setCountryName(skyScannerFlightResponseDto.getCountry_name());
	    	placesList.add(flightResponseDto);
		}
	    
	    for (SkyScannerFlightResponseDto skyScannerFlightResponseDto : myObjects.getResults()) {
    		flightResponseDto=new FlightResponseDto();
	    	flightResponseDto.setDisplayName(skyScannerFlightResponseDto.getDisplay_name());
	    	flightResponseDto.setGeoType(skyScannerFlightResponseDto.getGeo_type());
	    	resultsList.add(flightResponseDto);
		}
	    responseDto.setCurrencies(currenciesList);
	    responseDto.setPlaces(placesList);
	    responseDto.setResults(resultsList);
		return responseDto;
		
	}
	/**
	 * Creates the session.
	 *
	 * @param flightDto the flight dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public ResponseDto createSession(FlightDto flightDto)throws HappyTouristException {
		ResponseDto responseDto=new ResponseDto();
		SkyScannerResponseDto myObjects = null;
		FlightResponseDto flightResponseDto=null;
		List<FlightResponseDto> flighResponseList=new ArrayList<FlightResponseDto>();
	    //step-1
		RestTemplate restTemplate = new RestTemplate();	
	    restTemplate.getMessageConverters().add( new FormHttpMessageConverter() );
	    MultiValueMap<String, String> formVars = new LinkedMultiValueMap<>();
	    formVars.add( "country", flightDto.getCountry());
	    formVars.add( "currency", flightDto.getCurrency());
	    formVars.add( "locale", flightDto.getLocale());
	    if(flightDto.getLocationSchema()!=null){
	      formVars.add( "locationSchema", flightDto.getLocationSchema());
	    }
	    if(flightDto.getGrouppricing()!=false){
	      formVars.add( "grouppricing", String.valueOf(flightDto.getGrouppricing()));
	    }
	    formVars.add( "originplace", flightDto.getOriginplace());
	    formVars.add( "destinationplace", flightDto.getDestinationplace());
	    if(flightDto.getOutbounddate()!=null){
	    formVars.add( "outbounddate", DateUtils.getFormatDate(flightDto.getOutbounddate(), DateUtils.DATE_ADDED));
	    }
	    if(flightDto.getInbounddate()!=null){
	    formVars.add( "inbounddate", DateUtils.getFormatDate(flightDto.getInbounddate(), DateUtils.DATE_ADDED));
	    }
	    if(flightDto.getAdults()!=null && flightDto.getAdults()!=0){
	      formVars.add( "adults", flightDto.getAdults().toString());
	    }
	    if(flightDto.getChildren()!=null && flightDto.getChildren()!=0){
	      formVars.add( "children", flightDto.getChildren().toString());
	    }
	    if(flightDto.getInfants()!=null && flightDto.getInfants()!=0){
	    formVars.add( "infants", flightDto.getInfants().toString());
	    }
	    if(flightDto.getCabinclass()!=null){
	    formVars.add( "cabinclass", flightDto.getCabinclass());
	    }
	    HttpHeaders headers = new HttpHeaders();	   
	    headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	    headers.add("Accept", "application/json");
	    headers.add("Accept-Language", "en-US,en;q=0.5");
	    headers.add("User-Agent", "USER_AGENT");
	    String url=messageSource.getMessage(SKYSCANNER_PRICE_URL, null, Locale.getDefault());//"http://partners.api.skyscanner.net/apiservices/pricing/v1.0";	
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("apiKey", messageSource.getMessage(SKYSCANNER_API_KEY, null, Locale.getDefault()))	    	    		    	    
	    	    .build()
	    	    .toUri();
	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(formVars, headers);		   
	    HttpEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.POST, request, String.class);
	    HttpHeaders responseHeader = response.getHeaders();
	   
	    //step-2
	    String locationHeaderUrl=responseHeader.getLocation().toString();  
	    URI  pollingSesionUrl= UriComponentsBuilder.fromUriString(locationHeaderUrl)
	    	    .queryParam("apiKey", messageSource.getMessage(SKYSCANNER_API_KEY, null, Locale.getDefault()))	    	    		    	    
	    	    .build()
	    	    .toUri();
	    
	    Map<String,List<SkyScannerFlightResponseDto>> map=restTemplate.getForObject(pollingSesionUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<SkyScannerResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    if(myObjects.getItineraries()!=null)
		    for (FlightItinerary flightItinerary : myObjects.getItineraries()) {
	    		flightResponseDto=new FlightResponseDto();
	    		flightResponseDto.setPricingOptions(flightItinerary.getPricingOptions());
	    		flightResponseDto.setInboundLegId(flightItinerary.getInboundLegId());
	    		flightResponseDto.setOutboundLegId(flightItinerary.getOutboundLegId());
		    	flightResponseDto.setBody(flightItinerary.getBookingDetailsLink().getBody());
		    	flightResponseDto.setMethod(flightItinerary.getBookingDetailsLink().getMethod());
		    	flightResponseDto.setUri(flightItinerary.getBookingDetailsLink().getUri());			    	
		    	flighResponseList.add(flightResponseDto);
			}
	    
	    responseDto.setFlightBookingResponse(flighResponseList);
	    return responseDto;
	}

	/**
	 * Creates the booking details.
	 *
	 * @param flightDto the flight dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	public ResponseDto createBookingDetails(FlightDto flightDto)throws HappyTouristException {
		ResponseDto responseDto=new ResponseDto();
		RestTemplate restTemplate = new RestTemplate();
		SkyScannerResponseDto myObjects = null;
		FlightResponseDto flightResponseDto=null;
		List<BookingOptions> bookingItemsList=new ArrayList<BookingOptions>();
		BookingOptions bookingOptionsInfo=null;
		List<FlightResponseDto> pollResponseList=new ArrayList<FlightResponseDto>();
		
		//step-3
		String baseUrl=messageSource.getMessage(SKYSCANNER_BASE_URL, null, Locale.getDefault());//"http://partners.api.skyscanner.net";
		StringBuilder sb = new StringBuilder(baseUrl);
		String targetUrl=sb.append(flightDto.getUri()).toString();
		
		MultiValueMap<String, String> formVars = new LinkedMultiValueMap<>();
		if(flightDto.getInboundLegId()!=null){
	      formVars.add( "InboundLegId", flightDto.getInboundLegId());
		}
	      formVars.add( "OutboundLegId", flightDto.getOutboundLegId());
	      formVars.add( "apiKey", messageSource.getMessage(SKYSCANNER_API_KEY, null, Locale.getDefault()));
	    
		
		HttpHeaders headers = new HttpHeaders();	   
	    headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	    headers.add("Accept", "application/json");
	    headers.add("Accept-Language", "en-US,en;q=0.5");
	    headers.add("User-Agent", "USER_AGENT");
	    	
	    
	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(formVars, headers);		   
	    HttpEntity<String> response = restTemplate.exchange(targetUrl, HttpMethod.PUT, request, String.class);
	    HttpHeaders responseHeader = response.getHeaders();
	    String locationHeaderUrl=responseHeader.getLocation().toString();  
	    URI  pollBookingDetailsUrl= UriComponentsBuilder.fromUriString(locationHeaderUrl)
	    	    .queryParam("apiKey", messageSource.getMessage(SKYSCANNER_API_KEY, null, Locale.getDefault()))	    	    		    	    
	    	    .build()
	    	    .toUri();
	    
	    Map<String,List<SkyScannerFlightResponseDto>> map=restTemplate.getForObject(pollBookingDetailsUrl, Map.class);
	    String jsonString = new Gson().toJson(map, Map.class);
	    ObjectMapper mapper = new ObjectMapper();	    
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	    try {
			myObjects = mapper.readValue(jsonString, new TypeReference<SkyScannerResponseDto>(){});
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	    if(myObjects.getBookingOptions()!=null)
		    for (BookingOptions bookingOptions : myObjects.getBookingOptions()) {
		    	bookingOptionsInfo=new BookingOptions();
		    	bookingOptionsInfo.setBookingItems(bookingOptions.getBookingItems());
		    	bookingItemsList.add(bookingOptionsInfo);
	    		
			}
	    /*bookingItemsList.forEach(bookingItems->{
	    	bookingItems.getBookingItems().forEach(bookingItem->{
	    		FlightResponseDto flightResponseDtos=new FlightResponseDto();
	    		flightResponseDtos.setAgentID(bookingItem.getAgentID());
	    		flightResponseDtos.setStatus(bookingItem.getStatus());
		    	flightResponseDtos.setPrice(bookingItem.getPrice());
		    	flightResponseDtos.setDeeplink(bookingItem.getDeeplink());
		    		    	
		    	pollResponseList.add(flightResponseDto);
	    	});	    	
	    });*/
	    for (BookingOptions bookingItems : bookingItemsList) {
	    	for(BookingItems bookingItem : bookingItems.getBookingItems()){
	    		flightResponseDto=new FlightResponseDto();
	    		flightResponseDto.setAgentID(bookingItem.getAgentID());
	    		flightResponseDto.setStatus(bookingItem.getStatus());
		    	flightResponseDto.setPrice(bookingItem.getPrice());
		    	flightResponseDto.setDeeplink(bookingItem.getDeeplink());
		    		    	
		    	pollResponseList.add(flightResponseDto);
	    	}	    	
		}
	    
	   responseDto.setPollResponse(pollResponseList);
	    
		
		
		return responseDto;
	}

}
