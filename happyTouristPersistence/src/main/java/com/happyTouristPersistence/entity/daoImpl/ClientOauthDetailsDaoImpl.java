package com.happyTouristPersistence.entity.daoImpl;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.happyTouristPersistence.dao.AccountDao;
import com.happyTouristPersistence.dao.ClientOauthDetailsDao;
import com.happyTouristPersistence.entity.Account;
import com.happyTouristPersistence.entity.ClientOauthDetails;
@Repository
public class ClientOauthDetailsDaoImpl extends GenericDaoImpl<ClientOauthDetails> implements ClientOauthDetailsDao{

	@Override
	public ClientOauthDetails getClientOauthDetails(String clientId) {
		// TODO Auto-generated method stub
		Map<String, Object> fieldValue = new HashMap<>();
		fieldValue.put("clientId", clientId);		
		return findSingleResultByNameQuery("ClientOauthDetails.findByClientId", fieldValue);
	}
	

}
