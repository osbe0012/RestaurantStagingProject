package com.revature.driver.Filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.driver.Security.Tokens.LoginToken;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


/**
 * The login filter is used to log users in. It's fairly similar to the Spring's
 * default filter, other than pulling the user details from the request body, as
 * opposed to uri params.
 */
@Component
public class LoginFilter extends HttpFilter {

    AuthenticationManager applicationAuthManager;
    ObjectMapper applicationObjectMapper;

    @Autowired
    public LoginFilter(AuthenticationManager injectedAuthManager, ObjectMapper injectedObjectMapper) {
        this.applicationAuthManager = injectedAuthManager;
        this.applicationObjectMapper = injectedObjectMapper;
    }

    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

       Authentication userAuthentication = null;
       LoginToken usersLoginToken = null;
       String requestUri = servletRequest.getRequestURI();
  
       if(requestUri.equals("/login"))
       {
            usersLoginToken = this.getLoginTokenFromBody(servletRequest);
            userAuthentication = new UsernamePasswordAuthenticationToken(usersLoginToken.username, usersLoginToken.password);
            userAuthentication = this.applicationAuthManager.authenticate(userAuthentication);

            if(userAuthentication.isAuthenticated())
                servletResponse.setStatus(200);
            else
                servletResponse.setStatus(401);
       }

       chain.doFilter(servletRequest, servletResponse);

            
    }


    public LoginToken getLoginTokenFromBody(HttpServletRequest request) throws IOException {
        String requestBody = IOUtils.toString(request.getReader());
        LoginToken userCredentialsToken = null;

        if(requestBody != null && !requestBody.equals(""))
            userCredentialsToken = this.applicationObjectMapper.readValue(requestBody,LoginToken.class);

        return userCredentialsToken;
    }

   
    
}
