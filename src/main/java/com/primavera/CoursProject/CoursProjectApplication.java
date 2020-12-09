package com.primavera.CoursProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoursProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursProjectApplication.class, args);
	}

}
