package com.happyTourist.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.utils.HappyTouristResponseUtils;
import com.happyTouristDTO.HappyTouristResponse;


// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionController.
 */
@ControllerAdvice
public class ExceptionController {

  /** The Constant LOGGER. */
  private final static Logger LOGGER = Logger.getLogger(ExceptionController.class);

  /**
   * Handle all exception.
   *
   * @param exception the exception
   * @return the happy tourist response
   */
  @SuppressWarnings("rawtypes")
  @ExceptionHandler(Exception.class)
  public @ResponseBody HappyTouristResponse handleAllException(Exception exception) {
    LOGGER.error("Error description-" + ExceptionUtils.getStackTrace(exception));
    HappyTouristResponse happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    happyTouristResponse.setDeveloperMessage(exception.getMessage());
    return happyTouristResponse;
  }

  /**
   * Handle happy tourist exception.
   *
   * @param <T> the generic type
   * @param exception the exception
   * @return the happy tourist response
   */
  @SuppressWarnings("rawtypes")
  @ExceptionHandler(HappyTouristException.class)
  public @ResponseBody <T> HappyTouristResponse handleHappyTouristException(HappyTouristException exception) {
    LOGGER.error("Error description-" + ExceptionUtils.getStackTrace(exception));
    HappyTouristResponse<T> happyTouristResponse = new HappyTouristResponse<>();
    if (exception.getReefCode() != null) {
      happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(exception.getReefCode());
    } else {
      happyTouristResponse = HappyTouristResponseUtils.getHappyTouristResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    happyTouristResponse.setDeveloperMessage(exception.getMessage());
    return happyTouristResponse;
  }
}
