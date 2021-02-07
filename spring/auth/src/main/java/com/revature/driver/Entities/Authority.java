package com.revature.driver.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**The Authority class is connected to a lookup table that defines the possible authorities 
 * of our application.
*/
@Data
@Entity()
@Table(name="authority_lookup")
public class Authority {
    @Id
    @Column(insertable=true, updatable = false, nullable = false)
    int authority;
    @Column(insertable=true, updatable = false, nullable = false)
    String authority_description;
}
