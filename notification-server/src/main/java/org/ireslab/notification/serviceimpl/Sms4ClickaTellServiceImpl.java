package org.ireslab.notification.serviceimpl;

import org.apache.log4j.Logger;
import org.ireslab.notification.bean.SmsUser;
import org.ireslab.notification.service.SmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Sms4ClickaTellServiceImpl implements SmsService {
  /** The Log. */
  static Logger Log = Logger.getLogger(Sms4ClickaTellServiceImpl.class);
  /** The messagesource. */

  private String userNameClickatell;

  private String passwordClickatell;

  private String apiId;

  private String urlClickatell;

  private String from;


  /**
   * Send sms.
   *
   * @param user the user
   * @throws BccException the bcc exception
   */
  public void sendSms(SmsUser smsUser) throws Exception {

    String mobileNumber = smsUser.getUserMobileNumber();
    String urlMessage = smsUser.getTextMessage();
    StringBuffer smsUrl = new StringBuffer();
    // for us
    String smsOutGoingUrl = smsUrl.append(urlClickatell).append("?user=" + userNameClickatell)
        .append("&password=" + passwordClickatell).append("&api_id=" + apiId).append("&to=" + mobileNumber)
        .append("&text=" + urlMessage).append("&mo=" + 1).append("&unicode=" + 1).append("&from=" + from).toString();

    RestTemplate restTemplate = new RestTemplate();
    try {
      ResponseEntity<String> response = restTemplate.getForEntity(smsOutGoingUrl, String.class);
      Log.debug("Send Message Response Code: " + response.getStatusCode() + " Response Message : " + response.getBody()
          + "for " + smsOutGoingUrl);
    } catch (Exception exception) {
      Log.error(" Error : " + exception.getLocalizedMessage());
      throw new Exception(exception);
    }
  }


  public String getUserNameClickatell() {
    return userNameClickatell;
  }


  public void setUserNameClickatell(String userNameClickatell) {
    this.userNameClickatell = userNameClickatell;
  }


  public String getPasswordClickatell() {
    return passwordClickatell;
  }


  public void setPasswordClickatell(String passwordClickatell) {
    this.passwordClickatell = passwordClickatell;
  }


  public String getApiId() {
    return apiId;
  }


  public void setApiId(String apiId) {
    this.apiId = apiId;
  }


  public String getUrlClickatell() {
    return urlClickatell;
  }


  public void setUrlClickatell(String urlClickatell) {
    this.urlClickatell = urlClickatell;
  }


  public String getFrom() {
    return from;
  }


  public void setFrom(String from) {
    this.from = from;
  }


}
