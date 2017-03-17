package com.happyTouristPersistence.entity.daoImpl;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.happyTouristPersistence.dao.UserOauthDetailsDao;
import com.happyTouristPersistence.entity.UserOauthDetails;
@Repository
public class UserOauthDetailsDaoImpl extends GenericDaoImpl<UserOauthDetails> implements UserOauthDetailsDao{

	@Override
	public UserOauthDetails getUserOauthDetails(String userName) {
		// TODO Auto-generated method stub
		Map<String, Object> fieldValue = new HashMap<>();
		fieldValue.put("userName", userName);		
		return findSingleResultByNameQuery("UserOauthDetails.findByUserName", fieldValue);
	}

}
