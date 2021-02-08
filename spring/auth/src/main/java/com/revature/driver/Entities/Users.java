package com.revature.driver.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/*The users entity is used to represent users in our application.*/
@Data
@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(updatable= false, insertable=true) //can make new usernames but cannot update once they exist
    String username;
    @Column(nullable  =false)
    String password;
    @Column(nullable = false)
    boolean enabled;

    @JoinColumn(referencedColumnName ="username", name="username")
    @OneToMany(fetch = FetchType.EAGER)
    List<UserAuthorities> authorities;
}
