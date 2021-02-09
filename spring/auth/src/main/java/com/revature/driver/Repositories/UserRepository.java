package com.revature.driver.Repositories;

import com.revature.driver.Entities.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**The user repository is used to fetch User objects which are central in authenticating 
 * incoming requests.
 */
@Repository
public interface UserRepository extends CrudRepository<Users, String> {

    public Users findByUsername(String username);
    
}
