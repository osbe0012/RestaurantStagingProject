package com.revature.driver.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**The user authorities entity contains the authorities granted to a particular user. */
@Data
@Entity(name="user_authorities")
@Table(name="user_authorities")
public class UserAuthorities {

    @Id
    Integer user_authority_pk;    
    String username; //the user this authority belongs to.

    @JoinColumn(name="authority_id", referencedColumnName = "authority_id")
    @OneToOne(fetch = FetchType.EAGER)
    Authority userAuthority; //the mapped authority object to to this unique user_authority_pk
   
    
}
