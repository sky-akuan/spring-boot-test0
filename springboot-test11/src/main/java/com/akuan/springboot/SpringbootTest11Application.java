package com.akuan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:redis.properties"})
public class SpringbootTest11Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTest11Application.class, args);
	}
}
