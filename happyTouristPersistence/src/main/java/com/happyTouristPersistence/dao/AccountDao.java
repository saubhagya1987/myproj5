package com.happyTouristPersistence.dao;
import com.happyTouristPersistence.entity.Account;

public interface AccountDao extends GenericDao<Account>{
	/**
	 *
	 * Check Whether User Exist Or Not 
	 * 
	 */
	Account getAccountDetails(String userName);

	Account getProfileInfo(String userName, String md5DigestAsHex);

}
