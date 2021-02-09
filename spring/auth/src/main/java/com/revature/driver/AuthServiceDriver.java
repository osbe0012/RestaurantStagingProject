package com.revature.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableDiscoveryClient // Connect app to consul
@EnableJpaRepositories // Enable jpa repositories and scan sub folders for repository interfaces.
public class AuthServiceDriver 
{
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceDriver.class, args);
	}
}
