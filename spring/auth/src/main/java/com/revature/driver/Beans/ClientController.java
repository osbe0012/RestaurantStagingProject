package com.revature.driver.Beans;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**This controller will ultimately use a web client to forward requests which have passed auth 
 * checks to the destination microservice, like the employee microservice or customer microservice
  */
@RestController
//fine for now add in feign client and associate functionality that allows the controller 
//to talk to microservices registered with consul.
public class ClientController {

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
