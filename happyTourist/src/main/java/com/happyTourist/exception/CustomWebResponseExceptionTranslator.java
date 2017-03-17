package com.happyTourist.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

@Component(value = "customWWebResponseExceptionTranslator")
public class CustomWebResponseExceptionTranslator extends DefaultWebResponseExceptionTranslator {
	Logger LOGGER = LoggerFactory.getLogger(CustomWebResponseExceptionTranslator.class);

	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception exception) throws Exception {

		ResponseEntity<OAuth2Exception> entity = super.translate(exception);
		ResponseEntity<OAuth2Exception> modifyEntity = entity;
		OAuth2Exception oAuth2Exception = entity.getBody();
		if (oAuth2Exception instanceof InvalidTokenException) {
			modifyEntity = new ResponseEntity<OAuth2Exception>(entity.getBody(), entity.getHeaders(), HttpStatus.OK);
			entity.getBody().addAdditionalInformation("statusCode", "401");
			entity.getBody().addAdditionalInformation("error_description", "Invalid access token");
		}
		LOGGER.error(ExceptionUtils.getStackTrace(exception));
		return modifyEntity;
	}

}
