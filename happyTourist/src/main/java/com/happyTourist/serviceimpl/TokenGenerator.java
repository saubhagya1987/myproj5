package com.happyTourist.serviceimpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.transaction.annotation.Transactional;

import com.happyTourist.enumdata.HappyTouristUserCode;
import com.happyTourist.exception.HappyTouristException;
import com.happyTouristPersistence.dao.ClientOauthDetailsDao;
import com.happyTouristPersistence.entity.ClientOauthDetails;


//@Component
@Transactional
public class TokenGenerator {
	// @Autowired
	//private ClientOauthDetailsRepository oauthRepository;
	private AuthorizationServerTokenServices defaultTokenServices;
	
	@Autowired
	private ClientOauthDetailsDao clientOauthDetailsDao;
	

	public OAuth2AccessToken token(com.happyTouristPersistence.entity.Account principal, OAuth2Request oAuth2Request, String userRoles)
			throws HappyTouristException {

		Set<GrantedAuthority> grantedAuthorities = getCommonGrantedAuthority(oAuth2Request.getAuthorities(), userRoles);
		User userPrincipal = new User(principal.getEmailId(), principal.getPassword(), true, true, true, true,
				grantedAuthorities);

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal,
				null, grantedAuthorities);
		OAuth2Authentication auth = new OAuth2Authentication(oAuth2Request, authenticationToken);
		OAuth2AccessToken token = defaultTokenServices.createAccessToken(auth);
		return token;
	}

	public ClientOauthDetails getAndValidateClient(String clientId, String clientSecret) throws HappyTouristException {

		//ClientOauthDetails clientDetails = oauthRepository.getByClientId(clientId);
		ClientOauthDetails clientDetails = clientOauthDetailsDao.getClientOauthDetails(clientId);
		if (clientDetails == null)
			throw new HappyTouristException(HappyTouristUserCode.CLIENT_NOT_FOUND);
		
		if (!clientDetails.getClientSecret().equals(clientSecret)) {
			throw new HappyTouristException(HappyTouristUserCode.CLIENT_NOT_AUTHENTICATED);
		}
		return clientDetails;
	}

	public OAuth2Request getOAuth2Request(String clientId, String clientSecret) throws HappyTouristException {

		ClientOauthDetails clientDetails = getAndValidateClient(clientId, clientSecret);

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		String[] userRolesArray = clientDetails.getAuthorities().split(",");

		for (String userRole : userRolesArray) {

			authorities.add(new SimpleGrantedAuthority(userRole.trim()));

		}

		return new OAuth2Request(new HashMap<>(), clientId, authorities, true, getSet(clientDetails.getScope(), ","),
				getSet(clientDetails.getResourceIds(), ","), null, new HashSet<>(), new HashMap<>());

	}

	private Set<String> getSet(String string, String regex) {
		Set<String> uniqueScopes = new HashSet<>();
		String[] scopearray = string.split(regex);
		for (String scope : scopearray) {
			uniqueScopes.add(scope.trim());
		}
		return uniqueScopes;
	}

	public Set<GrantedAuthority> getCommonGrantedAuthority(Collection<? extends GrantedAuthority> collection,
			String userRoles) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		String[] userRolesArray = userRoles.split(",");
		SimpleGrantedAuthority sGA = null;
		Set<String> stringSet = new HashSet<>();
		for(GrantedAuthority auth : collection){
			stringSet.add(auth.getAuthority());
		}
		for (String userRole : userRolesArray) {;
		sGA = new SimpleGrantedAuthority(userRole.trim());
			if (collection.contains(sGA)) {
				authorities.add(sGA);
			}

		}

		return authorities;
	}

	/**
	 * @param defaultTokenServices
	 *            the defaultTokenServices to set
	 */
	public void setDefaultTokenServices(AuthorizationServerTokenServices defaultTokenServices) {
		this.defaultTokenServices = defaultTokenServices;
	}

	/*public void setClientOauthDetailsDao(ClientOauthDetailsDao clientOauthDetailsDao) {
		this.clientOauthDetailsDao = clientOauthDetailsDao;
	}*/

	/*public void setOauthRepository(ClientOauthDetailsRepository oauthRepository) {
		this.oauthRepository = oauthRepository;
	}*/
}