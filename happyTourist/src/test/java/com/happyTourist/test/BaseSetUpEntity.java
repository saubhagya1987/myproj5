package com.happyTourist.test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;






import com.google.gson.Gson;
import com.happyTourist.config.SpringRootConfig;
import com.happyTourist.config.SpringWebConfig;
import com.happyTouristDTO.HappyTouristResponse;
import com.happyTouristDTO.ResponseDto;
import com.happyTouristDTO.ResponseResult;
import com.happyTouristPersistence.config.JPAConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseSetUpEntity.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringRootConfig.class/*,SpringWebConfig.class*/})
@Rollback(false)
@WebAppConfiguration
@Transactional
public abstract class BaseSetUpEntity {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	@Autowired
	protected  WebApplicationContext wac;
	
	@Autowired
	protected Gson gson;
	
	protected  MockMvc mockMVC;

	
	@Before
	public  void setUp() throws Exception {
		
		mockMVC = MockMvcBuilders.webAppContextSetup(wac).alwaysExpect(status().isOk()).build();
	}

	
	
	public HappyTouristResponse sendRequest(String requestJson, String relativeUrl, ResponseDto expectedResponseResult) throws Exception  {
		MvcResult  refreshToken = mockMVC.perform(post(OAUTH_PASSWORD_GRANT).contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andReturn();
		
		@SuppressWarnings("unchecked")
		Map<String, String> refreshtokenMap =  gson.fromJson(refreshToken.getResponse().getContentAsString(), Map.class);
		
		MvcResult  aaccessToken = mockMVC.perform(post(AUTH_SERVER_URI).contentType(MediaType.APPLICATION_JSON).content(requestJson).param("client_id", "ireslab")
				.param("client_secret", "12345").param("refresh_token", refreshtokenMap.get("refresh_token"))).andDo(print()).andReturn();
		@SuppressWarnings({ "unchecked", "unused" })
		Map<String, String> aaccessTokenMap =  gson.fromJson(aaccessToken.getResponse().getContentAsString(), Map.class);
		
		MvcResult  result = mockMVC.perform(post(relativeUrl).contentType(MediaType.APPLICATION_JSON).content(requestJson).param("access_token", refreshtokenMap.get("access_token"))).andDo(print()).andReturn();
		
		Assert.assertNotNull(result);// Change assert statement to use full 
		String ContentAsString = result.getResponse().getContentAsString()  ;
	
		HappyTouristResponse responseObj = gson.fromJson(ContentAsString, HappyTouristResponse.class);
		Assert.assertNotNull(responseObj);
		//Assert.assertEquals("Result of response not matched", expectedResponseResult.getResponseDescription(), responseObj.getResponseDto().getResponseDescription());
		//Assert.assertEquals("Result code of response not matched", expectedResponseResult.getResponseCode(), responseObj.getResponseDto().getResponseCode());
		return responseObj;
	}
	
	   
		public MvcResult sendRequest(String requestJson, String relativeUrl, ResponseResult expectedResponseResult) throws Exception,UnsupportedEncodingException {			
		MvcResult  result = mockMVC.perform(post(relativeUrl).contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andReturn();	    
	    System.out.println("ssss"+ result.getResponse().getContentType() );
		Assert.assertNotNull(result);		
		String ContentAsString = result.getResponse().getContentAsString();
		HappyTouristResponse responseObj = gson.fromJson(ContentAsString, HappyTouristResponse.class);
		Assert.assertNotNull(responseObj);
		Assert.assertEquals("Result of response not matched", expectedResponseResult.name(), responseObj.getStatusDescription());
		Assert.assertEquals("Result code of response not matched", expectedResponseResult.getCode(), responseObj.getStatusCode());
		return result;
	}
	
	
	
	public Map<String, JsonNode> parse(String json) throws JsonProcessingException, IOException {
		JsonFactory factory = new JsonFactory();

		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode = mapper.readTree(json);
	//	System.out.println(json);

		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.getFields();

		Map<String, JsonNode> mstyleMap = new HashMap<String, JsonNode>();

		while (fieldsIterator.hasNext()) {
			Map.Entry<String, JsonNode> field = fieldsIterator.next();
			mstyleMap.put(field.getKey(), field.getValue());
		//	System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());

		}
		return mstyleMap;
	}
	
	
	 
  	@SuppressWarnings("unused")
	private static HttpHeaders getHeaders(){
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        return headers;
	    }
	     
	  /** The Constant AUTH_SERVER_URI. */
  	private static final String AUTH_SERVER_URI = "/oauth/token";
	  
  	/** The Constant CLIENT_CREDENTIAL. */
  	private static final String CLIENT_CREDENTIAL = "&client_id=ireslab&client_secret=12345";
	  
  	/** The Constant OAUTH_PASSWORD_GRANT. */
  	private static final String OAUTH_PASSWORD_GRANT = AUTH_SERVER_URI+ "?grant_type=password&username=saubhagya&password=saubhagya" + CLIENT_CREDENTIAL;
	     
	  /** The Constant OAUTH_ACCESS_TOKEN. */
  	@SuppressWarnings("unused")
	private static final String OAUTH_ACCESS_TOKEN = "?access_token=";
	  
  	/** The Constant OAUTH_REFRESH_TOKEN. */
  	@SuppressWarnings("unused")
	private static final String OAUTH_REFRESH_TOKEN = "?grant_type=refresh_token " + CLIENT_CREDENTIAL;
	  
	 
	
}
