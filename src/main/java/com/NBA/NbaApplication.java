package com.NBA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaApplication.class, args);

	}

}
