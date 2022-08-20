package com.cognizant.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class PensionerDetailMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailMicroServiceApplication.class, args);
	}

}
