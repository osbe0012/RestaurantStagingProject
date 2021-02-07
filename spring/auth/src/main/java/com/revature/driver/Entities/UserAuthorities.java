package com.revature.driver.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**The user authorities entity contains the authorities granted to a particular user. */
@Entity
@Table(name="user_authorities")
public class UserAuthorities {

    @Id
    @Column(updatable=false,insertable=true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long user_authority_id;
    String username;
    int user_authority;

    @JoinColumn(name="user_authority")
    @ManyToMany(fetch=FetchType.EAGER) //m-m for now, but may only need 1-m or 1-1
    List<Authority> users_authorities;
    
}
