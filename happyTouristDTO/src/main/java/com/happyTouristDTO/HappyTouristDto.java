package com.happyTouristDTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HappyTouristDto<T> {
	
	private String groupAdminName;
	private String groupName;
	private String imageUrl;
	private String groupImageData;
	private boolean isActive;
	private Date creationTime;
	private Integer groupId;
	private Integer accountId;
	private String userName;
	public String getGroupAdminName() {
		return groupAdminName;
	}
	public void setGroupAdminName(String groupAdminName) {
		this.groupAdminName = groupAdminName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getGroupImageData() {
		return groupImageData;
	}
	public void setGroupImageData(String groupImageData) {
		this.groupImageData = groupImageData;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
