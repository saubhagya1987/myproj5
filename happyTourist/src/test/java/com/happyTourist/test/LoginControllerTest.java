package  com.happyTourist.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.happyTourist.service.AccountService;
import com.happyTouristDTO.AccountDto;
import com.happyTouristDTO.AccountResponseDto;
import com.happyTouristDTO.ResponseResult;

public class LoginControllerTest extends BaseSetUpEntity{

	
	Logger LOGGER = LoggerFactory.getLogger(LoginControllerTest.class);
	
	@Autowired
	Gson gson;
	
	
	@Test
	public void login() throws UnsupportedEncodingException, Exception{
		AccountDto accountDto=createHappyTouristRequest();		
		String requestJson = gson.toJson(accountDto);
		System.out.println(requestJson);
	    sendRequest(requestJson, "/signin", ResponseResult.OK);
	}

	private AccountDto createHappyTouristRequest() {		
		AccountDto accountDto = new AccountDto();
		accountDto.setUserName("saubhagya");	
		accountDto.setPassword("saubhagya");		
		return accountDto;
	}


}
