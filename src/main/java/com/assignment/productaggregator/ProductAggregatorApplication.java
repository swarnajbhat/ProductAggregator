package com.assignment.productaggregator;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.assignment.productaggregator.configuration.RequestResponseLoggingInterceptor;


@SpringBootApplication
public class ProductAggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAggregatorApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
		 
		RestTemplate restTemplate = new RestTemplate(factory);
		 
		restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
		
		return restTemplate;
	}

}
