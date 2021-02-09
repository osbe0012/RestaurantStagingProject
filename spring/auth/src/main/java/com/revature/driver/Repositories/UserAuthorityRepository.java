package com.revature.driver.Repositories;

import java.util.List;

import com.revature.driver.Entities.UserAuthorities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**The UserAuthorityRepository is used to fetch UserAuthority objects belonging to a single user. 
 * UserAuthority objects contain user to authority mappings, and one user can have many UserAuthorities.
 */
@Repository
public interface UserAuthorityRepository extends CrudRepository<UserAuthorities,String> {
    
    //Tells Spring data to execute this custom query for the method defined by findAllById
    @Query("select ua from user_authorities ua where ua.username = ?1")
    public List<UserAuthorities> findAllById(String username);
}
