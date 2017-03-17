package com.happyTouristPersistence.dao;

import com.happyTouristPersistence.entity.ClientOauthDetails;


/**
 * The Interface ClientOauthDetailsDao.
 */
public interface ClientOauthDetailsDao extends GenericDao<ClientOauthDetails> {
	
	ClientOauthDetails getClientOauthDetails(String clientId);
}

