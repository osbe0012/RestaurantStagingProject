package com.revature.driver.Security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** The AccountDetails class will be used to perform login authentication 
 * by the DaoAuthenticationProvider.
 */
public class AccountDetails implements UserDetails {

    private String username;
    private String password; 

    /**Make default cstr privage since it makes no sense to init this class without 
     * having the username and password fields set. 
     */
    private AccountDetails(){
        super();
    }

    /**Use this constructor to build an AccountDetails object. The Userdetails interface
     * has no setters, so username and password can be passed through the constructor.
     */
    public AccountDetails(String username,String password){
        super();
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return new ArrayList<GrantedAuthority>();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.username;
    }

    /*Auth providers use these functions to do additional authentication checks, on top of username and password matching.
      For now, resort to returning true for these functions, and if we decide to implement account locking, expiration, and etc,
      then we can add more functionality beyond method stubs.
     */
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
