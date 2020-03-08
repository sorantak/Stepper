package com.codepresso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codepresso"})
public class StepperApplication {

	public static void main(String[] args) {
		SpringApplication.run(StepperApplication.class, args);
	}

}