package com.zg.erguei_as_maos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Erguei as maos",
				version = "1.0.0"
		)
)
public class ErgueiAsMaosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErgueiAsMaosApplication.class, args);
	}


}
