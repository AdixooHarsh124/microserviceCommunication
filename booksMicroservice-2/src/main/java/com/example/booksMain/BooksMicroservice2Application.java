package com.example.booksMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BooksMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(BooksMicroservice2Application.class, args);
	}

	@Bean 
	public RestTemplate restTemplete() 
	{
		return new RestTemplate();
	}
}
