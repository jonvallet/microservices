package com.nakedwines.services.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomersApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersApiApplication.class, args);
    }
}
