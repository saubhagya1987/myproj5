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
@Table(name = "user_account")
@NamedQueries({
	@NamedQuery(name = "UserAccount.findByUserName", query = " Select u from UserAccount u where firstName=:userName"),
	
})

public class UserAccount implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
 	@Basic(optional = false)
 	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column(name = "account_id")
	private Integer accountId;
    
    @Column(name = "email_id")
    private String emailId;
    
    @Basic(optional = false)
    @Column(name="mobile_number")
	private String mobileNumber;
    
    @Basic(optional = false)
    @Column(name="password")
	private String password;
    
    @Column(name="image_url")
	private String imageUrl;
    
    @Column(name="image_name")
	private String imageName;
    
	@Basic(optional = false)
	@Column(name="first_name")
	private String firstName;
	
	@Basic(optional = false)
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Basic(optional = false)
	@Column(name="creation_time")
	private Date creationTime;
	
	@Basic(optional = false)
	@Column(name="country_code")
	private String countryCode;
	
	public UserAccount(){}

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

	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
		UserAccount other = (UserAccount) obj;
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

	 
  
  
}
