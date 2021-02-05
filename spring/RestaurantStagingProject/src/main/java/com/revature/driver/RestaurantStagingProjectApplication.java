package com.revature.driver;

import com.revature.driver.Entities.Users;
import com.revature.driver.Repositories.UserRepository;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//@EnableDiscoveryClient //Connect app to consul
@EnableJpaRepositories // Enable jpa repositories and scan sub folders for repository interfaces.
public class RestaurantStagingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantStagingProjectApplication.class, args);
	}

}
