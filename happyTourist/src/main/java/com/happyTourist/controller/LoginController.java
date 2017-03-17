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
import com.happyTourist.service.AccountService;
import com.happyTourist.service.EventService;
import com.happyTourist.utils.HappyTouristResponseUtils;
import com.happyTouristDTO.AccountDto;
import com.happyTouristDTO.AccountResponseDto;
import com.happyTouristDTO.EventDto;
import com.happyTouristDTO.EventResponseDto;
import com.happyTouristDTO.HappyTouristResponse;

@RestController
public class LoginController {
	
	private final static Logger LOGGER = Logger.getLogger(EventController.class);
	@Autowired
	private Gson gson;
	
	/** The account service. */
	@Autowired
	AccountService accountService;
	
	
	/**
	 * Creates the user.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public HappyTouristResponse createUser(@RequestBody AccountDto accountDto)throws HappyTouristException { 
		LOGGER.debug("Request data for createUser -" + gson.toJson(accountDto));	    
		AccountResponseDto  accountDetails=accountService.createUser(accountDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);		
		happyTouristResponse.setBody(accountDetails);
		LOGGER.debug("Response data for createUser-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	/**
	 * Activate user.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/activateUser", method = RequestMethod.POST)
	public HappyTouristResponse activateUser(@RequestBody AccountDto accountDto)throws HappyTouristException { 
		LOGGER.debug("Request data for activateUser -" + gson.toJson(accountDto));	    
		AccountResponseDto  accountDetails=accountService.activateUser(accountDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);		
		happyTouristResponse.setBody(accountDetails);
		LOGGER.debug("Response data for activateUser-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	
	
	
	/**
	 * Signin.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public HappyTouristResponse signin(@RequestBody AccountDto accountDto)throws HappyTouristException { 
		LOGGER.debug("Request data for signin -" + gson.toJson(accountDto));	    
		AccountResponseDto  accountDetails=accountService.signin(accountDto);			
		HappyTouristResponse<Object> happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.OK);		
		happyTouristResponse.setBody(accountDetails);
		LOGGER.debug("Response data for signin-" + gson.toJson(happyTouristResponse));
		return happyTouristResponse;
    }
	
	
	

}
