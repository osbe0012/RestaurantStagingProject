package com.revature.driver.Beans;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @RequestMapping(path="/auth/manager", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String testManagerAuthority(){
        return "Only an account with manager authority will be able to see this string!";
    }

    @RequestMapping(path="/auth/customer", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String testCustomerAuthority(){
        return "Only an account with customer authority will be able to see this string!";
    }

    @RequestMapping(path="/auth/employee", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String testEmployeeAuthority(){
        return "Only an account with employee authority will be able to see this string!";
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String login(){
        return "You logged in.";
    }

}
