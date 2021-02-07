package com.revature.driver.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
}
