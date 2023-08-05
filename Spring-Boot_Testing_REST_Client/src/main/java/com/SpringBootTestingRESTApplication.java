package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestingRESTApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingRESTApplication.class, args);
		System.out.println("Spring-Boot_Testing_REST_Client.. Running on port No: 8585...");
	}
}
