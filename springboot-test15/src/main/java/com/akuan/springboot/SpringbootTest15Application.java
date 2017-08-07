package com.akuan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringbootTest15Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTest15Application.class, args);
	}
}
