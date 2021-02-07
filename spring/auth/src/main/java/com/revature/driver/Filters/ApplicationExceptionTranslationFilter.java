package com.revature.driver.Filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.stereotype.Component;
@Component
@DependsOn("app-security")
public class ApplicationExceptionTranslationFilter extends ExceptionTranslationFilter {

   

    @Autowired
    public ApplicationExceptionTranslationFilter(AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationEntryPoint);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain){
        
        HttpServletRequest request = (HttpServletRequest) req; 
        HttpServletResponse response = (HttpServletResponse) res;

        try{
            if(response.getStatus() >= 400)
                response.getWriter().write(""); //Don't send giant stack trace to user. status code + empty body is enough.
            else
                chain.doFilter(request, response);
        } 
        catch(Exception e){
            response.setStatus(500);
        }
     }
    
}
