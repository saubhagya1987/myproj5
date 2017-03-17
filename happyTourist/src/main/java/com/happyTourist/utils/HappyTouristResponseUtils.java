package com.happyTourist.utils;

import org.springframework.http.HttpStatus;

import com.happyTourist.enumdata.HappyTouristCode;
import com.happyTouristDTO.HappyTouristResponse;

public class HappyTouristResponseUtils {
	public static <T> HappyTouristResponse<T> getHappyTouristResponse(HttpStatus httpStatus) {
		HappyTouristResponse<T> reefResponse = new HappyTouristResponse<>();
		reefResponse.setStatusCode(httpStatus.value());
		reefResponse.setStatusDescription(httpStatus.getReasonPhrase());
		return reefResponse;
	}

	public static <T> HappyTouristResponse<T> getHappyTouristResponse(HappyTouristCode happyTouristCode) {
		HappyTouristResponse<T> reefResponse = new HappyTouristResponse<>();
		reefResponse.setStatusCode(happyTouristCode.getCode());
		reefResponse.setStatusDescription(happyTouristCode.getDescription());
		return reefResponse;
	}
}
