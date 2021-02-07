package com.revature.driver.Security;

import java.util.Optional;

import com.revature.driver.Entities.Users;
import com.revature.driver.Repositories.UserRepository;
import com.revature.driver.Security.Exceptions.EmptyAuthenticationFieldException;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService implements UserDetailsService {


    UserRepository userRepository;

    private AccountDetailsService(){

    }

    @Autowired
    public AccountDetailsService(UserRepository injectedUserRepository){
        this.userRepository = injectedUserRepository;
    }

    private AccountDetails convertUserEnityIntoUserDetails(Users userToConvert){
        
        AccountDetails convertedAccountDetails = null;

        if(userToConvert != null)
            convertedAccountDetails = new AccountDetails(userToConvert.getUsername(),userToConvert.getPassword());

        return convertedAccountDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stu
        AccountDetails discovereDetails = null;
        Optional<Users> discoveredUserOptional = null;
       
        discoveredUserOptional = this.userRepository.findById(username);

        if(!discoveredUserOptional.equals(Optional.empty()))
            discovereDetails = convertUserEnityIntoUserDetails(discoveredUserOptional.get());
            
        return discovereDetails;
    }
    
}
    