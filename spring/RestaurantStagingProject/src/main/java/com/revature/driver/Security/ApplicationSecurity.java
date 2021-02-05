package com.revature.driver.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.driver.Filters.LoginFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    private AccountDetailsService accountDetails;
    private LoginFilter loginFilter;
    private ObjectMapper applicationObjectMapper;

    @Autowired
    public ApplicationSecurity(AccountDetailsService injectedUserDetailsService, ObjectMapper injectedObjectMapper, AuthenticationEventPublisher injectedAuthenticationEventPublisher){
        
        this.accountDetails = injectedUserDetailsService;
        this.loginFilter = null;
        this.applicationObjectMapper = injectedObjectMapper;
    }


    @Override 
    public void configure(HttpSecurity security) throws Exception {
        security
        .csrf() //disable csrf and cors to make postman testing possible. Will need proper cors cfg bean for finished auth service.
        .disable()
        .cors()
        .disable()
        .addFilterBefore( this.getLoginFilter(), UsernamePasswordAuthenticationFilter.class) //add login filter
        .authorizeRequests() //start authorization rules
        .antMatchers("actuator/*") //for consul
        .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(accountDetails);
    }


    public LoginFilter getLoginFilter() throws Exception{
        if(this.loginFilter == null)
            this.loginFilter = new LoginFilter(this.authenticationManager(), this.applicationObjectMapper);
        return this.loginFilter;
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    
}
