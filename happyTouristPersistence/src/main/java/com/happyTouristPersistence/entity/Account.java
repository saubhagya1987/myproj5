package com.happyTouristPersistence.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
@Entity
@Table(name = "account")

@NamedQueries({
	@NamedQuery(name = "Account.findByUserName", query = " Select a from Account a where userName=:userName"),
	@NamedQuery(name = "Account.findByUserNameAndPwd", query = " Select a from Account a where userName=:userName and password=:password")
	
})

public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
 	@Basic(optional = false)
 	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column(name = "account_id")
	private Integer accountId;
    
    @Basic(optional = false)
    @Column(name = "email_id")
    private String emailId;
    
    
    @Column(name="mobile_number")
	private String mobileNumber;
    
    @Basic(optional = false)
    @Column(name="password")
	private String password;   
    
	@Basic(optional = false)
	@Column(name="user_name")
	private String userName;
	
	@Basic(optional = false)
	@Column(name="is_active")
	private Boolean isActive;
	
	@Basic(optional = false)
	@Column(name="creation_time")
	private Date creationTime;
	
	@Basic(optional = false)
	@Column(name="activation_code")
	private String activationCode;
	
	
	
	public Account(){}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
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
		Account other = (Account) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + "]";
	}



	public Integer getAccountId() {
		return accountId;
	}



	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public Date getCreationTime() {
		return creationTime;
	}



	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}



	public String getActivationCode() {
		return activationCode;
	}



	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	 
  
  
}
