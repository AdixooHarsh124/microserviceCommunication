package com.example.subscriberMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SubcriberMicroservice1Application {

	public static void main(String[] args) 
	{
		SpringApplication.run(SubcriberMicroservice1Application.class, args);
			
	}
	@Bean
	public RestTemplate restTemplete() 
	{
		return new RestTemplate();
	}
}
