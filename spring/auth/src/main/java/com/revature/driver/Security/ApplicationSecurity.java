package com.revature.driver.Security;

import com.revature.driver.Filters.ApplicationExceptionTranslationFilter;
import com.revature.driver.Filters.LoginFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**The ApplicationSecurity objects configures the Security settings of our application. */
@Configuration(value = "app-security")
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    private AccountDetailsService accountDetails;
    private LoginFilter loginFilter;
    private ApplicationExceptionTranslationFilter customExceptionFilter;

    @Autowired
    public ApplicationSecurity(AccountDetailsService injectedUserDetailsService){
        
        this.accountDetails = injectedUserDetailsService;
        this.loginFilter = null;
        this.customExceptionFilter = null;

    }

    //Need to use setter injection. Can't inject in cstr because of circular dep between Filter and AppSecurity
    @Autowired
    public void setLoginFilter(LoginFilter injectedLoginFilter){
        this.loginFilter = injectedLoginFilter;
    }

    @Autowired
    public void setCustomExceptionFilter(ApplicationExceptionTranslationFilter customExceptionFilter) {
        this.customExceptionFilter = customExceptionFilter;
    }

    @Bean 
    public AuthenticationEntryPoint getBasicAuthEntryPoint(){

        BasicAuthenticationEntryPoint entryPointBean = new BasicAuthenticationEntryPoint();
        entryPointBean.setRealmName("staging-project-app-realm");
        return entryPointBean;
    }


    @Override 
    public void configure(HttpSecurity security) throws Exception {
        security
        .csrf() //disable csrf and cors to make postman testing possible. Will need proper cors cfg bean for finished auth service.
        .disable()
        .cors()
        .disable()
        .addFilterAt(this.loginFilter,UsernamePasswordAuthenticationFilter.class) //replcce login filter in chain
        .addFilterAfter(this.customExceptionFilter, ExceptionTranslationFilter.class) // add custom exception transaltion after spring sec.
        .sessionManagement()
        .maximumSessions(1)
        .maxSessionsPreventsLogin(true) //if you login more than once, your old session id is expired
        .and()
        .and()
        .authorizeRequests()
        .antMatchers("/login")
        .permitAll()
        .antMatchers("/auth/customer/**")
        .hasAuthority("customer")
        .antMatchers("/auth/employee/**")
        .hasAuthority("employee")
        .antMatchers("/auth/manager/**")
        .hasAuthority("manager");
    }

    @Override
    public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.userDetailsService(accountDetails);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.
        ignoring().
        antMatchers("/actuator/**");
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    
}
