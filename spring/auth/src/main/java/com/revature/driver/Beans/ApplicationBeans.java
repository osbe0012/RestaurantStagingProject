package com.revature.driver.Beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration(value = "applicationbeans")
public class ApplicationBeans {

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    @Bean
    @Deprecated()
    public PasswordEncoder getBcryptPasswordEncoder(){
        //return new BCryptPasswordEncoder(12);
        return NoOpPasswordEncoder.getInstance(); //makes testing easier
    }
    
}
