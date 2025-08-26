package com.agh.product_catalouge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductCatalougeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalougeApplication.class, args);
	}

}
