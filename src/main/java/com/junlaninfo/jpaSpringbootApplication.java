package com.junlaninfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class jpaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new  SpringApplication(jpaSpringbootApplication.class);
        springApplication.run(args);
	}
}
