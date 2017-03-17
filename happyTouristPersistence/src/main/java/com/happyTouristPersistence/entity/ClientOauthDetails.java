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
@Table(name = "client_oauth_details")

@NamedQueries({
	@NamedQuery(name = "ClientOauthDetails.findByClientId", query = " Select a from ClientOauthDetails a where clientId=:clientId"),
	
})

public class ClientOauthDetails implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id", nullable = false)
  private String clientId;
  @Column(name = "client_secret", nullable = false)
  private String clientSecret;
  @Column(name = "access_token_validity", nullable = false)
  private int accessTokenValidity;
  @Column(name = "refresh_token_validity", nullable = false)
  private int refreshTokenValidity;
  @Column(name = "resource_ids", nullable = false)
  private String resourceIds;
  @Column(name = "scope", nullable = false)
  private String scope;
  @Column(name = "authorized_grant_types", nullable = false)
  private String authorizedGrantTypes;
  @Column(name = "authorities", nullable = false)
  private String authorities;
  @Column(name = "web_server_redirect_uri")
  private String registeredRedirectUris;
  @Column(name = "additional_information")
  private String additional_information;
  @Column(name = "autoapprove")
  private boolean autoapprove;

  public ClientOauthDetails() {}

  public ClientOauthDetails(String clientId, String resourceIds, String scopes, String grantTypes, String authorities) {
    this(clientId, resourceIds, scopes, grantTypes, authorities, null);
  }

  public ClientOauthDetails(String clientId, String resourceIds, String scopes, String grantTypes, String authorities,
      String redirectUris) {

    this.clientId = clientId;
    this.resourceIds = resourceIds;
    this.scope = scopes;
    this.authorizedGrantTypes = grantTypes;
    this.authorities = authorities;
    this.registeredRedirectUris = redirectUris;
  }

  /**
   * @return the clientId
   */
  public String getClientId() {
    return clientId;
  }

  /**
   * @param clientId the clientId to set
   */
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  /**
   * @return the resourceIds
   */
  public String getResourceIds() {
    return resourceIds;
  }

  /**
   * @param resourceIds the resourceIds to set
   */
  public void setResourceIds(String resourceIds) {
    this.resourceIds = resourceIds;
  }

  /**
   * @return the scope
   */
  public String getScope() {
    return scope;
  }

  /**
   * @param scope the scope to set
   */
  public void setScope(String scope) {
    this.scope = scope;
  }

  /**
   * @return the authorizedGrantTypes
   */
  public String getAuthorizedGrantTypes() {
    return authorizedGrantTypes;
  }

  /**
   * @param authorizedGrantTypes the authorizedGrantTypes to set
   */
  public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
    this.authorizedGrantTypes = authorizedGrantTypes;
  }

  /**
   * @return the authorities
   */
  public String getAuthorities() {
    return authorities;
  }

  /**
   * @param authorities the authorities to set
   */
  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

  /**
   * @return the registeredRedirectUris
   */
  public String getRegisteredRedirectUris() {
    return registeredRedirectUris;
  }

  /**
   * @param registeredRedirectUris the registeredRedirectUris to set
   */
  public void setRegisteredRedirectUris(String registeredRedirectUris) {
    this.registeredRedirectUris = registeredRedirectUris;
  }


  /**
   * @return the clientSecret
   */
  public String getClientSecret() {
    return clientSecret;
  }

  /**
   * @param clientSecret the clientSecret to set
   */
  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  /**
   * @return the accessTokenValidity
   */
  public int getAccessTokenValidity() {
    return accessTokenValidity;
  }

  /**
   * @param accessTokenValidity the accessTokenValidity to set
   */
  public void setAccessTokenValidity(int accessTokenValidity) {
    this.accessTokenValidity = accessTokenValidity;
  }

  /**
   * @return the refreshTokenValidity
   */
  public int getRefreshTokenValidity() {
    return refreshTokenValidity;
  }

  /**
   * @param refreshTokenValidity the refreshTokenValidity to set
   */
  public void setRefreshTokenValidity(int refreshTokenValidity) {
    this.refreshTokenValidity = refreshTokenValidity;
  }

  /**
   * @return the additional_information
   */
  public String getAdditional_information() {
    return additional_information;
  }

  /**
   * @param additional_information the additional_information to set
   */
  public void setAdditional_information(String additional_information) {
    this.additional_information = additional_information;
  }

  /**
   * @return the autoapprove
   */
  public boolean isAutoapprove() {
    return autoapprove;
  }

  /**
   * @param autoapprove the autoapprove to set
   */
  public void setAutoapprove(boolean autoapprove) {
    this.autoapprove = autoapprove;
  }
}
