package com.nakedwines.services.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class ServiceRegistryApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
