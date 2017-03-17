package com.happyTouristPersistence.entity.daoImpl;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.happyTouristPersistence.dao.AccountDao;
import com.happyTouristPersistence.entity.Account;
@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao{
	/**
	 *
	 * Check Whether User Exist Or Not 
	 * 
	 */
	@Override
	public Account getAccountDetails(String userName) {
		Map<String, Object> fieldValue = new HashMap<>();
		fieldValue.put("userName", userName);		
		return findSingleResultByNameQuery("Account.findByUserName", fieldValue);
	}

	@Override
	public Account getProfileInfo(String userName,String password) {
		Map<String, Object> fieldValue = new HashMap<>();
		fieldValue.put("userName", userName);	
		fieldValue.put("password", password);	
		return findSingleResultByNameQuery("Account.findByUserNameAndPwd", fieldValue);
	}



}
