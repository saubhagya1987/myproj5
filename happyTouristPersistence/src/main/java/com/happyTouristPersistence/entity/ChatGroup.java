package com.happyTouristPersistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@Entity
@Table(name = "chat_group")

@NamedQueries({
	@NamedQuery(name = "ChatGroup.findBygroupAdminNameAndGroupId", query = " Select c from ChatGroup c where groupAdminName=:groupAdminName and groupId=:groupId"),
	@NamedQuery(name = "ChatGroup.findBygroupAdminNameAndAccountId", query = " Select c from ChatGroup c where groupAdminName=:groupAdminName and accountId=:accountId"),
	@NamedQuery(name = "ChatGroup.findBygroupId", query = " Select c from ChatGroup c where groupId=:groupId"),
	
})

public class ChatGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
   	@Basic(optional = false)
   	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column(name = "group_id")
	private Integer groupId;
	
	@Basic(optional = false)
    @Column(name = "group_admin_name")
	private String groupAdminName;

	@Column(name = "image_url")
	private String imageUrl;
	
	@Basic(optional = false)
	@Column(name = "group_name")
	private String groupName;
	
	@Basic(optional = false)
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "creation_time")
	private Date creationTime;
	
	@Basic(optional = false)
	@Column(name = "account_Id")
	private Integer accountId;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId",fetch = FetchType.LAZY)
	private List<ChatGroupMember> chatGroupMemberList;
	*/
	
	public  ChatGroup(){
		
	}

	public ChatGroup(Integer groupId) {
		this.groupId=groupId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupAdminName() {
		return groupAdminName;
	}

	public void setGroupAdminName(String groupAdminName) {
		this.groupAdminName = groupAdminName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/*public List<ChatGroupMember> getChatGroupMemberList() {
		return chatGroupMemberList;
	}

	public void setChatGroupMemberList(List<ChatGroupMember> chatGroupMemberList) {
		this.chatGroupMemberList = chatGroupMemberList;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatGroup other = (ChatGroup) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChatGroup [groupId=" + groupId + "]";
	}

}
