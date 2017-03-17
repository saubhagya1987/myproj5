package com.happyTourist.config;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderCreater {

	static Logger logger = Logger.getLogger(PasswordEncoderCreater.class.getName());

	public String encrptedpassword(String password) {
		logger.debug("password encoding start :");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}

}
