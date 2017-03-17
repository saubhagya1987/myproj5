package com.happyTouristPersistence.entity.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.happyTouristPersistence.dao.HappyTouristDao;
import com.happyTouristPersistence.entity.ChatGroup;

@Repository
public class HappyTouristDaoImpl  extends GenericDaoImpl<ChatGroup> implements HappyTouristDao{

	@Override
	public ChatGroup getGroupId(String groupAdminName, Integer groupId) {
		Map<String, Object> fieldValue = new HashMap<>();
		fieldValue.put("groupAdminName", groupAdminName);
		fieldValue.put("groupId", groupId);
		
		return findSingleResultByNameQuery("ChatGroup.findBygroupAdminNameAndGroupId", fieldValue);
	}

}
