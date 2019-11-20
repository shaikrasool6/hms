package com.rest.java;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * @author Shaik
 *
 */
@SuppressWarnings("deprecation")
@SpringBootApplication
public class HospitalTestApplication {

	
	public static final Logger log=LoggerFactory.getLogger(HospitalTestApplication.class);

	/**
	 * this is main method of application which can bootstrap our application as a normal java program on server
	 */
	public static void main(String[] args) {

		SpringApplication.run(HospitalTestApplication.class, args);
		
		log.debug("application started...");

	}
	
	/**
	 * 
	 * @return this will create SessionFactoryBean object
	 */
	@Bean
	public HibernateJpaSessionFactoryBean factory() {
		return new HibernateJpaSessionFactoryBean();
	} 


}
