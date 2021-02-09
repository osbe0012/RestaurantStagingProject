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

/*The users entity is used to represent users in our application. This class is used strictly for authentication. 
More specific use cases, such as an employee or customer, as an example, will need to , in some way shape or form, 
extend this class.*/
@Data
@Entity(name="users")
@Table(name="users")
public class Users {
    @Id
    @Column(updatable= false, insertable=true) //can make new usernames but cannot update once they exist
    String username; 
    @Column(updatable=true, insertable=true, nullable=false)
    String password;
    @Column(updatable=true, insertable=true, nullable=false)
    boolean enabled;// is the account enabled or disabled.

    @JoinColumn(referencedColumnName ="username", name="username")
    @OneToMany(fetch = FetchType.EAGER)
    List<UserAuthorities> authorities;
}
