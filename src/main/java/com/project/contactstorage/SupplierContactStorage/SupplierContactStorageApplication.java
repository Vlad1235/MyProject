package com.project.contactstorage.SupplierContactStorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SupplierContactStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierContactStorageApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.project.contactstorage"))
				.build()
				.apiInfo(apiDetails());
	}


	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Supplier Contact Storage",
				"Simple REST API for working with Supplier information",
				"1.0",
				"Free of charge",
				new springfox.documentation.service.Contact("Vladislav", "https://github.com/Vlad1235", "https://github.com/Vlad1235"),
				"API Licence",
				"http://localhost:8080",
				Collections.emptyList());
	}
}
