package com.revature.driver.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.driver.Entities.Authority;
import com.revature.driver.Entities.UserAuthorities;
import com.revature.driver.Entities.Users;
import com.revature.driver.Repositories.UserRepository;
import com.revature.driver.Security.Exceptions.EmptyAuthenticationFieldException;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The AccountDetailsService fetches User objects from our data store through the injected UserRepository, 
 * and the AccountDetailsService converts that object into an AccountDetails, populating username, password, and a list 
 * of Authorities. 
 */
@Service
public class AccountDetailsService implements UserDetailsService {


    UserRepository userRepository;

    private AccountDetailsService(){

    }

    @Autowired
    public AccountDetailsService(UserRepository injectedUserRepository){
        this.userRepository = injectedUserRepository;
    }

    private List<GrantedAuthority> convertEntityAuthoritiesIntoGrantedAuthorities(Users persistedUser){
        List<GrantedAuthority> returnedUsersGrantedAuthorities = new ArrayList<GrantedAuthority>();
        List<UserAuthorities> persistedAuthorities = persistedUser.getAuthorities();
        GrantedAuthority persistedAuthorityIterator = null;
        
        if(persistedAuthorities != null)
            for(UserAuthorities persistedAuthority:persistedAuthorities)
            {
                persistedAuthorityIterator = new SimpleGrantedAuthority(persistedAuthority.getUserAuthority().getAuthority_description());
                returnedUsersGrantedAuthorities.add(persistedAuthorityIterator);
            }

        return returnedUsersGrantedAuthorities;
    }

    private AccountDetails convertUserEnityIntoUserDetails(Users userToConvert){
        
        AccountDetails convertedAccountDetails = null;
        List<GrantedAuthority> convertedAccountDetailsGrantedAuthorityList = null;


        if(userToConvert != null)
        {
            convertedAccountDetailsGrantedAuthorityList = convertEntityAuthoritiesIntoGrantedAuthorities(userToConvert);
            convertedAccountDetails = new AccountDetails(userToConvert.getUsername(),userToConvert.getPassword(), convertedAccountDetailsGrantedAuthorityList);
        }

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
    