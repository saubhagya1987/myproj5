package com.happyTouristPersistence.dao;

import com.happyTouristPersistence.entity.ChatGroup;

public interface HappyTouristDao extends GenericDao<ChatGroup> {

	ChatGroup getGroupId(String groupAdminName, Integer groupId);

}
