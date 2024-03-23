package com.unica.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Unica", version = "1", description = "Cadastro único"))
@SpringBootApplication
public class UnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnicaApplication.class, args);
	}

}
