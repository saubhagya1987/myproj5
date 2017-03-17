package com.happyTouristPersistence.config;

import java.net.UnknownHostException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
@PropertySource(value = { "classpath:mongo.properties" })
@ComponentScan("com.happyTouristPersistence")
@EnableMongoRepositories
public class MongoConfig{
	
	@Value("${mongodb.url}")
	private String mongodbUrl;
	
	@Value("${mongodb.db}")
	private String defaultDb;
	
	@Value("${mongodb.db.port}")
	private String mongodbPort;	
	
	@Value("${mongodb.db.userName}")
	private String dbUserName;
	
	@Value("${mongodb.db.password}")
	private String dbPassword;  
	
	@Value("${mongodb.db.source}")
	private String source;  
	    
	    @Bean
	    public MongoDbFactory mongoDbFactory() throws Exception {
	        // Set credentials      	        
	    	MongoCredential credential = MongoCredential.createScramSha1Credential(dbUserName, source, dbPassword.toCharArray());	    	
	        ServerAddress serverAddress = new ServerAddress(mongodbUrl, Integer.parseInt(mongodbPort));     
	        // Mongo Client
	        MongoClient mongoClient = new MongoClient(serverAddress,Arrays.asList(credential));
	        // Mongo DB Factory
	        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, defaultDb);
	        return simpleMongoDbFactory;
	    }
	    
	     /**
	     * Template ready to use to operate on the database
	     * 
	     * @return Mongo Template ready to use
	     */
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception {
	        //return new MongoTemplate(mongoDbFactory());
	    	MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
			return mongoTemplate;
	    }
	
	//working code
	
	/*@Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException{
        return new SimpleMongoDbFactory(new MongoClient(),"happy_tourist");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException{
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());      
        return mongoTemplate;
    }
	
    */
    //To resolve ${} in @Value
  	@Bean
  	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
  		return new PropertySourcesPlaceholderConfigurer();
  	}

  	
}
