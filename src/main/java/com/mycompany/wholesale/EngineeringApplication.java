package com.mycompany.wholesale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class EngineeringApplication {

	public static void main(String... args) {
		SpringApplication.run(EngineeringApplication.class, args);
	}
	
	@Bean

	   public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
	     return new OpenAPI()
	          .info(new Info()
	          .title("sample application API")
	          .version(appVersion)
	          .description(appDesciption)
	          .termsOfService("http://swagger.io/terms/")
	          .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	    }
}