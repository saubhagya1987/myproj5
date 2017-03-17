package com.happyTourist.service;

import com.happyTourist.exception.HappyTouristException;
import com.happyTouristDTO.AccountDto;
import com.happyTouristDTO.AccountResponseDto;

public interface AccountService {

	/**
	 * Creates the user.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	AccountResponseDto createUser(AccountDto accountDto) throws HappyTouristException;
	/**
	 * Signin.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	AccountResponseDto signin(AccountDto accountDto)throws HappyTouristException;
	/**
	 * Activate user.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	AccountResponseDto activateUser(AccountDto accountDto)throws HappyTouristException;

	

	

}
