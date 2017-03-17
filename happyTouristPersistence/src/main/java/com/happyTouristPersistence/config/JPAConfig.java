package com.happyTouristPersistence.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// TODO: Auto-generated Javadoc
/**
 * The Class JPAConfig.
 */
@Configuration
@PropertySource(value = { "classpath:persistence.properties" })
//@ComponentScan("com.happyTouristPersistence")
@EnableTransactionManagement
public class JPAConfig {

	/** The Log. */
	static Logger Log = Logger.getLogger(JPAConfig.class.getName());

	/** The environment. */
	@Autowired
	private Environment environment;

	/**
	 * Entity manager factory.
	 *
	 * @return the local container entity manager factory bean
	 */
	@Bean	
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(environment.getProperty("package.name"));
		em.setPersistenceUnitName("happyTouristPersistence");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		em.afterPropertiesSet();

		return em;
	}

	/**
	 * Data source.
	 *
	 * @return the data source
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("datasource.driver"));
		dataSource.setUrl(environment.getProperty("datasource.url"));
		dataSource.setUsername(environment.getProperty("datasource.username"));
		dataSource.setPassword(environment.getProperty("datasource.password"));

		Properties properties = new Properties();
		properties.setProperty("useUnicode", "true");
		properties.setProperty("characterEncoding", "UTF-8");
		properties.setProperty("charSet", "UTF-8");
		dataSource.setConnectionProperties(properties);

		return dataSource;
	}

	/**
	 * Transaction manager.
	 *
	 * @param emf
	 *            the emf
	 * @return the platform transaction manager
	 */
	@Bean	
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	/**
	 * Exception translation.
	 *
	 * @return the persistence exception translation post processor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Additional properties.
	 *
	 * @return the properties
	 */
	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.connection.useUnicode", "true");
		properties.setProperty("hibernate.connection.characterEncoding", "UTF-8");
		properties.setProperty("hibernate.connection.charSet", "UTF-8");

		return properties;
	}
	
	/*@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {

		return new JdbcTemplate(dataSource);
	}*/
	
}