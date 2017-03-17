package com.happyTouristDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HappyTouristResponse<T> {

  private Integer statusCode;

  private String statusDescription;

  private String developerMessage;

  private String userMessage;

  //private long xmppLatestMessageEpoch;

  private T body;
  
  //Added for test cases
  //private ResponseDto responseDto;
  private ResponseResult result;
  

  public ResponseResult getResult() {
	return result;
}

public void setResult(ResponseResult result) {
	this.result = result;
}

public String getDeveloperMessage() {
    return developerMessage;
  }

  public void setDeveloperMessage(String developerMessage) {
    this.developerMessage = developerMessage;
  }

  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public T getBody() {
    return body;
  }

  public void setBody(T body) {
    this.body = body;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer status) {
    this.statusCode = status;
  }

  public String getStatusDescription() {
    return statusDescription;
  }

  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

/*public ResponseDto getResponseDto() {
	return responseDto;
}

public void setResponseDto(ResponseDto responseDto) {
	this.responseDto = responseDto;
}
*/
  /*public long getXmppLatestMessageEpoch() {
    return xmppLatestMessageEpoch;
  }

  public void setXmppLatestMessageEpoch(long xmppLatestMessageEpoch) {
    this.xmppLatestMessageEpoch = xmppLatestMessageEpoch;
  }*/
}
