package com.glo.simActivation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimActivationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimActivationApplication.class, args);
	}

}
