package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PollingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollingSystemApplication.class, args);
	}

}
