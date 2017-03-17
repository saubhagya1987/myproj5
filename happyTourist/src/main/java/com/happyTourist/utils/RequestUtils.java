package com.happyTourist.utils;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.happyTourist.exception.HappyTouristException;
import com.happyTouristDTO.FlightDto;
import com.happyTouristDTO.FlightResponseDto;
import com.happyTouristDTO.ResponseDto;
import com.happyTouristDTO.SkyScannerFlightResponseDto;
import com.happyTouristDTO.TripRequestDto;


public class RequestUtils {

	/**
	 * @return
	 */
	protected static MultiValueMap<String, String> buildRestTemplateHeaders() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("User-Agent", "USER_AGENT");
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");
		headers.add("Accept-Language", "en-US,en;q=0.5");
		return headers;
	}
	
	
	


	public static TripRequestDto getTripData(String url,TripRequestDto tripAdvisor) {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> headers = buildRestTemplateHeaders();		
		TripRequestDto tripAdvisorDto=new TripRequestDto();
		
		tripAdvisorDto.setLattitude(tripAdvisor.getLattitude());
		tripAdvisorDto.setLongitude(tripAdvisor.getLongitude());
		HttpEntity<TripRequestDto> request = new HttpEntity<TripRequestDto>(tripAdvisorDto,headers);
				
		TripRequestDto tripAdvisorDtoResponse= restTemplate.postForObject(url,request, TripRequestDto.class);
		
		return tripAdvisorDtoResponse;
	}





	public static ResponseDto getFlightData(String url, FlightDto flightDtoData) throws HappyTouristException {
		
		
		RestTemplate restTemplate = new RestTemplate();		    
	    URI  targetUrl= UriComponentsBuilder.fromUriString(url)
	    	    .queryParam("apiKey", "ir908041111719991942734146257682")	    	    
	    	    .build()
	    	    .toUri();
//	    Type type = new TypeToken<HashMap<String, ArrayList<FlightResponseDto>>>() {
//		}.getType();
		
	    //JsonObject resultEntity = restTemplate.getForObject(targetUrl,JsonObject.class);
	    Map<String,List<SkyScannerFlightResponseDto>> map=restTemplate.getForObject(targetUrl, Map.class);
	   /* Currencies result  = resultEntity.getBody();
	    Currencies list =result;// result.getCurrencies();
	    for(FlightResponseDto dto : list.getCurrencies())
	    	System.out.println(dto.getCode());
	    */
	    //System.out.println(result.getBody());
	    /*List<LinkedHashMap> map=restTemplate.getForObject(targetUrl, List.class);
	    for (LinkedHashMap linkedHashMap : map) {
			System.out.println(linkedHashMap.get("Code"));
		}*/
	    ResponseDto responseDto=new ResponseDto();
	   /* for (Map.Entry<String, List<FlightResponseDto>> entry : map.entrySet()) {
	    	String key = entry.getKey();
	    	List<FlightResponseDto> currencies=entry.getValue();
	    	responseDto.setCurrencies(currencies);
		}*/
	    
	    return responseDto;//  result;
		
	}
	
}
