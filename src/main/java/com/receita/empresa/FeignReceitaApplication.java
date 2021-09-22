package com.receita.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignReceitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignReceitaApplication.class, args);
	}

}
