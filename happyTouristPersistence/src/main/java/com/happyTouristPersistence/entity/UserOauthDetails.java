package com.happyTouristPersistence.entity;

import java.io.Serializable;

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
@Table(name = "user_oauth_details")

@NamedQueries({
	@NamedQuery(name = "UserOauthDetails.findByUserName", query = " Select a from UserOauthDetails a where userName=:userName"),
	
})
public class UserOauthDetails implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;


  @Column(name = "username", nullable = false, unique=true)
  private String userName;

  @Column(name = "authorities", nullable = false)
  private String authorities;

  @Column(name = "account_non_expired", nullable = false)
  private boolean accountNonExpired;

  @Column(name = "account_non_locked", nullable = false)
  private boolean accountNonLocked;

  @Column(name = "credentials_non_expired", nullable = false)
  private boolean credentialsNonExpired;

  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  public UserOauthDetails() {}

  public UserOauthDetails(String username, String password, boolean enabled, boolean accountNonExpired,
      boolean credentialsNonExpired, boolean accountNonLocked, String authorities) {

    if (((username == null) || "".equals(username))) {
      throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
    }

    this.userName = username;
    this.enabled = enabled;
    this.accountNonExpired = accountNonExpired;
    this.credentialsNonExpired = credentialsNonExpired;
    this.accountNonLocked = accountNonLocked;
    this.authorities = authorities;

  }

  public UserOauthDetails(String username, String password, String authorities) {

    this(username, password, true, true, true, true, authorities);
  }



  /**
   * @param authorities the authorities to set
   */
  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

  /**
   * @param accountNonExpired the accountNonExpired to set
   */
  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  /**
   * @param accountNonLocked the accountNonLocked to set
   */
  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  /**
   * @param credentialsNonExpired the credentialsNonExpired to set
   */
  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }



  /**
   * @return the authorities
   */
  public String getAuthorities() {
    return authorities;
  }

  /**
   * @return the accountNonExpired
   */
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  /**
   * @return the accountNonLocked
   */
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  /**
   * @return the credentialsNonExpired
   */
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  /**
   * @return the enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }

    UserOauthDetails other = (UserOauthDetails) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (id.equals(other.id)) {
      return true;
    }
    if (userName == null) {
      if (other.userName != null) {
        return false;
      }
    } else if (!userName.equals(other.userName)) {
      return false;
    }
    return true;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}
