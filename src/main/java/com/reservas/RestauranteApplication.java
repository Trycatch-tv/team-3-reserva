package com.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}

}
