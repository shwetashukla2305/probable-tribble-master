package com.glo.uservalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserValidationApplication {

	@Bean
	public RestTemplate getTemplate(){
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	}

	public static void main(String[] args) {
		SpringApplication.run(UserValidationApplication.class, args);
	}

}
