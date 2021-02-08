package com.revature.driver.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**The Authority class is connected to a lookup table that defines the possible authorities 
 * of our application.
*/
@Data
@Entity()
@Table(name="authority")
public class Authority {
    @Id
    @Column(insertable=true, updatable = false, nullable = false)
    int authority_id; //the unique integer id of an authority.
    @Column(insertable=true, updatable = false, nullable = false)
    String authority_description; //a string description of the authority like Manager, employee, and etc.
}
