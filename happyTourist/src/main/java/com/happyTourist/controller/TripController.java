package com.happyTourist.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.HappyTouristService;
import com.happyTourist.utils.HappyTouristResponseUtils;
import com.happyTouristDTO.HappyTouristDto;
import com.happyTouristDTO.HappyTouristResponse;
import com.happyTouristDTO.TripRequestDto;

// TODO: Auto-generated Javadoc
/**
 * The Class TripController.
 */
@RestController
public class TripController {
	
	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(TripController.class);
	
	/** The gson. */
	@Autowired
	private Gson gson;

	/** The happy tourist service. */
	@Autowired
    //@Qualifier("TripAdvisor")
	private HappyTouristService happyTouristService;
	
	/**
	 * Gets the group name.
	 *
	 * @param happyTouristDto the happy tourist dto
	 * @return the group name
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/getGroupName", method = RequestMethod.GET)
	public HappyTouristResponse getGroupName(@RequestBody HappyTouristDto happyTouristDto)throws HappyTouristException { 
		
		LOGGER.debug("Request data for getGroupName  -"+ gson.toJson(happyTouristDto));
		HappyTouristDto groupName = happyTouristService.getGroupName(happyTouristDto.getGroupId(),happyTouristDto.getGroupAdminName());
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(groupName);
		LOGGER.debug("Response data for getGroupName-"+ gson.toJson(happyTouristResponse));
		return happyTouristResponse;
	    
    }
	
	/**
	 * Gets the trip data.
	 *
	 * @param tripAdvisorDto the trip advisor dto
	 * @return the trip data
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/getTripData", method = RequestMethod.GET)
	public HappyTouristResponse getTripData(@RequestBody TripRequestDto tripAdvisorDto)throws HappyTouristException { 
		LOGGER.debug("Request data for getTripData  -" + gson.toJson(tripAdvisorDto));	    
		TripRequestDto  groupName=happyTouristService.getTripData(tripAdvisorDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);
		happyTouristResponse.setBody(groupName);
		LOGGER.debug("Response data for getTripData-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	
		
}

