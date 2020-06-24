package com.Bureau.ValidarCNPJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ValidarCnpjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidarCnpjApplication.class, args);
	}

}
