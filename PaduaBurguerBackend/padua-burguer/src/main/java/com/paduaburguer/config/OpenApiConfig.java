package com.paduaburguer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("RESTful API for Padua Burguer")
						.version("v1")
						.description("API for management and order requests for PaduaBurger")
						.termsOfService("")
						.license(new License().name("Apache 2.0")
							.url("http://paduaBurguer.com")));
	}
}
