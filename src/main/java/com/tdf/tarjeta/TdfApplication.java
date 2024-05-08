package com.tdf.tarjeta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdfApplication.class, args);

		System.out.printf("hola tdf");
	}

}
