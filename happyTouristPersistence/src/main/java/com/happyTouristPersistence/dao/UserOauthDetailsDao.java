package com.happyTouristPersistence.dao;
import com.happyTouristPersistence.entity.UserOauthDetails;


/**
 * The Interface ClientOauthDetailsDao.
 */

public interface UserOauthDetailsDao extends GenericDao<UserOauthDetails> {
	
	UserOauthDetails getUserOauthDetails(String userName);
}

