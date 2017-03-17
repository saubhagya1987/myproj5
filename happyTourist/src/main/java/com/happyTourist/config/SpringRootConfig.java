package com.happyTourist.config;

import org.ireslab.notification.service.MailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.google.gson.Gson;
import com.happyTouristPersistence.config.JPAConfig;
import com.happyTouristPersistence.config.MongoConfig;

@Configuration
@ComponentScan(basePackages = {"com.happyTourist"})
@PropertySource(value = {"classpath:messages.properties","classpath:mail_and_sms_credentials.properties"})
//@Import(JPAConfig.class)
@Import({ JPAConfig.class, MongoConfig.class })
@ImportResource(value={"classpath:spring-mail.xml"})
public class SpringRootConfig {

  
	
  @Bean
  public Gson gson() {
    return new Gson();
  }
  
  @Bean
  public PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {

    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
    source.setBasenames("happyTourist_messages", "messages");
    source.setUseCodeAsDefaultMessage(true);

    return source;
  }
}
