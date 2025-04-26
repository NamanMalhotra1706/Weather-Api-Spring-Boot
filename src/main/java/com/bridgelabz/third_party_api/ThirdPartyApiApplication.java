package com.bridgelabz.third_party_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThirdPartyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyApiApplication.class, args);
	}

}
