package com.happyTouristPersistence.entity.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.happyTouristPersistence.dao.ClientOauthDetailsDao;
import com.happyTouristPersistence.entity.ClientOauthDetails;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientDetailsServiceImpl.
 */
@Service(value = "customClientDetailServiceImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService {
	
	/** The client oauth details dao. */
	@Autowired
	private ClientOauthDetailsDao clientOauthDetailsDao;
		
	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		ClientOauthDetails clientOauthDetails = clientOauthDetailsDao.getClientOauthDetails(clientId);
		
		if(clientOauthDetails == null){
			throw new ClientRegistrationException("Client Not Found");
		}
		
		BaseClientDetails clientDetails = new BaseClientDetails(clientOauthDetails.getClientId(),
				clientOauthDetails.getResourceIds(), clientOauthDetails.getScope(),
				clientOauthDetails.getAuthorizedGrantTypes(),
				clientOauthDetails.getAuthorities());
		clientDetails.setClientSecret(clientOauthDetails.getClientSecret());
		clientDetails.setAccessTokenValiditySeconds(clientOauthDetails.getAccessTokenValidity());
		clientDetails.setRefreshTokenValiditySeconds(clientOauthDetails.getRefreshTokenValidity());
		return clientDetails;
	}
	/*public void setClientOauthDetailsDao(ClientOauthDetailsDao clientOauthDetailsDao) {
		this.clientOauthDetailsDao = clientOauthDetailsDao;
	}*/
}
