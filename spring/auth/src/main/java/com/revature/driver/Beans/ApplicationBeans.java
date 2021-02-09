package com.revature.driver.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



/** This class defines global Beans stored in th IOC container.*/
@Configuration(value = "applicationbeans")
public class ApplicationBeans {

    /**Returns singleton object mapper bean. */
    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    /**Returns application profile for apps in dev mode. */
    @Bean
    @Profile("local-dev")
    @Deprecated
    public PasswordEncoder getNoOpPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //makes testing easier leave in for now 
    }

    /**Returns application password encoder for production apps. */
    @Bean
    @Profile("production")
    @Deprecated()
    public PasswordEncoder getBcryptPasswordEncoder(){
        return new BCryptPasswordEncoder(12); 
    }
}
