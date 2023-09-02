package com.jcaboclo.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springdoc.core.GroupedOpenApi;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public GroupedOpenApi groupedOpenApi() {
		return GroupedOpenApi.builder()
				.group("api")
				.pathsToMatch("/api/**")
				.build();
	}

}
