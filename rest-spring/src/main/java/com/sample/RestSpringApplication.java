package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestSpringApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(RestSpringApplication.class);
	
	public static void main(String[] args) {
		logger.info("this is a info message");
		SpringApplication.run(RestSpringApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}

